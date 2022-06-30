package edu.fiuba.algo3;

import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class MoverseALaIzquierdaEventHandler implements EventHandler<ActionEvent>{
    JugadorVista jugadorFigura;

    public MoverseALaIzquierdaEventHandler(JugadorVista jugadorFiguraDado){
        this.jugadorFigura = jugadorFiguraDado;
    }

    @Override
    public void handle(ActionEvent event){
        this.jugadorFigura.moverIzquierda();
        this.jugadorFigura.update();
    }
}