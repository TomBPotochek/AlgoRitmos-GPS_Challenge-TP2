package edu.fiuba.algo3.modelo.casillero;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.casillero.Efecto.Efecto;
import edu.fiuba.algo3.modelo.casillero.ElementosMapa.ElementoMapa;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public interface Casillero {
	public Efecto atravesar(Vehiculo vehiculo);
	public ArrayList<ElementoMapa> obtenerElementos();
	public void vaciar();
}
