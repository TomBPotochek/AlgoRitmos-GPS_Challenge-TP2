package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.casillero.ElementosMapa.ElementoMapa;
import edu.fiuba.algo3.modelo.casillero.Efecto.BaseEfectoDecorador;
import edu.fiuba.algo3.modelo.movimientos.Posicion;

public class Moto extends Vehiculo {

    public Moto(){
        super();
    }

    public Moto(Posicion posicionDada){
        super(posicionDada);
    }

    @Override
    public BaseEfectoDecorador aceptar(ElementoMapa elemento) {
        return elemento.interactuar(this);
    }
}