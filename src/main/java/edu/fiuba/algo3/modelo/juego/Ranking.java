package edu.fiuba.algo3.modelo.juego;
import java.util.*;
public class Ranking {

    private TreeMap<Integer,String> rank;
    private HashMap<String,Integer> jugadores;

    public Ranking(){
        rank = new TreeMap<Integer,String>(Collections.reverseOrder());
        jugadores = new HashMap<String,Integer>();
    }
    public void registrarJugador(String nombre, int puntaje) {
        this.rank.put(puntaje,nombre);
        //this.jugadores.put(nombre, puntaje);
    }

    public Collection<String> obtenerRanking(){
        return this.rank.values();
    }
    public int obtenerPuntajeJugador(String nombre){
        return this.jugadores.get(nombre);
    }
}