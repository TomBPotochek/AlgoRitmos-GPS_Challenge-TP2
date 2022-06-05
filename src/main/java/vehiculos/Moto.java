package vehiculos;

import movimientos.Posicion;
import vehiculos.Vehiculo;

public class Moto implements Vehiculo {
    private Posicion posicion;

    public Moto(int fila, int columna){
        this.posicion = new Posicion(fila,columna);
    }

    public void mover(String direccion , int cantMovimientos){

        this.posicion.moverEnDireccion(direccion,cantMovimientos);
        // calcular nueva direccion -> movimiento(direccion,cantidad)
        //que mapa le asigne al casillero nuevo la moto
        //que mapa retire la moto del casillero anterior
    }
}
