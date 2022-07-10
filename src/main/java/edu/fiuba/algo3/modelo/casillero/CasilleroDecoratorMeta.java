package edu.fiuba.algo3.modelo.casillero;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.casillero.Efecto.BaseEfectoDecorador;
import edu.fiuba.algo3.modelo.casillero.Efecto.Efecto;
import edu.fiuba.algo3.modelo.casillero.Efecto.EfectoCruzarMeta;
import edu.fiuba.algo3.modelo.casillero.ElementosMapa.ElementoMapa;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class CasilleroDecoratorMeta implements Casillero {
    
    private Casillero casillaDecorada; 
    
    public CasilleroDecoratorMeta(Casillero casillaADecorar){
        this.casillaDecorada = casillaADecorar;
    }

    @Override
    public Efecto atravesar(Vehiculo vehiculo) {
        Efecto efectoOriginal = this.casillaDecorada.atravesar(vehiculo);
        BaseEfectoDecorador efectoMeta = new EfectoCruzarMeta();
        efectoMeta.decorar(efectoOriginal);
        return efectoMeta;
    }

	@Override 
	public ArrayList<ElementoMapa> obtenerElementos() {
		return casillaDecorada.obtenerElementos();
	}

	@Override
	public void vaciar() {
        casillaDecorada.vaciar();
    }
}
