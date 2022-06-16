package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.casillero.Efecto;
import edu.fiuba.algo3.modelo.casillero.ElementoMapa;
import edu.fiuba.algo3.modelo.movimientos.Posicion;

public class Moto extends Vehiculo {

    public Moto(){
        super();
    }

    public Moto(Posicion posicionDada){
        super(posicionDada);
    }

    @Override
    public Efecto aceptar(ElementoMapa elemento) {
        return elemento.interactuar(this);
    }
}