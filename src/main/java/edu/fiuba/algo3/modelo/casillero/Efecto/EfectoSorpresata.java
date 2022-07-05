package edu.fiuba.algo3.modelo.casillero.Efecto;

import edu.fiuba.algo3.modelo.excepciones.NoPuedeAtravesarObstaculoError;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;

public class EfectoSorpresata extends BaseEfectoDecorador {
    
    private Boolean frenarVehiculo;
    private Vehiculo vehiculo;

    public EfectoSorpresata(Boolean frenar, Vehiculo vehiculo){
        this.frenarVehiculo = frenar;
        this.vehiculo = vehiculo;
    }

    @Override
    public void aplicarseSobre(Jugador jugador){
        super.aplicarseSobre(jugador);


        if (jugador.movimientosEsPar()){
            EfectoCambioDeVehiculo efecto = new EfectoCambioDeVehiculo();
            efecto.setVehiculo(vehiculo);
            efecto.aplicarseSobre(jugador);
        } else if (frenarVehiculo){
            throw new NoPuedeAtravesarObstaculoError();
        } else {
            EfectoSuma efectoPiquete = new EfectoSuma();
            efectoPiquete.setMovimientosExtra(2);
            efectoPiquete.aplicarseSobre(jugador);
        }
    }
}
