package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.movimientos.MovIzquierda;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class MovIzquierdaEventHandlerKey implements EventHandler<KeyEvent> {

    JugadorVista jugadorFigura;
    public MovIzquierdaEventHandlerKey(JugadorVista jugadorFiguraDado){
        this.jugadorFigura = jugadorFiguraDado;
    }

    public void handle(KeyEvent event){
        this.jugadorFigura.moverIzquierda();
        this.jugadorFigura.update();
    }
}