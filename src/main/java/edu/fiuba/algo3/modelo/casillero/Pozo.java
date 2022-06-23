package edu.fiuba.algo3.modelo.casillero;

import edu.fiuba.algo3.modelo.casillero.Efecto.Efecto;
import edu.fiuba.algo3.modelo.casillero.Efecto.EfectoSuma;
import edu.fiuba.algo3.modelo.vehiculos.*;

public class Pozo implements ElementoMapa {

    @Override
    public Efecto interactuar(Moto moto) {
        return new  EfectoSuma(
			3,
            moto);
    }

    @Override
    public Efecto interactuar(Auto auto) {
        return new  EfectoSuma(
			3,
            auto);
    }

    @Override
    public Efecto interactuar(CuatroPorCuatro cuatroPorCuatro) {
        cuatroPorCuatro.pisarPozo();
        boolean aplicaTresPozos = cuatroPorCuatro.pisoMasDeTresPozos();
		int movimientosExtra = aplicaTresPozos ? 2 : 0;
        return new  EfectoSuma(
			movimientosExtra,
            cuatroPorCuatro);
    }
}
