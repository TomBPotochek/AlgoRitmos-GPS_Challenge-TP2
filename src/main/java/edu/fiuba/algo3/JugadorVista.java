package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.vehiculos.*;
import javafx.scene.canvas.Canvas;
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

public class JugadorVista {
    private Juego juego;
    Rectangle jugadorFigura;

    Canvas canvas;

    int posicionX;
    int posicionY;
	int offsetX;
	int offsetY;

    public JugadorVista(Juego juegoDado, Canvas canvasDado) {
        this.canvas = canvasDado;
        this.juego = juegoDado;
        this.jugadorFigura = new Rectangle(10, 10, Color.RED);
        this.offsetX = 300;
        this.offsetY = 300;
		this.posicionX = this.offsetX; //40
        this.posicionY = this.offsetY; //45
        this.jugadorFigura.setX(posicionX);
        this.jugadorFigura.setY(posicionY);

        canvas.getGraphicsContext2D().setFill(Color.RED);
        canvas.getGraphicsContext2D().fillOval(posicionX, posicionY, 20, 20);
    }

    public Rectangle getDibujo(){
        return jugadorFigura;
    }


    public void dibujar() {
        this.dibujarFormas();
    }


    public void moverDerecha(){
		try {
			this.juego.mover(new MovDerecha());
			this.posicionX = this.offsetX + (this.juego.obtenerPosicionVehiculo().getColumna() - 1) * 50;

        } catch(JuegoFinalizadoException e) {
			// Lanzar un mensaje. Conviene mas atrapar la excepcion en
			// el switch case de los movimientos?
		}
    }


    public void moverIzquierda(){
		try {
			this.juego.mover(new MovIzquierda());
			this.posicionX = this.offsetX - (this.juego.obtenerPosicionVehiculo().getColumna() - 1) * 50;

        } catch(JuegoFinalizadoException e) {}
    }


    public void moverAbajo(){
		try {
			this.juego.mover(new MovAbajo());
			this.posicionY = this.offsetY + (this.juego.obtenerPosicionVehiculo().getFila() - 1) * 50;

        } catch(JuegoFinalizadoException e) {}
    }


    public void moverArriba(){
		try {
			this.juego.mover(new MovArriba());
			this.posicionY = this.offsetY - (this.juego.obtenerPosicionVehiculo().getFila() - 1) * 50;

        } catch(JuegoFinalizadoException e) {}
    }


    private void dibujarFormas() {
        //this.clean();

        //this.jugadorFigura.setX(posicionX);
        //this.jugadorFigura.setY(posicionY);

        this.clean();
        canvas.getGraphicsContext2D().setFill(Color.RED);
        canvas.getGraphicsContext2D().fillOval(posicionX, posicionY, 20, 20);
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

    private Boolean posicionJugadorValida(int posicionDadaX, int posicionDadaY){
        if((posicionDadaX < 0) || (posicionDadaX > 850) || (posicionDadaY < 0) || (posicionDadaY > 600)){
            return false;
        }
        return true;
    }
}
