package vehiculos;

import casillero.Casillero;
import casillero.Mapa;
import movimientos.Posicion;
import vehiculos.Vehiculo;

public class Auto extends Vehiculo {

    public Auto(int fila, int columna){
        super(fila, columna);
    }

    @Override
    public void atravesarCasilla(Casillero c){
        c.aplicarMovimientosExtra(this);
    }
}