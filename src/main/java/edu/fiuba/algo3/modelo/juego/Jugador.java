package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

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
