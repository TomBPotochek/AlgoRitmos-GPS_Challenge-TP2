package edu.fiuba.algo3.modelo.juego;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

import edu.fiuba.algo3.modelo.excepciones.JuegoEnCursoException;
import edu.fiuba.algo3.modelo.excepciones.JuegoFinalizadoException;
import edu.fiuba.algo3.modelo.movimientos.Movimiento;

public class Turno {
    private Queue<Jugador> colaJugadores;
    private boolean juegoEstaFinalizado = false;
    private ArrayList<Jugador> jugadores;

    public Turno(ArrayList<Jugador> jugadores){
        this.colaJugadores = new LinkedList<Jugador>(jugadores);
        this.jugadores = jugadores;
    }

    private void turnoSiguiente(){
        try {
            colaJugadores.add(colaJugadores.remove());
        } catch (NoSuchElementException e) { }
        //si esta vacia, no deberia hacer nada
        //usar .poll() en vez de .remove() agregaria
        //un nill a la cola.
    }

    private Jugador jugadorActual()  {
        return colaJugadores.element();
    }

    public void mover(Movimiento movimiento) throws JuegoFinalizadoException {
        try {
            this.jugadorActual().mover(movimiento, this);
        } catch (NoSuchElementException e) {
            throw new JuegoFinalizadoException();
        }
        this.turnoSiguiente();
    }

    // public void finalizarJuego(){
    //     this.juegoEstaFinalizado = true;
    // }

    public boolean todosfinalizados() {
        //cuando ya no hay mas jugadores con turnos por jugar
        return colaJugadores.isEmpty();
    }

    public void finalizarTurnosJugador() {
        colaJugadores.remove();
    }

    // public Jugador obtenerGanador() throws JuegoFinalizadoException {
    //     if (! todosfinalizados()) throw new JuegoEnCursoException();
    //     int puntajeMaximo = -1;
    //     int puntajeActual;
    //     Jugador ganador = colaJugadores.peek(); //si se empata, quien gana?
    //     for (Jugador jugador: jugadores){
    //         puntajeActual = jugador.calcularPuntaje();
    //         if (puntajeActual > puntajeMaximo){
    //             puntajeMaximo = puntajeActual;
    //             ganador = jugador;
    //         }
    //     }
    //     return ganador;
    // }

    public int obtenerPuntajeGanador() {
        if (! todosfinalizados()) throw new JuegoEnCursoException();
        return jugadores.get(0).calcularPuntaje();
    }

}
