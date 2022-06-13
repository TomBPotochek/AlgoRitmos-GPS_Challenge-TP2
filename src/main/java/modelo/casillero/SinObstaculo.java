package modelo.casillero;

import modelo.vehiculos.Auto;
import modelo.vehiculos.CuatroPorCuatro;
import modelo.vehiculos.Moto;
//import vehiculos.*;

public class SinObstaculo implements Casillero {
    
    public void aplicarMovimientosExtra(Moto moto) {
        return;
    }

    public void aplicarMovimientosExtra(Auto auto) {
        return;
    }

    public void aplicarMovimientosExtra(CuatroPorCuatro cuatrox4) {
        return;
    }


}
