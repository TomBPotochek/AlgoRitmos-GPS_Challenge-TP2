package casillero;
import movimientos.Posicion;
import vehiculos.Vehiculo;

import java.util.HashMap;

public class Mapa {
    // private Casillero[][] tablero;
    private HashMap<Posicion,Casillero> tablero = new HashMap<Posicion, Casillero>();

    public Mapa(int dimension){ 
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
