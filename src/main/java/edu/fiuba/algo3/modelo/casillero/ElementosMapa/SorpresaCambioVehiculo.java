package edu.fiuba.algo3.modelo.casillero.ElementosMapa;

import edu.fiuba.algo3.modelo.Logging.Logger;
import edu.fiuba.algo3.modelo.casillero.Efecto.BaseEfectoDecorador;
import edu.fiuba.algo3.modelo.casillero.Efecto.EfectoCambioDeVehiculo;
import edu.fiuba.algo3.modelo.vehiculos.*;

public class SorpresaCambioVehiculo implements ElementoMapa {

    private BaseEfectoDecorador generarEfecto(Vehiculo vehiculo){
        EfectoCambioDeVehiculo efecto = new EfectoCambioDeVehiculo();
        efecto.setVehiculo(vehiculo);
        Logger.log("vehiculo se topa con sopresa: cambio de vehiculo");
        return efecto;
    }
    
    @Override
    public BaseEfectoDecorador interactuar(Moto moto) {
        Auto auto = new Auto();
		moto.copiarPosicionA(auto);
		return this.generarEfecto(auto);
    }

    @Override
    public BaseEfectoDecorador interactuar(Auto auto) {
        CuatroPorCuatro cuatroPorCuatro = new CuatroPorCuatro();
		auto.copiarPosicionA(cuatroPorCuatro);
		return this.generarEfecto(cuatroPorCuatro);
    }

    @Override
    public BaseEfectoDecorador interactuar(CuatroPorCuatro cuatroPorCuatro) {
		Moto moto = new Moto();
		cuatroPorCuatro.copiarPosicionA(moto);
		return this.generarEfecto(moto);
    }
    
}
