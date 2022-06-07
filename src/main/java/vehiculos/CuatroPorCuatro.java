package vehiculos;

import casillero.Casillero;
import casillero.Mapa;
import movimientos.Posicion;

public class CuatroPorCuatro extends Vehiculo {

    private int cantidadDePozosAtravesados;

    public CuatroPorCuatro(int fila, int columna){
        super(fila, columna);
        this.cantidadDePozosAtravesados = 0;
    }


    public void aplicarMovsPozo(int penalizacion){
        this.cantidadDePozosAtravesados += 1;
        if ((this.cantidadDePozosAtravesados % 3) == 0) {
            this.aplicarMovs(penalizacion);
        }
    }

    @Override
    public void atravesarCasilla(Casillero c){
      c.aplicarMovimientosExtra(this);
    }
}
