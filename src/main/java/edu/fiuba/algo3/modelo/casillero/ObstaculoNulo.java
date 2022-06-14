package edu.fiuba.algo3.modelo.casillero;

import edu.fiuba.algo3.modelo.vehiculos.*;

public class ObstaculoNulo implements ElementoTablero {

    @Override
    public Efecto interactuar(Moto moto) {
        return new Efecto(
            (movimientos) ->  movimientos,
            moto);
    }

    @Override
    public Efecto interactuar(Auto auto) {
        return new Efecto(
            (movimientos) ->  movimientos,
            auto);
    }

    @Override
    public Efecto interactuar(CuatroPorCuatro cuatroPorCuatro) {
        return new Efecto(
            (movimientos) ->  movimientos,
            cuatroPorCuatro);
    }
 
}
