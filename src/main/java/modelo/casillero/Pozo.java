package modelo.casillero;

import modelo.vehiculos.Auto;
import modelo.vehiculos.CuatroPorCuatro;
import modelo.vehiculos.Moto;
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