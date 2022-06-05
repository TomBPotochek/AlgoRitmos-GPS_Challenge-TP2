package movimientos;

public class MovAbajo implements Movimiento {
    private int cantMovimientos;
    public MovAbajo(int cantidad) {
        this.cantMovimientos = cantidad;
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
