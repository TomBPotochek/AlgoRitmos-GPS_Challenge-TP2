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

    Canvas canvas;

    int posicionX;
    int posicionY;

    public JugadorVista(Juego juegoDado, Canvas canvasDado) {
        this.canvas = canvasDado;
        this.juego = juegoDado;
        this.jugadorFigura = new Rectangle(10, 10, Color.RED);
        this.posicionX = 0; //0 --> minimo | 850 ---> maximo
        this.posicionY = 0; //0 --> minimo | 600 --> maximo
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
        this.juego.mover(new MovDerecha());
        if(this.posicionJugadorValida(posicionX + 50, posicionY)){
            this.posicionX = this.posicionX + 50;
        }
        // try{
        // } catch(JuegoFinalizadoException | PosicionInvalidaError e){

        // }
    }

    public void moverIzquierda(){
        this.juego.mover(new MovIzquierda());
        if(this.posicionJugadorValida(posicionX - 50, posicionY)){
            this.posicionX = this.posicionX - 50;
        }
        // try{
        // } catch(JuegoFinalizadoException | PosicionInvalidaError e){
            
        // }
    }

    public void moverAbajo(){
        this.juego.mover(new MovAbajo());
        if(this.posicionJugadorValida(posicionX, posicionY + 50)){
            this.posicionY = this.posicionY + 50;
        }
        // try{
        // } catch(JuegoFinalizadoException e){
            
        // }
    }

    public void moverArriba(){
        this.juego.mover(new MovArriba());
        if(this.posicionJugadorValida(posicionX, posicionY - 50)){
            this.posicionY = this.posicionY - 50;
        }
        // try{
        // } catch(JuegoFinalizadoException | PosicionInvalidaError e){
            
        // }
    }

    private void dibujarFormas() {
        //this.clean();

        //this.jugadorFigura.setX(posicionX);
        //this.jugadorFigura.setY(posicionY);

        this.clean();
        canvas.getGraphicsContext2D().setFill(Color.RED);
        canvas.getGraphicsContext2D().fillOval(posicionX, posicionY, 20, 20);
        
        //this.getChildren().add(cuadra);

        //canvas.getGraphicsContext2D().setFill(Color.RED);
        //canvas.getGraphicsContext2D().fillOval(jugador.getPosicion().getFila() + 230, jugador.getPosicion().getColumna() + 110, 20, 20);
    }

    public void clean() {
        canvas.getGraphicsContext2D().setFill(Color.WHITE);
        //Color.rgb(47, 52, 58)
        //tamaño del canvas 900 700
        canvas.getGraphicsContext2D().fillRect(0, 0, 900, 700);
    }

    // public void clean() {
    //     canvas.getGraphicsContext2D().setFill(Color.rgb(38, 121, 142));
    //     canvas.getGraphicsContext2D().fillRect(0, 0, 460, 220);
    // }

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
