package edu.fiuba.algo3.modelo.vehiculos;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.casillero.Efecto;
import edu.fiuba.algo3.modelo.casillero.ElementoTablero;
import edu.fiuba.algo3.modelo.casillero.Mapa;
import edu.fiuba.algo3.modelo.excepciones.NoPuedeAtravesarObstaculoError;
import edu.fiuba.algo3.modelo.movimientos.Posicion;

public abstract class Vehiculo {

    protected Posicion posicion;
    protected int cantidadDeMovimientos;

    public Vehiculo(int fila, int columna){
        this.posicion = new Posicion(fila, columna);
        this.cantidadDeMovimientos = 0;
    }
    

    // abstract void atravesarCasilla(Casillero c);

    public void mover(String direccion, Mapa mapa){
        Posicion posSiguiente = this.posicion.calcularPosicion(direccion);
        if((mapa.verificarPosicionValida(posSiguiente) == false)){
            return;
        }
        Casillero c = mapa.obetenerCasilla(posSiguiente);

        // int cantidadDeMovimientosPrevios = this.cantidadDeMovimientos;
        try {
            // this.atravesarCasilla(c); //esto deberia lanzar excepcion si impide al vehiculo moverse
            ArrayList<Efecto> efectos = c.atravesar(this);
            for (Efecto efecto: efectos){
                this.cantidadDeMovimientos = efecto.actualizar(this.cantidadDeMovimientos);
            }
            this.posicion.actualizarPosicion(direccion);
        } catch (NoPuedeAtravesarObstaculoError e) { }
                                    
        this.cantidadDeMovimientos += 1; //1 movimiento + los movs extra penalizados
    }


    public int getCantidadMovimientos(){
        return this.cantidadDeMovimientos;
    }

    public Posicion getPosicion(){
        return this.posicion;
    }

    public void aplicarMovs(int penalizacion){
        this.cantidadDeMovimientos += penalizacion;
    }

	public void aplicarPorcentajeMovs(int porcentaje) {
		/*
		 * Aplica una reduccion (porcentaje negativo) o aumento (porcentaje positivo)
		 * porcentual de la cantidad de movimientos. 
		 */
		this.cantidadDeMovimientos *= 1 + (porcentaje / 100); 
	}

    public abstract Efecto aceptar(ElementoTablero elemento);
}
