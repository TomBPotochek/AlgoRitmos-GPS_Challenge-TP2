package vehiculos;

import casillero.Casillero;
import casillero.Efecto;
import casillero.ElementoTablero;
import casillero.Mapa;
import movimientos.Posicion;
import vehiculos.Vehiculo;

public class Moto extends Vehiculo {

    public Moto(int fila, int columna){
        super(fila, columna);
    }

    // @Override
    // void atravesarCasilla(Casillero c) {
    //     c.aplicarMovimientosExtra(this);
    // }

    @Override
    public Efecto aceptar(ElementoTablero elemento) {
        return elemento.interactuar(this);
    }   

    
}