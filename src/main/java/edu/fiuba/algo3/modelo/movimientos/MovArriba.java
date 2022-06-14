package edu.fiuba.algo3.modelo.movimientos;

public class MovArriba implements Movimiento {
    private final int cantMovimientos;
	
    public MovArriba() {
        this.cantMovimientos = 1;
    }

    @Override
    public int moverColumna(int columna) {
        return columna;
    }
    @Override
    public int moverFila(int fila){
        return fila - this.cantMovimientos;
    }
}
