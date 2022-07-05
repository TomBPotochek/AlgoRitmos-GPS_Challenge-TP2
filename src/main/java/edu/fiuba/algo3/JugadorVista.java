package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.juego.Ranking;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import edu.fiuba.algo3.modelo.excepciones.JuegoFinalizadoException;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.movimientos.MovAbajo;
import edu.fiuba.algo3.modelo.movimientos.MovArriba;
import edu.fiuba.algo3.modelo.movimientos.MovDerecha;
import edu.fiuba.algo3.modelo.movimientos.MovIzquierda;
import edu.fiuba.algo3.modelo.casillero.ElementoMapa;
import edu.fiuba.algo3.modelo.movimientos.Posicion;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.media.AudioClip;
import java.util.ArrayList;


public class JugadorVista {
    private Juego juego;
    private Scene pantallaInicio;
    private Stage stage;
    Rectangle jugadorFigura;

    Canvas canvas;
    Tablero tablero;

    int posicionX;
    int posicionY;
	int offsetX;
	int offsetY;
	AudioClip musicaPrincipal;
    Label marcadorPuntaje;
    String botonNormal = "-fx-border-width: 2px; -fx-border-color: #80CEB9; -fx-background-color: transparent; -fx-text-fill: #80CEB9";
    String botonAntesDeSerPresionado = "-fx-border-width: 2px; -fx-border-color: #80CEB9; -fx-background-color: #717D8C; -fx-text-fill: #BDB69C";
    String formatoTexto = "-fx-border-width: 0px; -fx-border-color: #80CEB9; -fx-background-color: transparent; -fx-text-fill: #80CEB9";
    public JugadorVista(Juego juegoDado, Canvas canvasDado, Tablero tablero,Stage stage, Scene pantallaInicio, Label marcadorPuntaje) {
        this.canvas = canvasDado;
        this.tablero = tablero;
        this.juego = juegoDado;
        this.jugadorFigura = new Rectangle(10, 10, Color.BLUE);
        this.offsetX = 70;
        this.offsetY = 70;
		this.posicionX = this.offsetX; //40
        this.posicionY = this.offsetY; //45
        this.jugadorFigura.setX(posicionX);
        this.jugadorFigura.setY(posicionY);
        this.pantallaInicio = pantallaInicio;
        this.stage = stage;
        this.ponerFotoVehiculo();
        this.marcadorPuntaje = marcadorPuntaje;
        canvas.getGraphicsContext2D().fillOval(posicionX, posicionY, 20, 20);
		this.musicaPrincipal = new AudioClip("file:src/main/java/edu/fiuba/algo3/sonidos/mario.mp3");
		this.musicaPrincipal.setCycleCount(-1); // reproduce en loop
		this.musicaPrincipal.setVolume(0.25);
		this.musicaPrincipal.play();
    }

    public Rectangle getDibujo(){
        return jugadorFigura;
    }

    private void ponerFotoVehiculo(){
        switch(this.juego.obtenerTipoVehiculo().getSimpleName()){
            case "Auto":
                this.jugadorFigura = new Rectangle(30, 30, Color.YELLOW);
                Image fotoAuto = new Image("file:src/main/java/edu/fiuba/algo3/imagenes/icono-auto.png");
                jugadorFigura.setFill(new ImagePattern(fotoAuto));
                break;
            case "Moto":
                this.jugadorFigura = new Rectangle(30, 30, Color.GREEN);
                Image fotoMoto = new Image("file:src/main/java/edu/fiuba/algo3/imagenes/icono-moto.png");
                jugadorFigura.setFill(new ImagePattern(fotoMoto));
                break;
            default:
                this.jugadorFigura = new Rectangle(30, 30, Color.WHITE);
                Image fotoCuatroPorCuatro = new Image("file:src/main/java/edu/fiuba/algo3/imagenes/icono-cuatro-por-cuatro.png");
                jugadorFigura.setFill(new ImagePattern(fotoCuatroPorCuatro));
        }

        tablero.moverJugadorA(0, 0, this.getDibujo());
    }

    public void dibujar() {
        this.dibujarFormas();
    }

    private void actualizarPosicion(){
        this.posicionY = this.juego.obtenerPosicionVehiculo().getColumna() - 1;
        this.posicionX = this.juego.obtenerPosicionVehiculo().getFila() - 1;
    }


    public void moverDerecha(){
		try {
			this.juego.mover(new MovDerecha());
			this.reproducirEfectoSonido();
			// this.posicionX = this.offsetX + (this.juego.obtenerPosicionVehiculo().getColumna() - 1) * 50;
            actualizarPosicion();
        } catch(JuegoFinalizadoException e) {
            this.terminarJuego();
		}
    }


