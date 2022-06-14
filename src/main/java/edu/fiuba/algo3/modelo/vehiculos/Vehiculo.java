package edu.fiuba.algo3.modelo.vehiculos;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.casillero.Efecto;
import edu.fiuba.algo3.modelo.casillero.ElementoTablero;
import edu.fiuba.algo3.modelo.casillero.Mapa;
import edu.fiuba.algo3.modelo.excepciones.NoPuedeAtravesarObstaculoError;
import edu.fiuba.algo3.modelo.excepciones.PosicionInvalidaError;
import edu.fiuba.algo3.modelo.movimientos.Posicion;
import edu.fiuba.algo3.modelo.movimientos.Movimiento;

public abstract class Vehiculo {

    protected Posicion posicion;

    public Vehiculo(Posicion posicionDada){
        this.posicion = posicionDada;
    }

    public ArrayList<Efecto> mover(Movimiento movimiento){
        Mapa mapa = Mapa.getMapa();
        Posicion posSiguiente = this.posicion.calcularPosicion(movimiento);
		ArrayList<Efecto> efectos = new ArrayList<Efecto>();

        try {
			Casillero casillero = mapa.obetenerCasilla(posSiguiente);
			efectos = casillero.atravesar(this);
            this.posicion.actualizarPosicion(movimiento);
        }
		catch (NoPuedeAtravesarObstaculoError e) { }
		catch (PosicionInvalidaError e) { }
              
        return efectos; //1 movimiento + los movs extra penalizados
    }

    public boolean estaEnPosicion(Posicion posicionAComparar){
		return this.posicion.equals(posicionAComparar);
    }

	public abstract Efecto aceptar(ElementoTablero elemento);
}
