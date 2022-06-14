package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.casillero.Efecto;
import edu.fiuba.algo3.modelo.casillero.ElementoTablero;

public class Moto extends Vehiculo {

    public Moto(int fila, int columna){
        super(fila, columna);
    }

    @Override
    public Efecto aceptar(ElementoTablero elemento) {
        return elemento.interactuar(this);
    }
}