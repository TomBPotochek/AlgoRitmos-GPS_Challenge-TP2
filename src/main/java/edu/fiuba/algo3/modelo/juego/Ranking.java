package edu.fiuba.algo3.modelo.juego;
import java.util.*;
public class Ranking {

    private TreeMap<Integer, ArrayList<String>> rank;
    private HashMap<String, Integer> jugadores;

    public Ranking() {
        rank = new TreeMap<Integer, ArrayList<String>>();
        jugadores = new HashMap<String, Integer>();
    }

    public void registrarJugador(String nombre, int puntaje) {
		Integer puntajeAnterior = this.jugadores.get(nombre);
		// Si jugador ya jugo partidas y su nuevo puntaje es menor o igual
		// borro su nombre del treemap.
		if (puntajeAnterior != null && puntajeAnterior > puntaje) {
			rank.get(puntajeAnterior).remove(nombre);
			
			// Elimino las listas vacias.
			if (rank.get(puntajeAnterior).size() == 0) {
				rank.remove(puntajeAnterior);
			}
	}

		// Actualizo el puntaje del jugador y lo guardo en el ranking.
		this.jugadores.put(nombre, puntaje);
		ArrayList<String> nombres = this.rank.get(puntaje);
		
		// Si no hay nadie con ese puntaje en el ranking
		if (nombres == null) {
			nombres = new ArrayList<String>();
			this.rank.put(puntaje, nombres);
		}
		
		// Si jugador no saco ese puntaje en otra partida lo agrego.
		if (nombres.indexOf(nombre) == -1) {
			nombres.add(nombre);
		}
    }
	
    public Collection<ArrayList<String>> obtenerRanking(){
		System.out.println(this.rank.values());
		return this.rank.values();
    }

    public int obtenerPuntajeJugador(String nombre){
        return this.jugadores.get(nombre);
    }
}