package casillero;

import vehiculos.CuatroPorCuatro;
import vehiculos.*;

public interface ElementoTablero {
    public Efecto interactuar(Moto moto);    
    public Efecto interactuar(Auto auto);    
    public Efecto interactuar(CuatroPorCuatro cuatroPorCuatro);    
}
