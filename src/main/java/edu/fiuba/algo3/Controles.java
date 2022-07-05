package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.excepciones.JuegoFinalizadoException;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Controles implements EventHandler<KeyEvent> {
    private Stage stage;
    private JugadorVista jugadorVista;
    String botonNormal = "-fx-border-width: 2px; -fx-border-color: #80CEB9; -fx-background-color: transparent; -fx-text-fill: #80CEB9";
    String botonAntesDeSerPresionado = "-fx-border-width: 2px; -fx-border-color: #80CEB9; -fx-background-color: #717D8C; -fx-text-fill: #BDB69C";
    String formatoTexto = "-fx-border-width: 0px; -fx-border-color: #80CEB9; -fx-background-color: transparent; -fx-text-fill: #80CEB9";

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

