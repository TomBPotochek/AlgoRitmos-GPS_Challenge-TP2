package edu.fiuba.algo3.modelo.juego;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import edu.fiuba.algo3.modelo.Logging.Logger;
import edu.fiuba.algo3.modelo.Logging.LoggerConsola;
import edu.fiuba.algo3.modelo.casillero.CasilleroCalle;
import edu.fiuba.algo3.modelo.casillero.ElementoMapa;
import edu.fiuba.algo3.modelo.casillero.Mapa;
import edu.fiuba.algo3.modelo.casillero.azar.ProveedorDatosAzar;
import edu.fiuba.algo3.modelo.excepciones.JuegoEnCursoException;
import edu.fiuba.algo3.modelo.excepciones.JuegoFinalizadoException;
import edu.fiuba.algo3.modelo.movimientos.Movimiento;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;
import edu.fiuba.algo3.modelo.casillero.azar.Azar;
import edu.fiuba.algo3.modelo.movimientos.Posicion;

public class Juego {
    
	private Jugador jugador;
	private Vehiculo vehiculoJugador;
    private Ranking ranking;

	public Juego(String nombreJugador, ProveedorDatosAzar proveedorDatosAzar){

        Logger.setLogger(new LoggerConsola());
        Logger.enableLogging(true);

		switch (proveedorDatosAzar.enteroAzarEnRango(1, 3)){
            case 1:
                this.vehiculoJugador = new Moto();
                break;
            case 2:
				this.vehiculoJugador = new Auto();
                break;
            default:
				this.vehiculoJugador = new CuatroPorCuatro();
        }

        this.jugador = new Jugador(nombreJugador, this.vehiculoJugador);
    }

    //setters innecesarios?
    public void setDimensionesMapa(int ancho, int alto){
        Mapa mapa = Mapa.getMapa();
		mapa.limpiar();
        mapa.setAncho(ancho);
        mapa.setAlto(alto);
		mapa.generarGrillaConElementosAlAzar(new Azar());
    }
    
    public void mover(Movimiento movimiento) throws JuegoFinalizadoException {
		if (this.estaFinalizado()) {
			throw new JuegoFinalizadoException();
		}
        this.jugador.mover(movimiento);
    }

    public boolean estaFinalizado(){
        return this.jugador.alcanzoMeta();
    }

    public int obtenerPuntaje(){
        return jugador.calcularPuntaje();
    }

	public Object obtenerNombre() {
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
}
