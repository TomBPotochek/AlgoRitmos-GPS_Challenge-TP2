package edu.fiuba.algo3.modelo.casillero;

import edu.fiuba.algo3.modelo.vehiculos.*;

public interface ElementoTablero {
    public Efecto interactuar(Moto moto);    
    public Efecto interactuar(Auto auto);    
    public Efecto interactuar(CuatroPorCuatro cuatroPorCuatro);    
}
