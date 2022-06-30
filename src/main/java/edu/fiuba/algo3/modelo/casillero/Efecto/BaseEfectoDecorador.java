package edu.fiuba.algo3.modelo.casillero.Efecto;

import edu.fiuba.algo3.modelo.juego.Jugador;

public class BaseEfectoDecorador implements Efecto {
    private Efecto efectoDecorado;

    public void decorar(Efecto efecto){
        this.efectoDecorado = efecto;
    }

    @Override
    public void aplicarseSobre(Jugador jugador){
        this.efectoDecorado.aplicarseSobre(jugador);
    }
}
