package casillero;

import vehiculos.*;

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
