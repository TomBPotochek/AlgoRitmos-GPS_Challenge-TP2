package movimientos;

public class MovArriba implements Movimiento {
    private int cantMovimientos;
    public MovArriba(int cantidad) {
        this.cantMovimientos = cantidad;
    }

    @Override
    public int moverColumna(int columna) {
        return columna - this.cantMovimientos;
    }
    @Override
    public int moverFila(int fila){
        return fila;
    }
}
