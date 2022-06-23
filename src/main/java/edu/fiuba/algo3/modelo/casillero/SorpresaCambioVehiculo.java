package edu.fiuba.algo3.modelo.casillero;

import edu.fiuba.algo3.modelo.casillero.Efecto.Efecto;
import edu.fiuba.algo3.modelo.casillero.Efecto.EfectoSuma;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;

public class SorpresaCambioVehiculo implements ElementoMapa {
    
    @Override
    public Efecto interactuar(Moto moto) {
        Auto auto = new Auto();
		moto.copiarPosicionA(auto);
		return new EfectoSuma(0, auto);
    }

    @Override
    public Efecto interactuar(Auto auto) {
        CuatroPorCuatro cuatroPorCuatro = new CuatroPorCuatro();
		auto.copiarPosicionA(cuatroPorCuatro);
		return new  EfectoSuma(0, cuatroPorCuatro);
    }

    @Override
    public Efecto interactuar(CuatroPorCuatro cuatroPorCuatro) {
		Moto moto = new Moto();
		cuatroPorCuatro.copiarPosicionA(moto);
		return new  EfectoSuma(0, moto);
    }
    
}
