package edu.fiuba.algo3.modelo.casillero.Efecto;

import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class EfectoSuma extends Efecto {

	private int movsExtra;

	EfectoSuma(int MovimientosExtra, Vehiculo vehiculo){
		super(vehiculo);
		movsExtra = MovimientosExtra;
	}

	@Override
	public int actualizar(int movimientosActuales) {
		return movsExtra + movimientosActuales;
	}
	
}
