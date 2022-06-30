package edu.fiuba.algo3.modelo.juego;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.casillero.Mapa;
import edu.fiuba.algo3.modelo.casillero.azar.ProveedorDatosAzar;
import edu.fiuba.algo3.modelo.excepciones.JuegoEnCursoException;
import edu.fiuba.algo3.modelo.excepciones.JuegoFinalizadoException;
import edu.fiuba.algo3.modelo.movimientos.Movimiento;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;
import edu.fiuba.algo3.modelo.movimientos.Posicion;

public class Juego {
    
    private Turno turnoActual;
    private String nombre;

    public Juego(String nombreJugador, ProveedorDatosAzar proveedorDatosAzar){

        this.nombre = nombreJugador;

        Vehiculo vehiculoJugador1; 
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

        Jugador jugador1 = new Jugador(vehiculoJugador1);
        // Jugador jugador2 = new Jugador(vehiculoJugador2);

        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador1);
        // jugadores.add(jugador2);

        this.turnoActual = new Turno(jugadores);
    }

    //setters innecesarios?
    public void setAnchoMapa(int ancho){
        Mapa mapa = Mapa.getMapa();
        mapa.setAncho(ancho);
    }
    
    public void setAltoMapa(int alto){
        Mapa mapa = Mapa.getMapa();
        mapa.setAlto(alto);
    }

    public void mover(Movimiento movimiento) throws JuegoFinalizadoException {
        this.turnoActual.mover(movimiento);
    }

    public boolean estaFinalizado(){
        return this.turnoActual.todosfinalizados();
    }

    public String obtenerNombre() {
        return this.nombre;
    }

    public int obtenerPuntaje(){
        return this.turnoActual.obtenerPuntajeGanador();
    }
}
