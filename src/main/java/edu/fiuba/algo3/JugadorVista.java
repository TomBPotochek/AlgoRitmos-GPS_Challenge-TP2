package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.juego.Ranking;
import edu.fiuba.algo3.modelo.movimientos.*;
import edu.fiuba.algo3.modelo.vehiculos.Posicion;
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
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.Logging.Logger;
import edu.fiuba.algo3.modelo.casillero.ElementosMapa.ElementoMapa;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.media.MediaPlayer;

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
		//Para La musica del menu.
		ReproductorMusica.getReproductor().getMusicaMenu().stop();	
		MediaPlayer musicaPrincipal = ReproductorMusica.getReproductor().getMusicaJugando();
		musicaPrincipal.setCycleCount(-1); // reproduce en loop
		musicaPrincipal.setVolume(0.5);
		musicaPrincipal.play();
	}

    public Rectangle getDibujo(){
        return jugadorFigura;
    }

    private void ponerFotoVehiculo(){
        switch(this.juego.obtenerTipoVehiculo().getSimpleName()){
			case "Auto":
                this.jugadorFigura = new Rectangle(30, 30, Color.YELLOW);
                String pathImagenAuto = this.getClass().getResource("/imagenes/icono-auto.png").toString();
                jugadorFigura.setFill(new ImagePattern(new Image(pathImagenAuto)));
                break;
            
			case "Moto":
                this.jugadorFigura = new Rectangle(30, 30, Color.GREEN);
                String pathImagenMoto = this.getClass().getResource("/imagenes/icono-moto.png").toString();
                jugadorFigura.setFill(new ImagePattern(new Image(pathImagenMoto)));
                break;

            default:
                this.jugadorFigura = new Rectangle(30, 30, Color.WHITE);
                String pathImagen4x4 = this.getClass().getResource("/imagenes/icono-cuatro-por-cuatro.png").toString();
                jugadorFigura.setFill(new ImagePattern(new Image(pathImagen4x4)));
        }

        tablero.moverJugadorA(0, 0, this.getDibujo());
    }

    private void actualizarFotoVehiculo(){
        Logger.log(String.format("\ntipo de vehiculo: %s \n", this.juego.obtenerTipoVehiculo().getSimpleName()));
        switch(this.juego.obtenerTipoVehiculo().getSimpleName()){
            case "Auto":
                this.jugadorFigura = new Rectangle(30, 30, Color.YELLOW);
                String pathImagenAuto = this.getClass().getResource("/imagenes/icono-auto.png").toString();
                this.jugadorFigura.setFill(new ImagePattern(new Image(pathImagenAuto)));
                break;
            case "Moto":
                this.jugadorFigura = new Rectangle(30, 30, Color.GREEN);
                String pathImagenMoto = this.getClass().getResource("/imagenes/icono-moto.png").toString();
                this.jugadorFigura.setFill(new ImagePattern(new Image(pathImagenMoto)));
                break;
            default:
                this.jugadorFigura = new Rectangle(30, 30, Color.WHITE);
                String pathImagen4x4 = this.getClass().getResource("/imagenes/icono-cuatro-por-cuatro.png").toString();
                this.jugadorFigura.setFill(new ImagePattern(new Image(pathImagen4x4)));
        }

        tablero.moverJugadorA(posicionX, posicionY, this.getDibujo());
    }

    public void dibujar() {
        this.dibujarFormas();
    }

    private void actualizarPosicion(){
        this.posicionY = this.juego.obtenerPosicionVehiculo().getColumna() - 1;
        this.posicionX = this.juego.obtenerPosicionVehiculo().getFila() - 1;
    }

    public void mover(Movimiento movimiento){
		this.juego.mover(movimiento);
		this.reproducirEfectoSonido();
		this.actualizarPosicion();
		
		if(juego.estaFinalizado()){
            this.update();
            this.terminarJuego();
		}
	}

	private void reproducirEfectoSonido() {
		Posicion posVehiculo = this.juego.obtenerPosicionVehiculo();
		Posicion posMeta = this.juego.obtenerPosicionMeta();
		ArrayList<ElementoMapa> efectos = this.juego.obtenerElementos(posVehiculo);
		
		if (posVehiculo.equals(posMeta)) {
			//reproducir sonido meta
			ReproductorMusica.getReproductor().getMusicaJugando().stop();
			ReproductorMusica.getReproductor().getMusicaMeta().play();
		}
		else if (efectos.size() > 0) {
			//reproducir efecto
			ReproductorMusica.getReproductor().getMusicaObstaculo().stop();
			ReproductorMusica.getReproductor().getMusicaObstaculo().play();
		}

	
	}


    private void dibujarFormas() {
        int puntaje = juego.getCantMovimientosJugadorActual();
        this.marcadorPuntaje.setText(String.format("Puntaje: \n%d",puntaje));
        this.actualizarFotoVehiculo();
        tablero.moverJugadorA(posicionX, posicionY, this.getDibujo());
    }

    public void clean() {
        canvas.getGraphicsContext2D().setFill(Color.WHITE);
        canvas.getGraphicsContext2D().fillRect(0, 0, 900, 700);
    }

    public void update() {
        this.dibujar();
    }

	public void salirDelJuego() {
		ReproductorMusica.getReproductor().getMusicaJugando().stop();	
		ReproductorMusica.getReproductor().getMusicaMeta().stop();	
		ReproductorMusica.getReproductor().getMusicaMenu().play();	
		stage.setScene(pantallaInicio);
	}

    public boolean llegoAlFinal(){
        return juego.estaFinalizado();
    }
    public void terminarJuego() {
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
			this.salirDelJuego();
			ventanaVolver.close();
        });

        Scene escenaVolver = new Scene(menuVolver , 580 , 300);
		String pathLogoGpsChallenge = this.getClass().getResource("/imagenes/logo-gps-challenge.png").toString();
        ventanaVolver.getIcons().add(new Image(pathLogoGpsChallenge));
        ventanaVolver.setScene(escenaVolver);
        ventanaVolver.showAndWait();

    }

    public void silenciarMusica() {
        ReproductorMusica.getReproductor().getMusicaJugando().setMute(true);
    }
	
    public void encenderMusica() {
		ReproductorMusica.getReproductor().getMusicaJugando().setMute(false);
    }
}

