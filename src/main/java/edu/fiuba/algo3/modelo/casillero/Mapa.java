package edu.fiuba.algo3.modelo.casillero;
import edu.fiuba.algo3.modelo.excepciones.PosicionInvalidaError;
import edu.fiuba.algo3.modelo.movimientos.Posicion;

import java.util.HashMap;

public class Mapa {
    private int alto;
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

	public void asignarCasillero(Casillero casillero, Posicion pos){
        this.grilla.put(pos, casillero);
    }

    public Casillero obetenerCasilla(Posicion posicion) {
		if (posicion.fueraDeRango(this.ancho, this.alto)) {
			throw new PosicionInvalidaError();
		}
        return this.grilla.get(posicion);
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
    public void setAlto(int alto){
        this.alto = alto;
    }
}
