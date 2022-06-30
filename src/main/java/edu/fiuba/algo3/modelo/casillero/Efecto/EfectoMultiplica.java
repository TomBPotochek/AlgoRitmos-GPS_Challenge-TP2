package edu.fiuba.algo3.modelo.casillero.Efecto;

import edu.fiuba.algo3.modelo.juego.Jugador;

public class EfectoMultiplica extends BaseEfectoDecorador {

	private double factor = 1.0;

    public void setFactor(double factor){
        this.factor = factor;
    }

	
	private int multiplicar(int movimientosActuales) {
		return (int) Math.round(factor*movimientosActuales);
	}

    @Override
    public void aplicarseSobre(Jugador jugador) {
        super.aplicarseSobre(jugador);

        int movimientos = jugador.verCantMovs();
        movimientos = this.multiplicar(movimientos);
        jugador.setMovimientos(movimientos);
    }
	
}