	public void moverIzquierda(){
		try {
			this.juego.mover(new MovIzquierda());
			this.reproducirEfectoSonido();
			// this.posicionX = this.offsetX + (this.juego.obtenerPosicionVehiculo().getColumna() - 1) * 50;
            actualizarPosicion();
        } catch(JuegoFinalizadoException e) {
            this.terminarJuego();
        }
    }


    public void moverAbajo(){
		try {
			this.juego.mover(new MovAbajo());
			this.reproducirEfectoSonido();
			// this.posicionY = this.offsetY + (this.juego.obtenerPosicionVehiculo().getFila() - 1) * 50;
            actualizarPosicion();
        } catch(JuegoFinalizadoException e) {
            this.terminarJuego();
        }
    }


    public void moverArriba(){
		try {
			this.juego.mover(new MovArriba());
			this.reproducirEfectoSonido();
			// this.posicionY = this.offsetY + (this.juego.obtenerPosicionVehiculo().getFila() - 1) * 50;
            actualizarPosicion();
        } catch(JuegoFinalizadoException e) {
            this.terminarJuego();
        }
    }
	
	
	private void reproducirEfectoSonido() {
		Posicion posVehiculo = this.juego.obtenerPosicionVehiculo();
		Posicion posMeta = this.juego.obtenerPosicionMeta();
		ArrayList<ElementoMapa> efectos = this.juego.obtenerElementos(posVehiculo);
		String sonidoGanador = "file:src/main/java/edu/fiuba/algo3/sonidos/ganador2.mp3";
		String sonidoObstaculo = "file:src/main/java/edu/fiuba/algo3/sonidos/obstaculo.mp3";
		
		if (posVehiculo.equals(posMeta)) {
			//reproducir ganador
			this.musicaPrincipal.stop();
			this.musicaPrincipal = new AudioClip(sonidoGanador);
			musicaPrincipal.play();

		}
		else if (efectos.size() > 0) {
			//reproducir efecto
			AudioClip sonido = new AudioClip(sonidoObstaculo);
			sonido.play();
		}

	
	}


    private void dibujarFormas() {
        int puntaje = juego.getCantMovimientosJugadorActual();
        this.marcadorPuntaje.setText(String.format("Puntaje : %d",puntaje));
        tablero.moverJugadorA(posicionX, posicionY, this.getDibujo());
    }

    public void clean() {
        canvas.getGraphicsContext2D().setFill(Color.WHITE);
        canvas.getGraphicsContext2D().fillRect(0, 0, 900, 700);
    }

    public void update() {
        this.dibujar();
    }

    private void terminarJuego() {
        Ranking ranking = Ranking.getRanking();
        int puntaje = juego.getCantMovimientosJugadorActual();
        ranking.registrarJugador(juego.obtenerNombre(),puntaje);

        Stage ventanaVolver = new Stage();
        ventanaVolver.setResizable(false);
        ventanaVolver.setTitle("Volver al Menu");

        Label texto = new Label("¡Enhorabuena! Llegaste a la meta.");
        texto.setFont(Font.font("Impact", 25));
        texto.setStyle(formatoTexto);

        Button botonVolver = new Button("Volver al Menu Principal");
        botonVolver.setFont(Font.font("Impact", 25));
        botonVolver.setStyle(botonNormal);
        botonVolver.setOnMouseEntered(e -> botonVolver.setStyle(botonAntesDeSerPresionado));
        botonVolver.setOnMouseExited(e -> botonVolver.setStyle(botonNormal));

        VBox menuVolver = new VBox(20);

        ventanaVolver.setMinWidth(280);
        ventanaVolver.initModality(Modality.APPLICATION_MODAL);

        menuVolver.getChildren().addAll(texto,botonVolver);
        menuVolver.setAlignment(Pos.CENTER);
        menuVolver.setStyle("-fx-border-color: #2F343A; -fx-background-color: #2F343A");

        botonVolver.setOnAction(e -> {
            this.musicaPrincipal.stop();
			stage.setScene(pantallaInicio);
            ventanaVolver.close();
        });

        Scene escenaVolver = new Scene(menuVolver , 580 , 300);
        Image logo = new Image("file:src/main/java/edu/fiuba/algo3/imagenes/logo-gps-challenge.png");
        ventanaVolver.getIcons().add(logo);
        ventanaVolver.setScene(escenaVolver);
        ventanaVolver.showAndWait();

    }
}

