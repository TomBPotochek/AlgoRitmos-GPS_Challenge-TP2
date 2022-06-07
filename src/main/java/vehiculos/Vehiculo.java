package vehiculos;

import casillero.Casillero;
import casillero.Mapa;
import movimientos.Posicion;

public abstract class Vehiculo {

    protected Posicion posicion;
    protected int cantidadDeMovimientos;

    public Vehiculo(int fila, int columna){
        this.posicion = new Posicion(fila,columna);
        this.cantidadDeMovimientos = 0;
    }
    

    abstract void atravesarCasilla(Casillero c);

    public void mover(String direccion, Mapa mapa){
        
        //mapa.tablero[fil][col] ----> le pasamos la moto
        
        //mapa.tablero[posicion.getFila()][posicion.getColumna()].asignarVehiculo(vehiculo);
        // try{
        //     costeDeMovimiento = mapa.moverVehiculo(this.posicion.calcularPosicion(direccion), this);
        // }catch(ErrorMovimientoInvalido){
        //     return;
        //     //en un futuro puede poner otra cosa   
        // }
        Posicion posSiguiente = this.posicion.calcularPosicion(direccion);
        if((mapa.verificarPosicionValida(posSiguiente) == false)){
            return;
        }
        Casillero c = mapa.obetenerCasilla(posSiguiente);
        // costeDeMovimiento = c.calcularCostoDeMovimientos(this);

        this.atravesarCasilla(c); //esto deberia lanzar excepcion
                                         //si impide al vehiculo moverse
        this.cantidadDeMovimientos +=  1;//1 movimiento + los movs extra penalizados
        
        this.posicion.actualizarPosicion(direccion);
        // calcular nueva direccion -> movimiento(direccion,cantidad)
        //que mapa le asigne al casillero nuevo la moto
        //que mapa retire la moto del casillero anterior
    }


    public int getCantidadMovimientos(){
        return this.cantidadDeMovimientos;
    }

    public Posicion getPosicion(){
        return this.posicion;
    }

    public void aplicarMovs(int penalizacion){
        this.cantidadDeMovimientos += penalizacion;
    }

}
