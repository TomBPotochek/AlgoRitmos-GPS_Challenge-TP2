package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

import edu.fiuba.algo3.modelo.casillero.Efecto.Efecto;
import edu.fiuba.algo3.modelo.movimientos.*;
import edu.fiuba.algo3.modelo.movimientos.Posicion;

public class Jugador {
	private Vehiculo vehiculo;
	private int cantidadDeMovimientos;
    private boolean alcanzoMeta = false;

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

	private void aplicarEfecto(Efecto efecto){
		efecto.aplicarseSobre(this);
	}

// para evitar que las distintas implementaciones de efectos
// se acoplen con jugador 
	public void setMovimientos(int movimientos){
		this.cantidadDeMovimientos = movimientos;
	}

	public void mover(Movimiento movimiento, Turno turnoActual) {
		this.cantidadDeMovimientos += 1;
		aplicarEfecto(this.vehiculo.mover(movimiento));
        if (this.alcanzoMeta) turnoActual.finalizarTurnosJugador();
	}

    public void marcarFinalizado(){
        this.alcanzoMeta = true;
    }

    //TODO: ver si es necesario este metodo
    public boolean esGanador(){
        return false;
    }

	public int verCantMovs() {
		return this.cantidadDeMovimientos;
	}

    public void cambiarVehiculoA(Vehiculo vehiculoNuevo) {
        this.vehiculo = vehiculoNuevo;
    }

    public int calcularPuntaje() {
        return this.verCantMovs();
    }
}
