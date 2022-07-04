package edu.fiuba.algo3;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Controles implements EventHandler<KeyEvent> {
    private Stage stage;
    private JugadorVista jugadorVista;

    public Controles(Stage stage, JugadorVista jugadorVista) {
        this.stage = stage;
        this.jugadorVista = jugadorVista;
    }

    public void handle(KeyEvent keyEvent) {
        EventHandler<KeyEvent> mov;
        switch (keyEvent.getCode()) {
            case W:
                mov = new MovArribaEventHandlerKey(jugadorVista);
                mov.handle(keyEvent);
                break;
            case S:
                mov = new MovAbajoEventHandlerKey(jugadorVista);
                mov.handle(keyEvent);
                break;
            case D:
                mov = new MovDerechaEventHandlerKey(jugadorVista);
                mov.handle(keyEvent);
                break;
            case A:
                mov = new MovIzquierdaEventHandlerKey(jugadorVista);
                mov.handle(keyEvent);
                break;
        }
    }
}