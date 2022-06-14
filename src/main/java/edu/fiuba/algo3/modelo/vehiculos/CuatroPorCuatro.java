package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.casillero.Efecto;
import edu.fiuba.algo3.modelo.casillero.ElementoTablero;

public class CuatroPorCuatro extends Vehiculo {

    private int cantidadDePozosAtravesados;

    public CuatroPorCuatro(int fila, int columna){
        super(fila, columna);
        this.cantidadDePozosAtravesados = 0;
    }


    public void pisarPozo(){
        this.cantidadDePozosAtravesados += 1;
    }

    public boolean pisoMasDeTresPozos() {
        return this.cantidadDePozosAtravesados >= 3;
    }

    @Override
    public Efecto aceptar(ElementoTablero elemento) {
        return elemento.interactuar(this);
    }
}
