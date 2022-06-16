package edu.fiuba.algo3.modelo.casillero;

import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;

public class SorpresaCambioVehiculo implements ElementoMapa {
    
    @Override
    public Efecto interactuar(Moto moto) {
        return new Efecto( (movimientos) -> movimientos,
                          new Auto());
    }

    @Override
    public Efecto interactuar(Auto auto) {
        return new Efecto( (movimientos) -> movimientos,
                          new CuatroPorCuatro());
    }

    @Override
    public Efecto interactuar(CuatroPorCuatro cuatroPorCuatro) {
        return new Efecto( (movimientos) -> movimientos,
                          new Moto());
    }
    
}
