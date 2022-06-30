package edu.fiuba.algo3;

import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class MoverseALaDerechaEventHandler implements EventHandler<ActionEvent>{
    JugadorVista jugadorFigura;

    public MoverseALaDerechaEventHandler(JugadorVista jugadorFiguraDado){
        this.jugadorFigura = jugadorFiguraDado;
    }

    @Override
    public void handle(ActionEvent event){
        this.jugadorFigura.moverDerecha();
        this.jugadorFigura.update();
    }
}
