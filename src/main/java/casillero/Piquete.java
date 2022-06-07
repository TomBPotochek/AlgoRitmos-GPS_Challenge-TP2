package casillero;

import vehiculos.*;

public class Piquete implements Casillero{
    @Override
    public void aplicarMovimientosExtra(Moto moto){
        moto.aplicarMovs(2);
    }

    @Override
    public void aplicarMovimientosExtra(Auto auto){
       return;
    }

    @Override
    public void aplicarMovimientosExtra(CuatroPorCuatro cuatroPorCuatro){
        return;
    }
}
