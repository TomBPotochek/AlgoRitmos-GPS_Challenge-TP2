package edu.fiuba.algo3.modelo.casillero;
import edu.fiuba.algo3.modelo.casillero.azar.ProveedorDatosAzar;
import edu.fiuba.algo3.modelo.excepciones.PosicionInvalidaError;
import edu.fiuba.algo3.modelo.movimientos.Posicion;

import java.util.HashMap;

public class Mapa {
    private int alto;
    private int ancho;
    private static Mapa unMapa;
	private HashMap<Posicion,CasilleroCalle> grilla;
    private Posicion posicionMeta = new Posicion(-10, -10); //meta inalcanzable
    
	private Mapa(){
        this.ancho = 1;
        this.alto = 1;
		this.grilla = new HashMap<Posicion, CasilleroCalle>();
	}

    public static Mapa getMapa(){
        if (unMapa == null) {
            unMapa = new Mapa();
        }
        return unMapa;
    }

	public void asignarCasillero(CasilleroCalle casillero, Posicion pos){
        this.grilla.put(pos, casillero);
    }

    public void asignarPosicionMeta(Posicion pos){
        this.posicionMeta = pos;
    }

    public Casillero obetenerCasilla(Posicion posicion) {
		if (posicion.fueraDeRango(this.ancho, this.alto)) {
			throw new PosicionInvalidaError();
		}
        Casillero casillero = this.grilla.get(posicion);
        
        if (posicion.equals(this.posicionMeta)){
            casillero = new CasilleroDecoratorMeta(casillero);
        }
        return casillero;
    }


	public void limpiar() {
		for (Posicion posicion: this.grilla.keySet()) {
			this.grilla.get(posicion).vaciar();
		}
	}

// TODO: habria que pensar en los casilleros como calles, no esquinas.
//       por lo tanto, para un tablero de MxN cuadras deberian haber
//       (M-1)xN + (N-1)xM calles/casilleros.
    public void generarGrillaVacia(int alto, int ancho){
        this.alto = alto;
        this.ancho = ancho;
        for (int i = 1; i <= alto; i++) {
            for (int j = 1; j <= ancho; j++) {
                this.asignarCasillero(new CasilleroCalle(), new Posicion(i, j));
            }
        }
    }

    public void generarGrillaConElementosAlAzar(ProveedorDatosAzar azar){
        boolean obstaculoPozo;
        boolean obstaculoPiquete;
        boolean obstaculoControl;
        boolean sorpresaFavorable;
        boolean sorpresaDesfavorable;
        boolean sorpresaCambioVehiculo;

        for (int i = 1; i <= alto; i++){
            for (int j = 1; j <= ancho; j++){
                obstaculoPozo = azar.eventoConProbabilidad(0.05);
                obstaculoPiquete = azar.eventoConProbabilidad(0.008);
                obstaculoControl = azar.eventoConProbabilidad(0.02);
                sorpresaFavorable = azar.eventoConProbabilidad(0.08);
                sorpresaDesfavorable = azar.eventoConProbabilidad(0.06);
                sorpresaCambioVehiculo = azar.eventoConProbabilidad(0.001);
                
                CasilleroCalle casillero = new CasilleroCalle();
                if (obstaculoPozo) casillero.agregarElemento(new Pozo());
                if (obstaculoPiquete) casillero.agregarElemento(new Piquete());
                if (obstaculoControl) casillero.agregarElemento(new ControlPolicial(azar));
                if (sorpresaFavorable) casillero.agregarElemento(new SorpresaFavorable());
                if (sorpresaDesfavorable) casillero.agregarElemento(new SorpresaDesfavorable());
                if (sorpresaCambioVehiculo) casillero.agregarElemento(new SorpresaCambioVehiculo());

                this.asignarCasillero(casillero, new Posicion(i, j));
            }
        }
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public void setAlto(int alto){
        this.alto = alto;
    }
}
