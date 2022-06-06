package casillero;

import vehiculos.*;

public class Pozo implements Casillero {

    // @Override
    // public int calcularCostoDeMovimientos(Vehiculo v){
    //     return this.calcularCostoDeMovimientos(v);
    // }
    
    @Override
    public int calcularCostoDeMovimientos(Moto moto){
        return 3;
    }

    /*@Override
    public int calcularCostoDeMovimientos(Auto auto){
        
    }

    @Override
    public int calcularCostoDeMovimientos(CuatroPorCuatro cuatroPorCuatro){
        
    }*/
}
