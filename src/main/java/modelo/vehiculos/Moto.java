package modelo.vehiculos;

import modelo.casillero.Casillero;

public class Moto extends Vehiculo {

    public Moto(int fila, int columna){
        super(fila, columna);
    }

    @Override
    void atravesarCasilla(Casillero c) {
        c.aplicarMovimientosExtra(this);
    }   
}