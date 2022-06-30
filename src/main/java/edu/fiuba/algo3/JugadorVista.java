package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.vehiculos.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import edu.fiuba.algo3.modelo.excepciones.JuegoFinalizadoException;
import edu.fiuba.algo3.modelo.excepciones.PosicionInvalidaError;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.movimientos.MovAbajo;
import edu.fiuba.algo3.modelo.movimientos.MovArriba;
import edu.fiuba.algo3.modelo.movimientos.MovDerecha;
import edu.fiuba.algo3.modelo.movimientos.MovIzquierda;
import edu.fiuba.algo3.modelo.movimientos.Posicion;

public class JugadorVista {
    private Juego juego;
    Rectangle jugadorFigura;

    int posicionX;
    int posicionY;

    public JugadorVista(Juego juegoDado) {
        this.juego = juegoDado;
        this.jugadorFigura = new Rectangle(10, 10, Color.RED);
        this.posicionX = 40;
        this.posicionY = 45;
        this.jugadorFigura.setX(posicionX);
        this.jugadorFigura.setY(posicionY);
    }

    public Rectangle getDibujo(){
        return jugadorFigura;
    }

    public void dibujar() {
        this.dibujarFormas();
    }

    public void moverDerecha(){
        try{
            this.juego.mover(new MovDerecha());
            this.posicionX = this.posicionX + 50;
        } catch(JuegoFinalizadoException | PosicionInvalidaError e){

        }
    }

    public void moverIzquierda(){
        try{
            this.juego.mover(new MovIzquierda());
            this.posicionX = this.posicionX - 50;
        } catch(JuegoFinalizadoException | PosicionInvalidaError e){
            
        }
    }

    public void moverAbajo(){
        try{
            this.juego.mover(new MovAbajo());
            this.posicionY = this.posicionY + 50;
        } catch(JuegoFinalizadoException | PosicionInvalidaError e){
            
        }
    }

    public void moverArriba(){
        try{
            this.juego.mover(new MovArriba());
            this.posicionY = this.posicionY - 50;
        } catch(JuegoFinalizadoException | PosicionInvalidaError e){
            
        }
    }

    private void dibujarFormas() {
        //this.clean();

        this.jugadorFigura.setX(posicionX);
        this.jugadorFigura.setY(posicionY);
        
        //this.getChildren().add(cuadra);

        //canvas.getGraphicsContext2D().setFill(Color.RED);
        //canvas.getGraphicsContext2D().fillOval(jugador.getPosicion().getFila() + 230, jugador.getPosicion().getColumna() + 110, 20, 20);
    }

    // public void clean() {
    //     canvas.getGraphicsContext2D().setFill(Color.rgb(38, 121, 142));
    //     canvas.getGraphicsContext2D().fillRect(0, 0, 460, 220);
    // }

    public void update() {
        this.dibujar();
    }
}
