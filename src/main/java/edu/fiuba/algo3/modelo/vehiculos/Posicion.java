package edu.fiuba.algo3.modelo.vehiculos;

// Para el hash
import edu.fiuba.algo3.modelo.movimientos.Movimiento;

import java.util.Objects;

public class Posicion {
    private int fil;
    private int col;

    public Posicion(int fila, int columna){
		this.fil = fila;
        this.col = columna;
    }
    
	//TODO: Cambiar a X e Y
    public int getFila(){
        return (this.fil);
    }

    public int getColumna(){
        return (this.col);
    }
    
    public void actualizarPosicion(Movimiento movimiento) {
        this.col = movimiento.moverColumna(this.col);
        this.fil = movimiento.moverFila(this.fil);
    }

    public Posicion calcularPosicion(Movimiento movimiento) {
        return new Posicion(movimiento.moverFila(this.fil), movimiento.moverColumna(this.col));
    }

	public boolean fueraDeRango(int maxCol, int maxFil) {
		return this.fil > maxFil || this.fil < 1 || this.col > maxCol || this.col < 1;
	}

    @Override
    public boolean equals(Object objeto){
        if (this == objeto) {
    		return true;
		}

    	if (objeto == null || this.getClass() != objeto.getClass()) {
    		return false;
		}
		Posicion p = (Posicion) objeto;
        return this.fil == p.getFila() && this.col == p.getColumna();
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.fil, this.col);
    }

}
