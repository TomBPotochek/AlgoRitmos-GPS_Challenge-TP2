package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.vehiculos.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import edu.fiuba.algo3.modelo.excepciones.JuegoFinalizadoException;
import edu.fiuba.algo3.modelo.excepciones.PosicionInvalidaError;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.movimientos.Posicion;
import edu.fiuba.algo3.modelo.movimientos.MovAbajo;
import edu.fiuba.algo3.modelo.movimientos.MovArriba;
import edu.fiuba.algo3.modelo.movimientos.MovDerecha;
import edu.fiuba.algo3.modelo.movimientos.MovIzquierda;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

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

    String botonNormal = "-fx-border-width: 2px; -fx-border-color: #80CEB9; -fx-background-color: transparent; -fx-text-fill: #80CEB9";
    String botonAntesDeSerPresionado = "-fx-border-width: 2px; -fx-border-color: #80CEB9; -fx-background-color: #717D8C; -fx-text-fill: #BDB69C";
    String formatoTexto = "-fx-border-width: 0px; -fx-border-color: #80CEB9; -fx-background-color: transparent; -fx-text-fill: #80CEB9";
    public JugadorVista(Juego juegoDado, Canvas canvasDado, Tablero tablero,Stage stage, Scene pantallaInicio) {
        this.canvas = canvasDado;
        this.tablero = tablero;
        this.juego = juegoDado;
        this.jugadorFigura = new Rectangle(10, 10, Color.RED);
        this.offsetX = 70;
        this.offsetY = 70;
		this.posicionX = this.offsetX; //40
        this.posicionY = this.offsetY; //45
        this.jugadorFigura.setX(posicionX);
        this.jugadorFigura.setY(posicionY);
        this.pantallaInicio = pantallaInicio;
        this.stage = stage;
        //canvas.getGraphicsContext2D().setFill(Color.RED);
        this.ponerFotoVehiculo();
        canvas.getGraphicsContext2D().fillOval(posicionX, posicionY, 20, 20);
    }

    public Rectangle getDibujo(){
        return jugadorFigura;
    }

    private void ponerFotoVehiculo(){
        switch(this.juego.obtenerTipoVehiculo().getSimpleName()){
            case "Auto":
                this.jugadorFigura.setStyle("-fx-background-color: #ff0000");
                break;
            case "Moto":
                this.jugadorFigura.setStyle("-fx-background-color: #00ff00");
                break;
            default:
                this.jugadorFigura.setStyle("-fx-background-color: #0000ff");
        }
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
			// this.posicionX = this.offsetX + (this.juego.obtenerPosicionVehiculo().getColumna() - 1) * 50;
            actualizarPosicion();
        } catch(JuegoFinalizadoException e) {
            this.terminarJuego();
			// Lanzar un mensaje. Conviene mas atrapar la excepcion en
			// el switch case de los movimientos?---> No sé

		}
    }


    public void moverIzquierda(){
		try {
			this.juego.mover(new MovIzquierda());
			// this.posicionX = this.offsetX + (this.juego.obtenerPosicionVehiculo().getColumna() - 1) * 50;
            actualizarPosicion();
        } catch(JuegoFinalizadoException e) {
            this.terminarJuego();
        }
    }


    public void moverAbajo(){
		try {
			this.juego.mover(new MovAbajo());
			// this.posicionY = this.offsetY + (this.juego.obtenerPosicionVehiculo().getFila() - 1) * 50;
            actualizarPosicion();
        } catch(JuegoFinalizadoException e) {
            this.terminarJuego();
        }
    }


    public void moverArriba(){
		try {
			this.juego.mover(new MovArriba());
			// this.posicionY = this.offsetY + (this.juego.obtenerPosicionVehiculo().getFila() - 1) * 50;
            actualizarPosicion();
        } catch(JuegoFinalizadoException e) {
            this.terminarJuego();
        }
    }


    private void dibujarFormas() {
        //this.clean();

        //this.jugadorFigura.setX(posicionX);
        //this.jugadorFigura.setY(posicionY);

        // this.clean();
        // canvas.getGraphicsContext2D().setFill(Color.RED);
        // canvas.getGraphicsContext2D().fillOval(posicionX, posicionY, 20, 20);

        tablero.moverJugadorA(posicionX, posicionY, this.getDibujo());
    }

    public void clean() {
        canvas.getGraphicsContext2D().setFill(Color.WHITE);
        //Color.rgb(47, 52, 58)
        //tamaño del canvas 900 700
        canvas.getGraphicsContext2D().fillRect(0, 0, 900, 700);
    }

    public void update() {
        this.dibujar();
    }

    private void terminarJuego() {
        Stage ventanaVolver = new Stage();
        ventanaVolver.setResizable(false);
        ventanaVolver.setTitle("Volver al Menu");

        Label texto = new Label("¡Enhorabuena! Llegaste a la meta.");
        texto.setFont(Font.font("Impact", 25));
        //texto.setGraphic(new ImageView(new Image("file:src/main/java/edu/fiuba/algo3/imagenes/bandera.png")));
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

