package edu.fiuba.algo3.modelo.casillero;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Logging.Logger;
import edu.fiuba.algo3.modelo.casillero.Efecto.BaseEfectoDecorador;
import edu.fiuba.algo3.modelo.casillero.Efecto.Efecto;
import edu.fiuba.algo3.modelo.casillero.Efecto.EfectoNulo;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class CasilleroCalle implements Casillero {
    private final ArrayList<ElementoMapa> elementos = new ArrayList<ElementoMapa>();

    @Override
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
        Logger.log(String.format("agregado de %s a casillero #%s",
                     elemento.getClass().getSimpleName(),
                      Integer.toHexString(this.hashCode())));
    }
	
	public ArrayList<ElementoMapa> obtenerElementos() {
		return this.elementos;
	}

	@Override
	public void vaciar() {
		elementos.clear();
	}
}
