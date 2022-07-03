package edu.fiuba.algo3.modelo.vehiculos;

import edu.fiuba.algo3.modelo.movimientos.*;

public class Direccion {
    private static Movimiento arriba;
    private static Movimiento abajo;
    private static Movimiento derecha;
    private static Movimiento izquierda;

    static {
        arriba = new MovArriba();
        abajo = new MovAbajo();
        derecha = new MovDerecha();
        izquierda = new MovIzquierda();
    }

    public static Movimiento arriba(){
        return arriba;
    }
    public static Movimiento abajo(){
        return abajo;
    }
    public static Movimiento derecha(){
        return derecha;
    }
    public static Movimiento izquierda(){
        return izquierda;
    }
}
