package edu.fiuba.algo3.modelo.casillero;

import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.excepciones.*;

public class Piquete implements Casillero{
    @Override
    public void aplicarMovimientosExtra(Moto moto){
        moto.aplicarMovs(2);
    }

    @Override
    public void aplicarMovimientosExtra(Auto auto){
        throw new RuntimeException("piquete impide auto");
    }

    @Override
    public void aplicarMovimientosExtra(CuatroPorCuatro cuatroPorCuatro){
        throw new RuntimeException("piquete impide 4x4");
    }
}
