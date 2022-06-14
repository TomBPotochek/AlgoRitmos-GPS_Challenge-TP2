package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.casillero.ElementoTablero;
import edu.fiuba.algo3.modelo.casillero.Efecto;

public class Auto extends Vehiculo {

    public Auto(int fila, int columna){
        super(fila, columna);
    }

    @Override
    public Efecto aceptar(ElementoTablero elemento) {
        return elemento.interactuar(this);
    }
}