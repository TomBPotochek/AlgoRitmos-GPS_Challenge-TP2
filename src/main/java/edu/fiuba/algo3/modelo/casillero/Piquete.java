package edu.fiuba.algo3.modelo.casillero;

import edu.fiuba.algo3.modelo.casillero.Efecto.BaseEfectoDecorador;
import edu.fiuba.algo3.modelo.casillero.Efecto.EfectoSuma;
import edu.fiuba.algo3.modelo.excepciones.NoPuedeAtravesarObstaculoError;
import edu.fiuba.algo3.modelo.vehiculos.*;

public class Piquete implements ElementoMapa {

    @Override
    public BaseEfectoDecorador interactuar(Moto moto) {
        EfectoSuma efecto = new EfectoSuma();
        efecto.setMovimientosExtra(2);
        return efecto;
    }

    @Override
    public BaseEfectoDecorador interactuar(Auto auto) {
        throw new NoPuedeAtravesarObstaculoError();
    }

    @Override
    public BaseEfectoDecorador interactuar(CuatroPorCuatro cuatroPorCuatro) {
        throw new NoPuedeAtravesarObstaculoError();
    }
}
