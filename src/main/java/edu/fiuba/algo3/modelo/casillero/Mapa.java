package edu.fiuba.algo3.modelo.casillero;
import edu.fiuba.algo3.modelo.movimientos.Posicion;

import java.util.HashMap;

public class Mapa {
    private int alto; //asumimos q el tablero es cuadrado
    private int ancho;
    private static Mapa unMapa;
    private Mapa(){
        this.ancho = 1;
        this.alto = 1;
    }
    private final HashMap<Posicion,Casillero> grilla = new HashMap<Posicion, Casillero>();

    public static Mapa getMapa(){
        if(unMapa == null) {
            unMapa = new Mapa();
        }
        return unMapa;
    }
    public boolean verificarPosicionValida(Posicion pos){
        return(((pos.getColumna() <= this.ancho) && (pos.getColumna() >= 1)) &&
        ((pos.getFila() <= this.alto) && (pos.getFila() >= 1)));
    }

    public void asignarCasillero(Casillero casillero, Posicion pos){
        this.grilla.put(pos, casillero);
    }

    public Casillero obetenerCasilla(Posicion posicion) {
        return this.grilla.get(posicion);
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
    public void setAlto(int alto){
        this.alto = alto;
    }
}
