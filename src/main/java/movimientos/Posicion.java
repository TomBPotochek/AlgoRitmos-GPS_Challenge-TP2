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
    
    public int getFila(){
        return (this.fil);
    }

    public int getColumna(){
        return (this.col);
    }

    public boolean compararPosicion(Posicion posicion1, Posicion posicion2){
        return((posicion1.getColumna() == posicion2.getColumna()) && 
        (posicion1.getFila() == posicion2.getFila()));
    }
    
    public void actualizarPosicion(String direccion) {
        Movimiento movimiento = MovFactory.MovimientoConstruir(direccion, 1);
        //tenemos q cambiar lo de cantidad de movimientos en movfactory
        this.col = movimiento.moverColumna(this.col);
        this.fil = movimiento.moverFila(this.fil);
    }

    public void calcularPosicion(String direccion) {
        Movimiento movimiento = MovFactory.MovimientoConstruir(direccion, 1);
        return (new Posicion(movimiento.moverColumna(this.col), 
        movimiento.moverFila(this.fil))); //Posicion posicionNueva =
    }
}
