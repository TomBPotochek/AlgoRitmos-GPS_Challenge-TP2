package edu.fiuba.algo3.modelo.casillero;

import edu.fiuba.algo3.modelo.casillero.Efecto.BaseEfectoDecorador;
import edu.fiuba.algo3.modelo.vehiculos.*;

public interface ElementoMapa {
    BaseEfectoDecorador interactuar(Moto moto);
    BaseEfectoDecorador interactuar(Auto auto);
    BaseEfectoDecorador interactuar(CuatroPorCuatro cuatroPorCuatro);
}
