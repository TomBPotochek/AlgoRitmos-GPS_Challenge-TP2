package edu.fiuba.algo3.modelo.juego;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.fiuba.algo3.modelo.Logging.Logger;
import edu.fiuba.algo3.modelo.Logging.LoggerConsola;
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
    
    private Turno turnoActual;
    // private String nombre;
    private Ranking ranking;
    public Juego(ArrayList<String> nombreJugadores, ProveedorDatosAzar proveedorDatosAzar){

        Logger.setLogger(new LoggerConsola());
        Logger.enableLogging(true);
		// Vehiculo vehiculoJugador1, vehiculoJugador2;
        ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>(
			Arrays.asList(new Moto(), new Auto(), new CuatroPorCuatro()));
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		Vehiculo vehiculoJugador;
		Jugador jugador;	
		// vehiculoJugador1 = vehiculos.get(proveedorDatosAzar.enteroAzarEnRango(0, vehiculos.size()));
		// vehiculoJugador2 = vehiculos.get(proveedorDatosAzar.enteroAzarEnRango(0, vehiculos.size()));
		
		for (String nombre : nombreJugadores) {
			vehiculoJugador = vehiculos.get(proveedorDatosAzar.enteroAzarEnRango(0, vehiculos.size() - 1));
			jugador = new Jugador(nombre, vehiculoJugador);
			jugadores.add(jugador);
		}
		/*
		switch (proveedorDatosAzar.enteroAzarEnRango(1, 3)){
            case 1:
                vehiculoJugador1 = new Moto();
                break;
            case 2:
                vehiculoJugador1 = new Auto();
                break;
            default:
                vehiculoJugador1 = new CuatroPorCuatro();
        }
		*/

        // Jugador jugador1 = new Jugador(vehiculoJugador1);
        // Jugador jugador2 = new Jugador(vehiculoJugador2);

        // jugadores.add(jugador2);

        this.turnoActual = new Turno(jugadores);
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
        this.turnoActual.mover(movimiento);
    }

    public boolean estaFinalizado(){
        return this.turnoActual.todosfinalizados();
    }

    public int obtenerPuntajeGanador(){
		Jugador ganador = this.turnoActual.obtenerGanador();
        return ganador.calcularPuntaje();
    }

	public Object obtenerNombreGanador() {
		Jugador ganador = this.turnoActual.obtenerGanador();
		return ganador.obtenerNombre();
	}

}
