package edu.fiuba.algo3;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class SilenciarSonidosHandler implements EventHandler<ActionEvent> {

    private JugadorVista jugadorVista;

    public SilenciarSonidosHandler(JugadorVista jugadorVista){
        this.jugadorVista = jugadorVista;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        jugadorVista.silenciarMusica();
    }
}
