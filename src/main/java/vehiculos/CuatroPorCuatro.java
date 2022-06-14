package vehiculos;

import casillero.Casillero;
import casillero.Efecto;
import casillero.ElementoTablero;
import casillero.Mapa;
import movimientos.Posicion;

public class CuatroPorCuatro extends Vehiculo {

    private int cantidadDePozosAtravesados;

    public CuatroPorCuatro(int fila, int columna){
        super(fila, columna);
        this.cantidadDePozosAtravesados = 0;
    }


    public void pisarPozo(){
        this.cantidadDePozosAtravesados += 1;
    }

    public boolean pisoMasDeTresPozos() {
        return this.cantidadDePozosAtravesados >= 3;
    }

    // @Override
    // public void atravesarCasilla(Casillero c){
    //   c.aplicarMovimientosExtra(this);
    // }

    @Override
    public Efecto aceptar(ElementoTablero elemento) {
        return elemento.interactuar(this);
    }
}
