package edu.fiuba.algo3.modelo.casillero;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.casillero.Efecto.BaseEfectoDecorador;
import edu.fiuba.algo3.modelo.casillero.Efecto.Efecto;
import edu.fiuba.algo3.modelo.casillero.Efecto.EfectoNulo;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class Casillero {
    private final ArrayList<ElementoMapa> elementos = new ArrayList<ElementoMapa>();

    public Efecto atravesar(Vehiculo vehiculo){
        Efecto efecto = new EfectoNulo();
        BaseEfectoDecorador efectoAuxiliar;
        for (ElementoMapa elemento : elementos){
            efectoAuxiliar = vehiculo.aceptar(elemento);
            efectoAuxiliar.decorar(efecto);
            efecto = efectoAuxiliar;
        }
        return efecto;
    }

    public void agregarElemento(ElementoMapa elemento){
        this.elementos.add(elemento);
    }

	public void vaciar() {
		elementos.clear();
	}
}
