package edu.fiuba.algo3.modelo.casillero.Efecto;

import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class EfectoMultiplica extends Efecto {

	private double factor;

	public EfectoMultiplica(double factor, Vehiculo vehiculoNuevo) {
		super(vehiculoNuevo);
		this.factor = factor;
	}

	@Override
	public int actualizar(int movimientosActuales) {
		return (int) Math.round(factor*movimientosActuales);
	}
	
}
