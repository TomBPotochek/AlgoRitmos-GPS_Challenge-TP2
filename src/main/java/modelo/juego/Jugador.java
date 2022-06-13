package modelo.juego;

import modelo.casillero.Mapa;
import modelo.vehiculos.Vehiculo;

public class Jugador {
    //podria tener un nombre
    private Vehiculo unVehiculo;
    private int cantMovimientos;

    public void asignarVehiculo(Vehiculo nuevoVehiculo){
        this.unVehiculo = nuevoVehiculo;
    }
    public void moverVehiculo(String direccion){
        this.unVehiculo.mover(direccion);
    }
}
