package modelo.movimientos;

// Para el hash
import java.util.Objects;

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

    // public boolean compararPosicion(Posicion posicion1, Posicion posicion2){
    //     return((posicion1.getColumna() == posicion2.getColumna()) && 
    //     (posicion1.getFila() == posicion2.getFila()));
    // }
    
    public void actualizarPosicion(String direccion) {
        Movimiento movimiento = MovFactory.MovimientoConstruir(direccion);
        this.col = movimiento.moverColumna(this.col);
        this.fil = movimiento.moverFila(this.fil);
    }

    public Posicion calcularPosicion(String direccion) {
        Movimiento movimiento = MovFactory.MovimientoConstruir(direccion);
        return (new Posicion(movimiento.moverFila(this.fil),
                             movimiento.moverColumna(this.col))
                );
    }

    @Override
    public boolean equals(Object objeto){
        if (this == objeto)
    		return true;
    	if (objeto == null || (this.getClass() != objeto.getClass()))
    		return false;
        Posicion p = (Posicion) objeto;
        return (this.fil == p.getFila()) && (this.col == p.getColumna());
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.fil, this.col);
    }

}
