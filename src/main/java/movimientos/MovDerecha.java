package movimientos;

public class MovDerecha implements Movimiento {
    private int cantMovimientos;
    public MovDerecha(int cantidad) {
        this.cantMovimientos = cantidad;
    }
    @Override
    public int moverColumna(int columna) {
        return columna;
    }
    @Override
    public int moverFila(int fila){
        return fila + this.cantMovimientos;
    }
}
