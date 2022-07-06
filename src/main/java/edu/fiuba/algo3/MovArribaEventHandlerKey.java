package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.vehiculos.Direccion;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class MovArribaEventHandlerKey implements EventHandler<KeyEvent> {

    JugadorVista jugadorFigura;
    public MovArribaEventHandlerKey(JugadorVista jugadorFiguraDado){
        this.jugadorFigura = jugadorFiguraDado;
    }

    public void handle(KeyEvent event){
        this.jugadorFigura.mover(Direccion.arriba());
        this.jugadorFigura.update();
    }
}
