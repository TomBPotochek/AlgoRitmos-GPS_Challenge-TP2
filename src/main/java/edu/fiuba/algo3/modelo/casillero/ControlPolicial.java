package edu.fiuba.algo3.modelo.casillero;

import edu.fiuba.algo3.modelo.casillero.azar.ProveedorDatosAzar;
import edu.fiuba.algo3.modelo.vehiculos.*;

public class ControlPolicial implements ElementoMapa {

    private ProveedorDatosAzar azar;

    public ControlPolicial(ProveedorDatosAzar proveedor){
        this.azar = proveedor;
    }

    @Override
    public Efecto interactuar(Moto moto) {
        AplicadorDeMovimientos aplicador;
        boolean aplicaControl = this.azar.eventoConProbabilidad(0.8);
        if (aplicaControl) {
            aplicador = (movimientos) -> movimientos + 3;
        } else {
            aplicador = (movimientos) -> movimientos;
        }
        return new Efecto(aplicador, moto);
    }

    @Override
    public Efecto interactuar(Auto auto) {
        AplicadorDeMovimientos aplicador;
        boolean aplicaControl = this.azar.eventoConProbabilidad(0.5);
        if (aplicaControl) {
            aplicador = (movimientos) -> movimientos + 3;
        } else {
            aplicador = (movimientos) -> movimientos;
        }
        return new Efecto(aplicador, auto);
    }

    @Override
    public Efecto interactuar(CuatroPorCuatro cuatroPorCuatro) {
        AplicadorDeMovimientos aplicador;
        boolean aplicaControl = this.azar.eventoConProbabilidad(0.3);
        if (aplicaControl) {
            aplicador = (movimientos) -> movimientos + 3;
        } else {
            aplicador = (movimientos) -> movimientos;
        }
        return new Efecto(aplicador, cuatroPorCuatro);
    }
}
