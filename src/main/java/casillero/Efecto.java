package casillero;

import vehiculos.Vehiculo;

public class Efecto {
    private AplicadorDeMovimientos aplicador;
    private Vehiculo vehiculo;

    public Efecto(AplicadorDeMovimientos aplicador, Vehiculo vehiculoNuevo){
        this.aplicador = aplicador;
        this.vehiculo = vehiculoNuevo;
    }

    public int actualizar(int movimientosActuales){
        return this.aplicador.aplicar(movimientosActuales);
    }

    public Vehiculo cambiar(){
        return this.vehiculo;
    }
}
