package edu.fiuba.algo3;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class MovDerechaEventHandlerKey implements EventHandler<KeyEvent> {
    JugadorVista jugadorFigura;
    public MovDerechaEventHandlerKey(JugadorVista jugadorFiguraDado){
        this.jugadorFigura = jugadorFiguraDado;
    }

    public void handle(KeyEvent event){
        this.jugadorFigura.moverDerecha();
        this.jugadorFigura.update();
    }
}
