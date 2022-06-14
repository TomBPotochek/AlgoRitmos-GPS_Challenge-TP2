package edu.fiuba.algo3.modelo.casillero;

import java.util.Random;

import edu.fiuba.algo3.modelo.vehiculos.*;

public class ControlPolicial implements ElementoTablero {

    @Override
    public Efecto interactuar(Moto moto) {
        if((new Random().nextDouble()) <= 0.8){// devuelve un numero de 0.00 a 1.00
            return new Efecto(
            (movimientos) ->  movimientos + 3,
            moto);
        }
        return new Efecto(
            (movimientos) ->  movimientos + 0,
            moto);
    }

    @Override
    public Efecto interactuar(Auto auto) {
        if((new Random().nextDouble()) <= 0.5){// devuelve un numero de 0.00 a 1.00
            return new Efecto(
            (movimientos) ->  movimientos + 3,
            auto);
        }
        return new Efecto(
            (movimientos) ->  movimientos + 0,
            auto);
    }

    @Override
    public Efecto interactuar(CuatroPorCuatro cuatroPorCuatro) {
        if((new Random().nextDouble()) <= 0.3){// devuelve un numero de 0.00 a 1.00
            return new Efecto(
            (movimientos) -> movimientos + 3,
            cuatroPorCuatro);
        }
        return new Efecto(
            (movimientos) -> movimientos + 0,
            cuatroPorCuatro);
    }
}
