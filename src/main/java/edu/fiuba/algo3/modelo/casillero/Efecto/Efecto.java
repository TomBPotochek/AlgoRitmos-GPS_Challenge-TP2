package edu.fiuba.algo3.modelo.casillero.Efecto;

import edu.fiuba.algo3.modelo.casillero.AplicadorDeMovimientos;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public abstract class Efecto {
    private final Vehiculo vehiculo;

    public Efecto(Vehiculo vehiculoNuevo){
        this.vehiculo = vehiculoNuevo;
    }

    public abstract int actualizar(int movimientosActuales);

    public Vehiculo cambiar(){
        return this.vehiculo;
    }
}
