package edu.fiuba.algo3.modelo.movimientos;

public class MovDerecha implements Movimiento {
    private final int cantMovimientos;
    public MovDerecha() {
        this.cantMovimientos = 1;
    }
    @Override
    public int moverColumna(int columna) {
        return columna + this.cantMovimientos;
    }
    @Override
    public int moverFila(int fila){
        return fila;
    }
}
