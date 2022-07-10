package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.casillero.ElementosMapa.ElementoMapa;
import edu.fiuba.algo3.modelo.casillero.Efecto.BaseEfectoDecorador;
import edu.fiuba.algo3.modelo.movimientos.Posicion;

public class Auto extends Vehiculo {



    public Auto(Posicion posicionDada){
        super(posicionDada);
    }

    public Auto() {
        super();
    }

    @Override
    public BaseEfectoDecorador aceptar(ElementoMapa elemento) {
        return elemento.interactuar(this);
    }
}