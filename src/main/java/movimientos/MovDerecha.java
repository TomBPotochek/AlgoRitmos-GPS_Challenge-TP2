package movimientos;

public class MovDerecha implements Movimiento {
    private int cantMovimientos;
    public MovDerecha() {
        this.cantMovimientos = 1;
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
