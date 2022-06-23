package edu.fiuba.algo3.modelo.casillero.Efecto;

import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class EfectoMultiplica extends Efecto {

	private float factor;

	public EfectoMultiplica(float factor, Vehiculo vehiculoNuevo) {
		super(vehiculoNuevo);
		this.factor = factor;
	}

	@Override
	public int actualizar(int movimientosActuales) {
		return (int) Math.round((1.0 - factor)*movimientosActuales);
	}
	
}
