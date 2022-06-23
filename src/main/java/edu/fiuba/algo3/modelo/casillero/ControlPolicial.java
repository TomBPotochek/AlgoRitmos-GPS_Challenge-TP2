package edu.fiuba.algo3.modelo.casillero;

import edu.fiuba.algo3.modelo.casillero.Efecto.Efecto;
import edu.fiuba.algo3.modelo.casillero.Efecto.EfectoSuma;
import edu.fiuba.algo3.modelo.casillero.azar.ProveedorDatosAzar;
import edu.fiuba.algo3.modelo.vehiculos.*;

public class ControlPolicial implements ElementoMapa {

    private ProveedorDatosAzar azar;

    public ControlPolicial(ProveedorDatosAzar proveedor){
        this.azar = proveedor;
    }

    @Override
    public Efecto interactuar(Moto moto) {
        boolean aplicaControl = this.azar.eventoConProbabilidad(0.8);
        int movimientosExtra = aplicaControl ? 3 : 0;
        return new  EfectoSuma(movimientosExtra, moto);
    }

    @Override
    public Efecto interactuar(Auto auto) {
        boolean aplicaControl = this.azar.eventoConProbabilidad(0.5);
        int movimientosExtra = aplicaControl ? 3 : 0;
        return new  EfectoSuma(movimientosExtra, auto);
    }

    @Override
    public Efecto interactuar(CuatroPorCuatro cuatroPorCuatro) {
        boolean aplicaControl = this.azar.eventoConProbabilidad(0.3);
        int movimientosExtra = aplicaControl ? 3 : 0;
        return new  EfectoSuma(movimientosExtra, cuatroPorCuatro);
    }
}
