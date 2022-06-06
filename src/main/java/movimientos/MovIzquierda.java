package movimientos;

public class MovIzquierda implements Movimiento{
    private final int cantMovimientos;
    public MovIzquierda(){
        this.cantMovimientos = 1;
    }

    @Override
    public int moverColumna(int columna){
        return columna;
    }
    @Override
    public int moverFila(int fila){
        return fila + this.cantMovimientos;
    }
}
