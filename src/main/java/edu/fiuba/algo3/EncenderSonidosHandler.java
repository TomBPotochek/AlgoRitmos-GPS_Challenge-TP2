package edu.fiuba.algo3;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class EncenderSonidosHandler implements EventHandler<ActionEvent> {

    private JugadorVista jugadorVista;
    public EncenderSonidosHandler(JugadorVista jugadorVista) {
        this.jugadorVista = jugadorVista;
    }
    public void handle(ActionEvent actionEvent) {
        jugadorVista.encenderMusica();
    }

}
