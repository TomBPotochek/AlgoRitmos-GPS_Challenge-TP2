package edu.fiuba.algo3.modelo.casillero.azar;

import java.util.Random;

public class Azar implements ProveedorDatosAzar {

    private Random random = new Random();


    @Override
    public boolean eventoConProbabilidad(double probabilidad) {
        if (this.random.nextDouble() <= probabilidad) return true;
        return false;
    }


    @Override
    public int enteroAzarEnRango(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }
}
