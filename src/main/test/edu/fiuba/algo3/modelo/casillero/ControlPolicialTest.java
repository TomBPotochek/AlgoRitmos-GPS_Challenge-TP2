package edu.fiuba.algo3.modelo.casillero;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.casillero.Efecto.BaseEfectoDecorador;
import edu.fiuba.algo3.modelo.casillero.Efecto.EfectoNulo;
import edu.fiuba.algo3.modelo.casillero.azar.ProveedorDatosAzar;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.vehiculos.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class ControlPolicialTest {
    
    @Test
    public void motoSinCascoResultaEnEfectoSumaDe3Movimientos(){
        ProveedorDatosAzar randomMock = mock(ProveedorDatosAzar.class);
        when(randomMock.eventoConProbabilidad(0.8)).thenReturn(true);

        ElementoMapa controlPolicial = new ControlPolicial(randomMock);

        Moto motoMock = mock(Moto.class);

        EfectoNulo efectoADecorarMock = mock(EfectoNulo.class);
        BaseEfectoDecorador efecto = controlPolicial.interactuar(motoMock);
        efecto.decorar(efectoADecorarMock);

        Jugador jugadorMock = spy(new Jugador(mock(Vehiculo.class)));
        
        for (int i = 0; i < 11; i++){
            doReturn(i).when(jugadorMock).verCantMovs();
            efecto.aplicarseSobre(jugadorMock);
            assertTrue(jugadorMock.cantidadDeMovimientosEs(i+3));
        }       
    }

    @Test
    public void motoConCascoResultaEnEfectoQueNoSumaMovimientos(){
        ProveedorDatosAzar randomMock = mock(ProveedorDatosAzar.class);
        when(randomMock.eventoConProbabilidad(0.8)).thenReturn(false);

        ElementoMapa controlPolicial = new ControlPolicial(randomMock);

        Moto motoMock = mock(Moto.class);

        EfectoNulo efectoADecorarMock = mock(EfectoNulo.class);
        BaseEfectoDecorador efecto = controlPolicial.interactuar(motoMock);
        efecto.decorar(efectoADecorarMock);

        Jugador jugadorMock = spy(new Jugador(mock(Vehiculo.class)));
        
        for (int i = 0; i < 11; i++){
            doReturn(i).when(jugadorMock).verCantMovs();
            efecto.aplicarseSobre(jugadorMock);
            assertTrue(jugadorMock.cantidadDeMovimientosEs(i));
        }        
    }
    
    @Test
    public void autoSinCinturonResultaEnEfectoSumaDe3Movimientos(){
        ProveedorDatosAzar randomMock = mock(ProveedorDatosAzar.class);
        when(randomMock.eventoConProbabilidad(0.5)).thenReturn(true);

        ElementoMapa controlPolicial = new ControlPolicial(randomMock);

        Auto autoMock = mock(Auto.class);

        EfectoNulo efectoADecorarMock = mock(EfectoNulo.class);
        BaseEfectoDecorador efecto = controlPolicial.interactuar(autoMock);
        efecto.decorar(efectoADecorarMock);

        Jugador jugadorMock = spy(new Jugador(mock(Vehiculo.class)));
        
        for (int i = 0; i < 11; i++){
            doReturn(i).when(jugadorMock).verCantMovs();
            efecto.aplicarseSobre(jugadorMock);
            assertTrue(jugadorMock.cantidadDeMovimientosEs(i+3));
        }
    }

// TODO: Resto de los test (son todos asi)

}
