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

    public Vehiculo(Posicion posicionDada){
        this.posicion = posicionDada;
        this.cantidadDeMovimientos = 0;
    }

    public void mover(String direccion){
        Mapa mapa = Mapa.getMapa();
        Posicion posSiguiente = this.posicion.calcularPosicion(direccion);
        if(!mapa.verificarPosicionValida(posSiguiente)){
            return;
        }
        Casillero casillero = mapa.obetenerCasilla(posSiguiente);

        try {
            ArrayList<Efecto> efectos = casillero.atravesar(this);
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

    public abstract Efecto aceptar(ElementoTablero elemento);

    public boolean estaEnPosicion(Posicion posicionAComparar){
        return (this.posicion.equals(posicionAComparar));
    }
}
