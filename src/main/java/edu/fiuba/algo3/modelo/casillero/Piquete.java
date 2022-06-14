package edu.fiuba.algo3.modelo.casillero;

import edu.fiuba.algo3.modelo.excepciones.NoPuedeAtravesarObstaculoError;
import edu.fiuba.algo3.modelo.vehiculos.*;

public class Piquete implements ElementoTablero {

    @Override
    public Efecto interactuar(Moto moto) {
        return new Efecto(
            (movimientos) -> movimientos + 2,
            moto);
    }

    @Override
    public Efecto interactuar(Auto auto) {
        throw new NoPuedeAtravesarObstaculoError();
    }

    @Override
    public Efecto interactuar(CuatroPorCuatro cuatroPorCuatro) {
        throw new NoPuedeAtravesarObstaculoError();
    }
    // @Override
    // public void aplicarMovimientosExtra(Moto moto){
    //     moto.aplicarMovs(2);
    // }

    // @Override
    // public void aplicarMovimientosExtra(Auto auto){
	// 	throw new AutoNoAtraviezaPiqueteError();
    // }
	
    // @Override
    // public void aplicarMovimientosExtra(CuatroPorCuatro cuatroPorCuatro){
	// 	throw new CuatroPorCuatroNoAtraviezaPiqueteError();
	// }
}
