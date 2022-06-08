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
        Posicion posSiguiente = this.posicion.calcularPosicion(direccion);
        if((mapa.verificarPosicionValida(posSiguiente) == false)){
            return;
        }
        Casillero c = mapa.obetenerCasilla(posSiguiente);

        //int cantidadDeMovimientosPrevios = this.cantidadDeMovimientos;
        try {
            this.atravesarCasilla(c); //esto deberia lanzar excepcion
                                      //si impide al vehiculo moverse
            this.posicion.actualizarPosicion(direccion);
            } catch (RuntimeException e) { }
                                    
        this.cantidadDeMovimientos +=  1;//1 movimiento + los movs extra penalizados
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
