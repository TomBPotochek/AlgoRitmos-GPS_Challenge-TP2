package edu.fiuba.algo3.modelo.casillero;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.casillero.Efecto.Efecto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class Casillero {
    private final ArrayList<ElementoMapa> elementos = new ArrayList<ElementoMapa>();

    public ArrayList<Efecto> atravesar(Vehiculo vehiculo){
        Efecto efecto;
        ArrayList<Efecto> efectos = new ArrayList<Efecto>();
        for (ElementoMapa elemento : elementos){
            efecto = vehiculo.aceptar(elemento);
            efectos.add(efecto);
        }
        return efectos;
    }

    public void agregarElemento(ElementoMapa elemento){
        this.elementos.add(elemento);
    }

	public void vaciar() {
		elementos.clear();
	}
}
