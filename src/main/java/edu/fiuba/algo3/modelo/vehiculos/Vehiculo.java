package edu.fiuba.algo3.modelo.vehiculos;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.casillero.ElementoMapa;
import edu.fiuba.algo3.modelo.casillero.Mapa;
import edu.fiuba.algo3.modelo.casillero.Efecto.Efecto;
import edu.fiuba.algo3.modelo.excepciones.NoPuedeAtravesarObstaculoError;
import edu.fiuba.algo3.modelo.excepciones.PosicionInvalidaError;
import edu.fiuba.algo3.modelo.movimientos.Posicion;
import edu.fiuba.algo3.modelo.movimientos.Movimiento;

public abstract class Vehiculo {

    protected Posicion posicion;

    public Vehiculo(){
        this.posicion = new Posicion(1,1);
    }


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
		catch (NoPuedeAtravesarObstaculoError | PosicionInvalidaError e) { }

        return efectos; //1 movimiento + los movs extra penalizados
    }


    public boolean estaEnPosicion(Posicion posicionAComparar){
		return this.posicion.equals(posicionAComparar);
    }
	
	
	public void copiarPosicionA(Vehiculo vehiculo) {
		vehiculo.setPosicion(this.posicion);
	}
	

	protected void setPosicion(Posicion unaPosicion) {
		this.posicion = unaPosicion;
	}


	public abstract Efecto aceptar(ElementoMapa elemento);
}
