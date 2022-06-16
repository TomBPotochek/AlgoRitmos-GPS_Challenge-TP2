package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.casillero.ElementoMapa;
import edu.fiuba.algo3.modelo.movimientos.Posicion;
import edu.fiuba.algo3.modelo.casillero.Efecto;

public class Auto extends Vehiculo {



    public Auto(Posicion posicionDada){
        super(posicionDada);
    }

    public Auto() {
        super();
    }

    @Override
    public Efecto aceptar(ElementoMapa elemento) {
        return elemento.interactuar(this);
    }
}