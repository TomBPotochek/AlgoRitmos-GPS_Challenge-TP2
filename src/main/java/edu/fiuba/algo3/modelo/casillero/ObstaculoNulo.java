package edu.fiuba.algo3.modelo.casillero;

import edu.fiuba.algo3.modelo.casillero.Efecto.Efecto;
import edu.fiuba.algo3.modelo.casillero.Efecto.EfectoSuma;
import edu.fiuba.algo3.modelo.vehiculos.*;

public class ObstaculoNulo implements ElementoMapa {

    @Override
    public Efecto interactuar(Moto moto) {
        return new EfectoSuma(
            0,
            moto);
    }

    @Override
    public Efecto interactuar(Auto auto) {
        return new EfectoSuma(
            0,
            auto);
    }

    @Override
    public Efecto interactuar(CuatroPorCuatro cuatroPorCuatro) {
        return new EfectoSuma(
            0,
            cuatroPorCuatro);
    }
 
}
