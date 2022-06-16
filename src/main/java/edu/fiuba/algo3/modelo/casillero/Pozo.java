package edu.fiuba.algo3.modelo.casillero;

import edu.fiuba.algo3.modelo.vehiculos.*;

public class Pozo implements ElementoMapa {

    @Override
    public Efecto interactuar(Moto moto) {
        return new Efecto(
            (movimientos) ->  movimientos + 3,
            moto);
    }

    @Override
    public Efecto interactuar(Auto auto) {
        return new Efecto(
            (movimientos) -> movimientos + 3,
            auto);
    }

    @Override
    public Efecto interactuar(CuatroPorCuatro cuatroPorCuatro) {
        cuatroPorCuatro.pisarPozo();
        boolean aplicaTresPozos = cuatroPorCuatro.pisoMasDeTresPozos();
        return new Efecto(
            (movimientos) -> aplicaTresPozos ? movimientos + 2 : movimientos,
            cuatroPorCuatro);
    }
}
