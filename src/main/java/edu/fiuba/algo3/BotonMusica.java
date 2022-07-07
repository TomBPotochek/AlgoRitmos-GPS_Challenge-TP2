package edu.fiuba.algo3;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonMusica extends Button {

    private JugadorVista jugadorVista;
    private boolean musicaEncendida;

    public BotonMusica(String nombre, JugadorVista jugadorVista){
        super(nombre);
        this.jugadorVista = jugadorVista;
        this.musicaEncendida = true;
    }

    public EventHandler<ActionEvent> silenciar(){
        return new SilenciarSonidosHandler(jugadorVista);
    }

    public EventHandler<ActionEvent> reproducir(){
        return new EncenderSonidosHandler(jugadorVista);
    }

}
