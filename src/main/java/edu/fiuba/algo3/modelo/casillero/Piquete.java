package edu.fiuba.algo3.modelo.casillero;

import edu.fiuba.algo3.modelo.excepciones.NoPuedeAtravesarObstaculoError;
import edu.fiuba.algo3.modelo.vehiculos.*;

public class Piquete implements ElementoMapa {

    @Override
    public Efecto interactuar(Moto moto) {
        return new Efecto(
            (movimientos) -> movimientos + 2,
            moto);
    }

    @Override
    public Efecto interactuar(Auto auto) {
        throw new NoPuedeAtravesarObstaculoError();
    }

    @Override
    public Efecto interactuar(CuatroPorCuatro cuatroPorCuatro) {
        throw new NoPuedeAtravesarObstaculoError();
    }
}
