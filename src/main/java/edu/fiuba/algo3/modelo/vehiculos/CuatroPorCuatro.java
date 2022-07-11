package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.Logging.Logger;
import edu.fiuba.algo3.modelo.casillero.ElementosMapa.ElementoMapa;
import edu.fiuba.algo3.modelo.casillero.Efecto.BaseEfectoDecorador;
import edu.fiuba.algo3.modelo.movimientos.Posicion;

public class CuatroPorCuatro extends Vehiculo {

    private int cantidadDePozosAtravesados;

    public CuatroPorCuatro(){
        super();
    }

    public CuatroPorCuatro(Posicion posicionDada){
        super(posicionDada);
        this.cantidadDePozosAtravesados = 0;
    }


    public void pisarPozo(){
        Logger.log(String.format("cuatroPorCuatro pisa otro pozo: %d -> %d pozos",
                    this.cantidadDePozosAtravesados, this.cantidadDePozosAtravesados+1));
        this.cantidadDePozosAtravesados += 1;
    }

    public boolean pisoMasDeTresPozos() {
        return this.cantidadDePozosAtravesados >= 3;
    }

    @Override
    public BaseEfectoDecorador aceptar(ElementoMapa elemento) {
        return elemento.interactuar(this);
    }
}
