package edu.fiuba.algo3.modelo.casillero;

import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
//import vehiculos.*;

public interface Casillero {
    // public int calcularCostoDeMovimientos(Vehiculo v);
	
    public void aplicarMovimientosExtra(Moto moto);

    public void aplicarMovimientosExtra(Auto auto);

    public void aplicarMovimientosExtra(CuatroPorCuatro cuatroPorCuatro);
}
