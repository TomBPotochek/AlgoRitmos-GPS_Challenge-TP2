package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.movimientos.Direccion;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class MoverseALaDerechaEventHandler implements EventHandler<ActionEvent>{
    JugadorVista jugadorFigura;

    public MoverseALaDerechaEventHandler(JugadorVista jugadorFiguraDado){
        this.jugadorFigura = jugadorFiguraDado;
    }

    @Override
    public void handle(ActionEvent event){
        this.jugadorFigura.mover(Direccion.derecha());
        this.jugadorFigura.update();
    }
}
