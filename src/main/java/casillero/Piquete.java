package casillero;

import excepciones.AutoNoAtraviezaPiqueteError;
import excepciones.CuatroPorCuatroNoAtraviezaPiqueteError;
import vehiculos.*;

public class Piquete implements Casillero{
    @Override
    public void aplicarMovimientosExtra(Moto moto){
        moto.aplicarMovs(2);
    }

    @Override
    public void aplicarMovimientosExtra(Auto auto){
		throw new AutoNoAtraviezaPiqueteError();
    }
	
    @Override
    public void aplicarMovimientosExtra(CuatroPorCuatro cuatroPorCuatro){
		throw new CuatroPorCuatroNoAtraviezaPiqueteError();
	}
}
