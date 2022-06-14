package edu.fiuba.algo3.modelo.casillero;

import edu.fiuba.algo3.modelo.movimientos.Posicion;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;

public class SorpresaCambioVehiculo implements ElementoTablero {
    
    @Override
    public Efecto interactuar(Moto moto) {
        return new Efecto( (movimientos) -> movimientos,
                          new Auto(new Posicion(1,1)));
    }

    @Override
    public Efecto interactuar(Auto auto) {
        return new Efecto( (movimientos) -> movimientos,
                          new CuatroPorCuatro(new Posicion(1,1)));
    }

    @Override
    public Efecto interactuar(CuatroPorCuatro cuatroPorCuatro) {
        return new Efecto( (movimientos) -> movimientos,
                          new Moto(new Posicion(1,1)));
    }
    
}
