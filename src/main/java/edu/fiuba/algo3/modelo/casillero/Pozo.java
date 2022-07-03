package edu.fiuba.algo3.modelo.casillero;

import edu.fiuba.algo3.modelo.Logging.Logger;
import edu.fiuba.algo3.modelo.casillero.Efecto.BaseEfectoDecorador;
import edu.fiuba.algo3.modelo.casillero.Efecto.EfectoSuma;
import edu.fiuba.algo3.modelo.vehiculos.*;

public class Pozo implements ElementoMapa {

    private BaseEfectoDecorador generarEfecto(int movimientos){
        EfectoSuma efecto = new EfectoSuma();
        efecto.setMovimientosExtra(movimientos);
        return efecto;
    }

    @Override
    public BaseEfectoDecorador interactuar(Moto moto) {
        Logger.log("vehiculo (moto) pasa un pozo: suma 3 movimientos");
        return this.generarEfecto(3);
    }

    @Override
    public BaseEfectoDecorador interactuar(Auto auto) {
        Logger.log("vehiculo (auto) pasa un pozo: suma 3 movimientos");
        return this.generarEfecto(3);
    }

    @Override
    public BaseEfectoDecorador interactuar(CuatroPorCuatro cuatroPorCuatro) {
        cuatroPorCuatro.pisarPozo();
        boolean aplicaTresPozos = cuatroPorCuatro.pisoMasDeTresPozos();
		int movimientosExtra = aplicaTresPozos ? 2 : 0;
        Logger.log(String.format("vehiculo (cuatroPorCuatro) pasa un pozo: suma %d movimientos", movimientosExtra));
        return this.generarEfecto(movimientosExtra);
    }
}
