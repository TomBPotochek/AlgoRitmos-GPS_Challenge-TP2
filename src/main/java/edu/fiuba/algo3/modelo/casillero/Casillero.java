package edu.fiuba.algo3.modelo.casillero;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class Casillero {
    private final ArrayList<ElementoTablero> elementos = new ArrayList<ElementoTablero>();

    public ArrayList<Efecto> atravesar(Vehiculo vehiculo){
        Efecto efecto;
        ArrayList<Efecto> efectos = new ArrayList<Efecto>();
        for (ElementoTablero elemento : elementos){
            efecto = vehiculo.aceptar(elemento);
            efectos.add(efecto);
        }
        return efectos;
    }

    public void agregarElemento(ElementoTablero elemento){
        this.elementos.add(elemento);
    }
}
