package edu.fiuba.algo3.modelo.casillero;

import edu.fiuba.algo3.modelo.vehiculos.*;

public interface ElementoMapa {
    Efecto interactuar(Moto moto);
    Efecto interactuar(Auto auto);
    Efecto interactuar(CuatroPorCuatro cuatroPorCuatro);
}
