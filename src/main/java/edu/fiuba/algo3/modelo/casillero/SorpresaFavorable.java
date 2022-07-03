package edu.fiuba.algo3.modelo.casillero;

import edu.fiuba.algo3.modelo.Logging.Logger;
import edu.fiuba.algo3.modelo.casillero.Efecto.BaseEfectoDecorador;
import edu.fiuba.algo3.modelo.casillero.Efecto.EfectoMultiplica;
import edu.fiuba.algo3.modelo.vehiculos.*;

public class SorpresaFavorable implements ElementoMapa {

    private BaseEfectoDecorador favorable(Vehiculo vehiculo){
        EfectoMultiplica efecto = new EfectoMultiplica();
        efecto.setFactor(0.8);
        Logger.log("vehiculo se topa con sopresa: favorable");
        return efecto;
    }

    @Override
    public BaseEfectoDecorador interactuar(Moto moto) {
        return favorable(moto);
    }

    @Override
    public BaseEfectoDecorador interactuar(Auto auto) {
        return favorable(auto);
    }

    @Override
    public BaseEfectoDecorador interactuar(CuatroPorCuatro cuatroPorCuatro) {
        return favorable(cuatroPorCuatro);
    }
    
}
