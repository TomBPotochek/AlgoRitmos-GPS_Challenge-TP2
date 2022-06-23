package edu.fiuba.algo3.modelo.casillero;

import edu.fiuba.algo3.modelo.casillero.Efecto.Efecto;
import edu.fiuba.algo3.modelo.vehiculos.*;

public class SorpresaFavorable implements ElementoMapa {

    private Efecto favorable(Vehiculo vehiculo){
        return new Efecto(
                          (movimientos) -> (int) Math.round(movimientos*0.8),
                          vehiculo);
    }

    @Override
    public Efecto interactuar(Moto moto) {
        return favorable(moto);
    }

    @Override
    public Efecto interactuar(Auto auto) {
        return favorable(auto);
    }

    @Override
    public Efecto interactuar(CuatroPorCuatro cuatroPorCuatro) {
        return favorable(cuatroPorCuatro);
    }
    
}
