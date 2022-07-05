package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;
import edu.fiuba.algo3.modelo.Logging.Logger;
import edu.fiuba.algo3.modelo.casillero.Efecto.Efecto;
import edu.fiuba.algo3.modelo.movimientos.*;
import edu.fiuba.algo3.modelo.movimientos.Posicion;

public class Jugador {
	private Vehiculo vehiculo;
	private int cantidadDeMovimientos;
    private boolean alcanzoMeta = false;
	private String nombre;

	public Jugador(String unNombre, Vehiculo unVehiculo) {
		this.cantidadDeMovimientos = 0;
		this.vehiculo = unVehiculo;
		this.nombre = unNombre;
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
        Logger.log(String.format("cantidad de movimientos se actualiza: %d -> %d", 
                    this.cantidadDeMovimientos, movimientos));
		this.cantidadDeMovimientos = movimientos;
	}

    private void incrementarMovimientos(){
        Logger.log(String.format("movimientos incrementa en 1: %d -> %d", 
                this.cantidadDeMovimientos, this.cantidadDeMovimientos+1));
        this.cantidadDeMovimientos += 1;
    }

	public void mover(Movimiento movimiento) {
		this.incrementarMovimientos();
		aplicarEfecto(this.vehiculo.mover(movimiento));
	}

	public void setVehiculo(Vehiculo vehiculoDado){
		this.vehiculo = vehiculoDado;
	}
	
    public void marcarFinalizado() {
		this.alcanzoMeta = true;
        Logger.log("jugador cruzo la meta");
    }

	public boolean alcanzoMeta() {
		return alcanzoMeta;
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

	public String obtenerNombre() {
		return this.nombre;
	}
}
