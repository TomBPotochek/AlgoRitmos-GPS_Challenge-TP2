package edu.fiuba.algo3.modelo.juego;
import java.util.*;
public class Ranking {

//    private TreeMap<Integer,String> rank;
    private Map<String,Integer> jugadores;

    public Ranking(){
        //rank = new TreeMap<Integer,String>(Collections.reverseOrder());
        jugadores = new LinkedHashMap<String,Integer>();

    }
    public void registrarJugador(String nombre, int puntaje) {
        if(this.jugadores.containsKey(nombre)){
            int puntajeAnterior = this.jugadores.get(nombre);
            if(puntajeAnterior > puntaje)
                return;
        }
        this.jugadores.put(nombre, puntaje);
    }

    public List<Map.Entry<String,Integer>> obtenerRanking(){
        Set<Map.Entry<String,Integer>> entrySet = jugadores.entrySet();
        List<Map.Entry<String,Integer>> list = new ArrayList<>(entrySet);
        Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        return list;
    }
    public int obtenerPuntajeJugador(String nombre){
        return this.jugadores.get(nombre);
    }
}