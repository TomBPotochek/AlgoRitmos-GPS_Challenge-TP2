package edu.fiuba.algo3.modelo.casillero;

import edu.fiuba.algo3.modelo.casillero.Efecto.BaseEfectoDecorador;
import edu.fiuba.algo3.modelo.casillero.Efecto.EfectoSorpresata;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;

public class Sorpresata implements ElementoMapa {

    @Override
    public BaseEfectoDecorador interactuar(Moto moto) {
        return new EfectoSorpresata(true);
    }
    
    @Override
    public BaseEfectoDecorador interactuar(Auto auto) {
        // TODO Auto-generated method stub
        return new EfectoSorpresata(false);
        return null;
    }
    
    @Override
    public BaseEfectoDecorador interactuar(CuatroPorCuatro cuatroPorCuatro) {
        // TODO Auto-generated method stub
        return new EfectoSorpresata(false);
        return null;
    }
    
}
