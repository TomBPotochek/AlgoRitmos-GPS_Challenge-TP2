package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.casillero.Efecto;
import edu.fiuba.algo3.modelo.casillero.ElementoTablero;
import edu.fiuba.algo3.modelo.movimientos.Posicion;

public class Moto extends Vehiculo {

    public Moto(Posicion posicionDada){
        super(posicionDada);
    }

    @Override
    public Efecto aceptar(ElementoTablero elemento) {
        return elemento.interactuar(this);
    }
}