package casillero;

import vehiculos.*;

public interface Casillero {
    // public int calcularCostoDeMovimientos(Vehiculo v);

    public void aplicarMovimientosExtra(Moto moto);

    public void aplicarMovimientosExtra(Auto auto);

    public void aplicarMovimientosExtra(CuatroPorCuatro cuatroPorCuatro);
}
