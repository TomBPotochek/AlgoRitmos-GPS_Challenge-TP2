package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;
import edu.fiuba.algo3.modelo.movimientos.*;
import edu.fiuba.algo3.modelo.movimientos.Posicion;

import edu.fiuba.algo3.modelo.casillero.Efecto;

public class Jugador {
	Vehiculo vehiculo;
	int cantidadDeMovimientos;

	public Jugador(Vehiculo unVehiculo) {
		cantidadDeMovimientos = 0;
		vehiculo = unVehiculo;
	}	

	public boolean estaEnPosicion(Posicion unaPosicion) {
		return this.vehiculo.estaEnPosicion(unaPosicion);
	}

	public boolean cantidadDeMovimientosEs(int unEntero) {
		return this.cantidadDeMovimientos == unEntero;
	}

	public void moverArriba() {
		Movimiento movimiento = new MovArriba();
		this.mover(movimiento);
	}
	
	public void moverAbajo() {
		Movimiento movimiento = new MovAbajo();
		this.mover(movimiento);
	}

	public void moverDerecha() {
		Movimiento movimiento = new MovDerecha();
		this.mover(movimiento);
	}

	public void moverIzquierda() {
		Movimiento movimiento = new MovIzquierda();
		this.mover(movimiento);
	}

	private void mover(Movimiento movimiento) {
		this.cantidadDeMovimientos += 1;

		for (Efecto efecto: this.vehiculo.mover(movimiento)){
			this.cantidadDeMovimientos = efecto.actualizar(this.cantidadDeMovimientos);
			this.vehiculo = efecto.cambiar();
		}
	}

    public boolean vehiculoEsDeTipo(Vehiculo vehiculo) {
        return this.vehiculo.esDeTipoDeVehiculo(vehiculo);
    }
}
