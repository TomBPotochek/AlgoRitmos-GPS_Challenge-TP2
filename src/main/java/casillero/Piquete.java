package casillero;

import excepciones.NoPuedeAtravesarObstaculoError;
import vehiculos.*;

public class Piquete implements Casillero{
    @Override
    public void aplicarMovimientosExtra(Moto moto){
        moto.aplicarMovs(2);
    }

    @Override
    public void aplicarMovimientosExtra(Auto auto){
		throw new NoPuedeAtravesarObstaculoError();
    }
	
    @Override
    public void aplicarMovimientosExtra(CuatroPorCuatro cuatroPorCuatro){
		throw new NoPuedeAtravesarObstaculoError();
	}
}
