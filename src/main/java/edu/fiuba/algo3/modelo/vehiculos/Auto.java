package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.casillero.Casillero;

public class Auto extends Vehiculo {

    public Auto(int fila, int columna){
        super(fila, columna);
    }

    @Override
    public void atravesarCasilla(Casillero c){
        c.aplicarMovimientosExtra(this);
    }
}