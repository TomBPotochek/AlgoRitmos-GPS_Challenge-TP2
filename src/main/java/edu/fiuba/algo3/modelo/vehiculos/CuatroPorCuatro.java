package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.casillero.Efecto;
import edu.fiuba.algo3.modelo.casillero.ElementoMapa;
import edu.fiuba.algo3.modelo.movimientos.Posicion;

public class CuatroPorCuatro extends Vehiculo {

    private int cantidadDePozosAtravesados;

    public CuatroPorCuatro(Posicion posicionDada){
        super(posicionDada);
        this.cantidadDePozosAtravesados = 0;
    }


    public void pisarPozo(){
        this.cantidadDePozosAtravesados += 1;
    }

    public boolean pisoMasDeTresPozos() {
        return this.cantidadDePozosAtravesados >= 3;
    }

    @Override
    public Efecto aceptar(ElementoMapa elemento) {
        return elemento.interactuar(this);
    }
}
