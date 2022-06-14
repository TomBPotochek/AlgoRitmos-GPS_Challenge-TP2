package edu.fiuba.algo3.modelo.casillero;
import edu.fiuba.algo3.modelo.movimientos.Posicion;

import java.util.HashMap;

public class Mapa {
    private int dimensionesTablero; //asumimos q el tablero es cuadrado
    private HashMap<Posicion,Casillero> tablero = new HashMap<Posicion, Casillero>();

    public Mapa(int dimension){
        dimensionesTablero = dimension;
    }

    public boolean verificarPosicionValida(Posicion pos){
        return(((pos.getColumna() <= dimensionesTablero) && (pos.getColumna() >= 1)) && 
        ((pos.getFila() <= dimensionesTablero) && (pos.getFila() >= 1)));
    }

    public void asignarCasillero(Casillero casillero, Posicion pos){
        this.tablero.put(pos, casillero);
    }

    public Casillero obetenerCasilla(Posicion posicion) {
        return this.tablero.get(posicion);
    }


}
