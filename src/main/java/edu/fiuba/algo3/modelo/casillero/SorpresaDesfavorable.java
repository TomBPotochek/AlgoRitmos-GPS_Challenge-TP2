package edu.fiuba.algo3.modelo.casillero;

import edu.fiuba.algo3.modelo.vehiculos.*;

public class SorpresaDesfavorable implements ElementoTablero {

    private Efecto desfavorable(Vehiculo vehiculo){
        return new Efecto(
                          (movimientos) -> (int) Math.round(movimientos*1.25),
                          vehiculo);
    }

    @Override
    public Efecto interactuar(Moto moto) {
        return desfavorable(moto);
    }

    @Override
    public Efecto interactuar(Auto auto) {
        return desfavorable(auto);
    }

    @Override
    public Efecto interactuar(CuatroPorCuatro cuatroPorCuatro) {
        return desfavorable(cuatroPorCuatro);
    }
    
}
