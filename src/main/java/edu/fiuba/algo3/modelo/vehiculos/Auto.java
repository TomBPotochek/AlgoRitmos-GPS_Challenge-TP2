package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.casillero.ElementoTablero;
import edu.fiuba.algo3.modelo.movimientos.Posicion;
import edu.fiuba.algo3.modelo.casillero.Efecto;

public class Auto extends Vehiculo {

    public Auto(Posicion posicionDada){
        super(posicionDada);
    }

    @Override
    public Efecto aceptar(ElementoTablero elemento) {
        return elemento.interactuar(this);
    }
}