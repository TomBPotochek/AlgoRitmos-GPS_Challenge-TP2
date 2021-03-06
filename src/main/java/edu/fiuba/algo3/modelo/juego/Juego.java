package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.casillero.ElementosMapa.ElementoMapa;
import edu.fiuba.algo3.modelo.casillero.Mapa;
import edu.fiuba.algo3.modelo.casillero.azar.Azar;
import edu.fiuba.algo3.modelo.movimientos.Movimiento;
import edu.fiuba.algo3.modelo.vehiculos.Posicion;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

import java.util.ArrayList;

public class Juego {
    
	private Jugador jugador;
	private Vehiculo vehiculoJugador;

	public Juego(String nombreJugador, Vehiculo vehiculo){
        // Logger.enableLogging(true);
        this.jugador = new Jugador(nombreJugador, vehiculo);
		this.vehiculoJugador = this.jugador.getVehiculo();
    }
	
    //setters innecesarios?
    public void setDimensionesMapa(int ancho, int alto){
		Mapa mapa = Mapa.getMapa();
		mapa.limpiar();
        mapa.setAncho(ancho);
        mapa.setAlto(alto);
		mapa.generarGrillaConElementosAlAzar(new Azar());
    }
    
    public void mover(Movimiento movimiento) {
		if (this.estaFinalizado()) {
			return;
		}
        this.jugador.mover(movimiento);
		this.vehiculoJugador = this.jugador.getVehiculo();
    }

    public boolean estaFinalizado(){
        return this.jugador.alcanzoMeta();
    }

    public int obtenerPuntaje(){
        return jugador.calcularPuntaje();
    }

	public String obtenerNombre() {
		return this.jugador.obtenerNombre();
	}
	
	// Getters para posicionar los elementos en la interfaz.

	public Posicion obtenerPosicionVehiculo() {
		return this.vehiculoJugador.obtenerPosicion();
	}
	
	public Class<? extends Vehiculo> obtenerTipoVehiculo() {
		return this.vehiculoJugador.getClass();
	}

	public ArrayList<ElementoMapa> obtenerElementos(Posicion posicion) {
		Mapa mapa = Mapa.getMapa();
		return mapa.obtenerCasilla(posicion).obtenerElementos();		
	}

    public Posicion obtenerPosicionMeta(){
        Mapa mapa = Mapa.getMapa();
        return mapa.obtenerPosicionMeta();
    }

    public int getCantMovimientosJugadorActual() {
        return jugador.getCantidadDeMovimientos();
    }
}
