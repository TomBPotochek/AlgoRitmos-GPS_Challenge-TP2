package edu.fiuba.algo3.modelo.juego;
import java.util.*;

import edu.fiuba.algo3.modelo.Logging.Logger;
public class Ranking {

    private Map<String,Integer> jugadores;
    private static Ranking unRanking;
    private Ranking(){
        jugadores = new LinkedHashMap<String,Integer>();

    }

    public static Ranking getRanking(){
        if(unRanking == null){
           unRanking = new Ranking();
        }
        return unRanking;
    }
    public void registrarJugador(String nombre, int puntaje) {
        Logger.log(String.format("Se registra nombre: %s Con puntaje: %d", nombre, puntaje));
        if(this.jugadores.containsKey(nombre)){
            int puntajeAnterior = this.jugadores.get(nombre);
            if(puntajeAnterior < puntaje)
                return;
        }
        this.jugadores.put(nombre, puntaje);
    }

    public List<Map.Entry<String,Integer>> obtenerRanking(){
        Set<Map.Entry<String,Integer>> entrySet = jugadores.entrySet();
        List<Map.Entry<String,Integer>> list = new ArrayList<>(entrySet);
        Collections.sort(list, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
        return list;
    }
    public int obtenerPuntajeJugador(String nombre){
        return this.jugadores.get(nombre);
    }
}