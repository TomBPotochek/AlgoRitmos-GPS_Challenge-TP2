package vehiculos;

import casillero.Casillero;
import casillero.Mapa;
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

    public Posicion getPosicion(){
        return this.posicion;
    }

    @Override
    public void mover(String direccion, Mapa mapa){
        
        //mapa.tablero[fil][col] ----> le pasamos la moto
        
        //mapa.tablero[posicion.getFila()][posicion.getColumna()].asignarVehiculo(vehiculo);
        int costeDeMovimiento;
        // try{
        //     costeDeMovimiento = mapa.moverVehiculo(this.posicion.calcularPosicion(direccion), this);
        // }catch(ErrorMovimientoInvalido){
        //     return;
        //     //en un futuro puede poner otra cosa
        // }
        Posicion posSiguiente = this.posicion.calcularPosicion(direccion);
        Casillero c = mapa.obetenerCasilla(posSiguiente);
        costeDeMovimiento = c.calcularCostoDeMovimientos(this);

        cantidadDeMovimientos += costeDeMovimiento + 1;//1 movimiento + los movs extra penalizados
        this.posicion.actualizarPosicion(direccion);
        // calcular nueva direccion -> movimiento(direccion,cantidad)
        //que mapa le asigne al casillero nuevo la moto
        //que mapa retire la moto del casillero anterior
    }
}
