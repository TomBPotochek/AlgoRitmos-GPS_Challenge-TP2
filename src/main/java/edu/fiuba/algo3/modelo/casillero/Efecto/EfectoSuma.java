package edu.fiuba.algo3.modelo.casillero.Efecto;

import edu.fiuba.algo3.modelo.juego.Jugador;

public class EfectoSuma extends BaseEfectoDecorador {

    private int movsExtra = 0;

    public void setMovimientosExtra(int movsExtra){
        this.movsExtra = movsExtra;
    }

    private int sumar(int movimientosActuales) {
        return movsExtra + movimientosActuales;
    }

    @Override
    public void aplicarseSobre(Jugador jugador) {
        super.aplicarseSobre(jugador);

        int movimientos = jugador.verCantMovs();
        movimientos = this.sumar(movimientos);
        jugador.setMovimientos(movimientos);
    }
    
}
