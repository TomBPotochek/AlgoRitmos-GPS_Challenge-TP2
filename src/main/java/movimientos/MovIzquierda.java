package movimientos;

public class MovIzquierda implements Movimiento{
    private int cantMovimientos;
    public MovIzquierda(){
        this.cantMovimientos = 1;
    }

    @Override
    public int moverColumna(int columna){
        return columna - this.cantMovimientos;
    }
    @Override
    public int moverFila(int fila){
        return fila;
    }
}
