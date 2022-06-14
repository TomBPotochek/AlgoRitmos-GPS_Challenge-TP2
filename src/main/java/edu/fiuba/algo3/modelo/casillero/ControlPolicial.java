package edu.fiuba.algo3.modelo.casillero;

import edu.fiuba.algo3.modelo.vehiculos.*;

public class ControlPolicial implements ElementoTablero {

    @Override
    public Efecto interactuar(Moto moto) {
        int multiplicador = 0;
        if((new Random().nextDouble()) <= 0.8){// devuelve un numero de 0.00 a 1.00
            multiplicador = 1;
        }
        return new Efecto(
            (movimientos) ->  movimientos + (3*multiplicador),
            moto);
    }

    @Override
    public Efecto interactuar(Auto auto) {
        int multiplicador = 0;
        if((new Random().nextDouble()) <= 0.5){// devuelve un numero de 0.00 a 1.00
            multiplicador = 1;
        }
        return new Efecto(
            (movimientos) -> movimientos + (3*multiplicador),
            auto);
    }

    @Override
    public Efecto interactuar(CuatroPorCuatro cuatroPorCuatro) {
        int multiplicador = 0;
        if((new Random().nextDouble()) <= 0.3){// devuelve un numero de 0.00 a 1.00
            multiplicador = 1;
        }
        return new Efecto(
            (movimientos) -> movimientos + (3*multiplicador),
            cuatroPorCuatro);
    }
}
