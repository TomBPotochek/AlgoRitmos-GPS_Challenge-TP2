package edu.fiuba.algo3.modelo.casillero.ElementosMapa;

import edu.fiuba.algo3.modelo.Logging.Logger;
import edu.fiuba.algo3.modelo.casillero.Efecto.BaseEfectoDecorador;
import edu.fiuba.algo3.modelo.casillero.Efecto.EfectoSuma;
import edu.fiuba.algo3.modelo.excepciones.NoPuedeAtravesarObstaculoError;
import edu.fiuba.algo3.modelo.vehiculos.*;

public class Piquete implements ElementoMapa {

    @Override
    public BaseEfectoDecorador interactuar(Moto moto) {
        EfectoSuma efecto = new EfectoSuma();
        efecto.setMovimientosExtra(2);
        Logger.log("vehiculo (moto) se topa con piquete: aplica penalizacion 2 movimientos");
        return efecto;
    }

    @Override
    public BaseEfectoDecorador interactuar(Auto auto) {
        Logger.log("vehiculo (auto) se topa con piquete: no puede pasar");
        throw new NoPuedeAtravesarObstaculoError();
    }

    @Override
    public BaseEfectoDecorador interactuar(CuatroPorCuatro cuatroPorCuatro) {
        Logger.log("vehiculo (CuatroPorCuatro) se topa con piquete: no puede pasar");
        throw new NoPuedeAtravesarObstaculoError();
    }
}
