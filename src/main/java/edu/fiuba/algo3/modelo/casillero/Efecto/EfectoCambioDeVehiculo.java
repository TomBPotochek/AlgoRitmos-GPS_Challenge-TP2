package edu.fiuba.algo3.modelo.casillero.Efecto;

import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class EfectoCambioDeVehiculo extends BaseEfectoDecorador {

    private Vehiculo vehiculoNuevo;


    public void setVehiculo(Vehiculo vehiculo){
        this.vehiculoNuevo = vehiculo;
    }

    @Override
    public void aplicarseSobre(Jugador jugador) {
        super.aplicarseSobre(jugador);

        jugador.cambiarVehiculoA(this.vehiculoNuevo);
        
    }
    
}
