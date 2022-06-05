package movimientos;
import movimientos.MovFactory;
import movimientos.Movimiento;

public class Posicion {
    private int fil;
    private int col;

    public Posicion(int fila, int columna){
        this.fil = fila;
        this.col = columna;
    }
    public void moverEnDireccion(String direccion, int cantMovimientos) {
        Movimiento movimiento = MovFactory.MovimientoConstruir(direccion,cantMovimientos);
        this.col = movimiento.moverColumna(this.col);
        this.fil = movimiento.moverFila(this.fil);
    }
}
