package edu.fiuba.algo3.modelo.casillero.ElementosMapa;

import edu.fiuba.algo3.modelo.Logging.Logger;
import edu.fiuba.algo3.modelo.casillero.Efecto.BaseEfectoDecorador;
import edu.fiuba.algo3.modelo.casillero.Efecto.EfectoMultiplica;
import edu.fiuba.algo3.modelo.vehiculos.*;

public class SorpresaDesfavorable implements ElementoMapa {

    private BaseEfectoDecorador desfavorable(Vehiculo vehiculo){
        EfectoMultiplica efecto = new EfectoMultiplica();
        efecto.setFactor(1.25);
        Logger.log("vehiculo se topa con sopresa: desfavorable");
        return efecto;
    }

    @Override
    public BaseEfectoDecorador interactuar(Moto moto) {
        return desfavorable(moto);
    }

    @Override
    public BaseEfectoDecorador interactuar(Auto auto) {
        return desfavorable(auto);
    }

    @Override
    public BaseEfectoDecorador interactuar(CuatroPorCuatro cuatroPorCuatro) {
        return desfavorable(cuatroPorCuatro);
    }
    
}
