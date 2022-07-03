package edu.fiuba.algo3.modelo.casillero;

import edu.fiuba.algo3.modelo.Logging.Logger;
import edu.fiuba.algo3.modelo.casillero.Efecto.BaseEfectoDecorador;
import edu.fiuba.algo3.modelo.casillero.Efecto.EfectoSuma;
import edu.fiuba.algo3.modelo.casillero.azar.ProveedorDatosAzar;
import edu.fiuba.algo3.modelo.vehiculos.*;

public class ControlPolicial implements ElementoMapa {

    private ProveedorDatosAzar azar;

    private BaseEfectoDecorador generarEfecto(int movimientos){
        EfectoSuma efecto = new EfectoSuma();
        efecto.setMovimientosExtra(movimientos);
        return efecto;
    }

    public ControlPolicial(ProveedorDatosAzar proveedor){
        this.azar = proveedor;
    }

    @Override
    public BaseEfectoDecorador interactuar(Moto moto) {
        boolean aplicaControl = this.azar.eventoConProbabilidad(0.8);
        int movimientosExtra = aplicaControl ? 3 : 0;
        Logger.log(String.format("vehiculo (moto) se topa con control policial. suma %d movimientos", 
                    movimientosExtra)); 
        return this.generarEfecto(movimientosExtra);
    }

    @Override
    public BaseEfectoDecorador interactuar(Auto auto) {
        boolean aplicaControl = this.azar.eventoConProbabilidad(0.5);
        int movimientosExtra = aplicaControl ? 3 : 0;
        Logger.log(String.format("vehiculo (auto) se topa con control policial. suma %d movimientos", 
                    movimientosExtra));
        return this.generarEfecto(movimientosExtra);
    }

    @Override
    public BaseEfectoDecorador interactuar(CuatroPorCuatro cuatroPorCuatro) {
        boolean aplicaControl = this.azar.eventoConProbabilidad(0.3);
        int movimientosExtra = aplicaControl ? 3 : 0;
        Logger.log(String.format("vehiculo (cuatroPorCuatro) se topa con control policial. suma %d movimientos", 
                    movimientosExtra));
        return this.generarEfecto(movimientosExtra);
    }
}
