package casillero;
import movimientos.Posicion;
import vehiculos.Vehiculo;

import java.util.HashMap;

public class Mapa {
    private int dimensionesTablero; //asumimos q el tablero es cuadrado
    private HashMap<Posicion,Casillero> tablero = new HashMap<Posicion, Casillero>();

    public Mapa(int dimension){
        dimensionesTablero = dimension;
    }

    public boolean verificarPosicionValida(Posicion pos){
        /*if(pos == null){
            return Exception;
        }*/
        return(((pos.getColumna() <= dimensionesTablero) && (pos.getColumna() >= 1)) && 
        ((pos.getFila() <= dimensionesTablero) && (pos.getFila() >= 1)));
    }

    public void asignarCasillero(Casillero casillero, Posicion pos){
        this.tablero.put(pos, casillero);
    }

    // public int moverVehiculo(Posicion p, Vehiculo vehiculo){
    //     Casillero c = tablero.get(p);
    //     return c.calcularCostoDeMovimientos(vehiculo);
    // }

    public Casillero obetenerCasilla(Posicion posicion) {
        return this.tablero.get(posicion);
    }


}
