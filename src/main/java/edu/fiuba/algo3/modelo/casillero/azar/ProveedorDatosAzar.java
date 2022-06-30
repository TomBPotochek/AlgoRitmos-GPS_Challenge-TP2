package edu.fiuba.algo3.modelo.casillero.azar;

public interface ProveedorDatosAzar {
    public boolean eventoConProbabilidad(double probabilidad);

    public int enteroAzarEnRango(int min, int max);
}
