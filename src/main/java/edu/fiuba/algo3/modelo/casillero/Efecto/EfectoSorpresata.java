package edu.fiuba.algo3.modelo.casillero.Efecto;

import edu.fiuba.algo3.modelo.excepciones.NoPuedeAtravesarObstaculoError;
import edu.fiuba.algo3.modelo.juego.Jugador;

public class EfectoSorpresata extends BaseEfectoDecorador {
    
    private Boolean frenarVehiculo;

    public EfectoSorpresata(Boolean frenar){
        this.frenarVehiculo = frenar;
    }

    @Override
    public void aplicarseSobre(Jugador jugador){
        super.aplicarseSobre(jugador);

        if (jugador.movimientosEsPar()){
            //cambio
        } else if (frenarVehiculo){
            throw new NoPuedeAtravesarObstaculoError();
        } else {
            EfectoSuma efectoPiquete = new EfectoSuma();
            efectoPiquete.setMovimientosExtra(2);
            efectoPiquete.aplicarseSobre(jugador);
        }
    }
}
