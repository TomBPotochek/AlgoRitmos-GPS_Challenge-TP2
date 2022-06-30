package edu.fiuba.algo3;

import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class MoverseAbajoEventHandler implements EventHandler<ActionEvent>{
    JugadorVista jugadorFigura;

    public MoverseAbajoEventHandler(JugadorVista jugadorFiguraDado){
        this.jugadorFigura = jugadorFiguraDado;
    }

    @Override
    public void handle(ActionEvent event){
        this.jugadorFigura.moverAbajo();
        this.jugadorFigura.update();
    }
}
