package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.movimientos.MovAbajo;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class MovAbajoEventHandlerKey implements EventHandler<KeyEvent> {

    JugadorVista jugadorFigura;
    public MovAbajoEventHandlerKey(JugadorVista jugadorFiguraDado){
        this.jugadorFigura = jugadorFiguraDado;
    }

    public void handle(KeyEvent event){
        this.jugadorFigura.moverAbajo();
        this.jugadorFigura.update();
    }
}
