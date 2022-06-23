package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.casillero.Efecto.Efecto;
import edu.fiuba.algo3.modelo.movimientos.*;
import edu.fiuba.algo3.modelo.movimientos.Posicion;

public class Jugador {
	Vehiculo vehiculo;
	int cantidadDeMovimientos;

	public Jugador(Vehiculo unVehiculo) {
		this.cantidadDeMovimientos = 0;
		this.vehiculo = unVehiculo;
	}	

	public boolean estaEnPosicion(Posicion unaPosicion) {
		return this.vehiculo.estaEnPosicion(unaPosicion);
	}

	public boolean cantidadDeMovimientosEs(int unEntero) {
		return this.cantidadDeMovimientos == unEntero;
	}

	// public void moverArriba() {
	// 	Movimiento movimiento = new MovArriba();
	// 	this.mover(movimiento);
	// }
	
	// public void moverAbajo() {
	// 	Movimiento movimiento = new MovAbajo();
	// 	this.mover(movimiento);
	// }

	// public void moverDerecha() {
	// 	Movimiento movimiento = new MovDerecha();
	// 	this.mover(movimiento);
	// }

	// public void moverIzquierda() {
	// 	Movimiento movimiento = new MovIzquierda();
	// 	this.mover(movimiento);
	// }

	private void aplicarEfectos(ArrayList<Efecto> efectos){
		for (Efecto efecto: efectos) {
			this.cantidadDeMovimientos = efecto.actualizarMovimientos(this.cantidadDeMovimientos);
			this.vehiculo = efecto.cambiarVehiculo();
		}
	}

	public void mover(Movimiento movimiento) {
		this.cantidadDeMovimientos += 1;
		aplicarEfectos(this.vehiculo.mover(movimiento));
	}

	public int verCantMovs() {
		return this.cantidadDeMovimientos;
	}
}
