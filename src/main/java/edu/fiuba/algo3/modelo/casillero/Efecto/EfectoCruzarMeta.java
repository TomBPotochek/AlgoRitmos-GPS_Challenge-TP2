package edu.fiuba.algo3.modelo.casillero.Efecto;

import edu.fiuba.algo3.modelo.juego.Jugador;

public class EfectoCruzarMeta extends BaseEfectoDecorador {

    @Override
    public void aplicarseSobre(Jugador jugador){
        super.aplicarseSobre(jugador);
        jugador.marcarFinalizado();
    }
    
}
