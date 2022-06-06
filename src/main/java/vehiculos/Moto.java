package vehiculos;

import movimientos.Posicion;
import vehiculos.Vehiculo;

public class Moto implements Vehiculo {
    private Posicion posicion;
    private int cantidadDeMovimientos;

    public Moto(int fila, int columna){
        this.posicion = new Posicion(fila,columna);
        this.cantidadDeMovimientos = 0;
    }

    public int getCantidadMovimientos(){
        return this.cantidadDeMovimientos;
    }

    public int getPosicion(){
        return this.posicion;
    }

    public void mover(String direccion, Mapa mapa){
        
        //mapa.tablero[fil][col] ----> le pasamos la moto
        
        //mapa.tablero[posicion.getFila()][posicion.getColumna()].asignarVehiculo(vehiculo);
        int costeDeMovimiento;
        try{
            costeDeMovimiento = mapa.moverVehiculo(this.posicion.calcularPosicion(direccion), this);
        }catch(ErrorMovimientoInvalido){
            return;
            //en un futuro puede poner otra cosa
        }

        cantidadDeMovimientos += costeDeMovimiento;
        moto.posicion.actualizarPosicion(direccion);
        // calcular nueva direccion -> movimiento(direccion,cantidad)
        //que mapa le asigne al casillero nuevo la moto
        //que mapa retire la moto del casillero anterior
    }
}
