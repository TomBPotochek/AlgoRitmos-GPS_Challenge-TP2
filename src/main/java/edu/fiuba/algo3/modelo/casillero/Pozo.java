package edu.fiuba.algo3.modelo.casillero;

import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
//import vehiculos.*;

public class Pozo implements Casillero {
    
    @Override
    public void aplicarMovimientosExtra(Moto moto){
        moto.aplicarMovs(3);
    }

    @Override
    public void aplicarMovimientosExtra(Auto auto){
       auto.aplicarMovs(3);
    }

    @Override
    public void aplicarMovimientosExtra(CuatroPorCuatro cuatroPorCuatro){
        cuatroPorCuatro.aplicarMovsPozo(2);
    }
}
