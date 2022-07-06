package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.vehiculos.Direccion;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class MoverseArribaEventHandler implements EventHandler<ActionEvent>{
    JugadorVista jugadorFigura;

    public MoverseArribaEventHandler(JugadorVista jugadorFiguraDado){
        this.jugadorFigura = jugadorFiguraDado;
    }

    @Override
    public void handle(ActionEvent event){
        this.jugadorFigura.mover(Direccion.arriba());
        this.jugadorFigura.update();
    }
}
