package edu.fiuba.algo3.modelo.casillero;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.casillero.Efecto.Efecto;
import edu.fiuba.algo3.modelo.casillero.azar.ProveedorDatosAzar;
import edu.fiuba.algo3.modelo.vehiculos.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.*;

public class ControlPolicialTest {
    
    @Test
    public void motoSinCascoResultaEnEfectoSumaDe3Movimientos(){
        ProveedorDatosAzar randomMock = mock(ProveedorDatosAzar.class);
        when(randomMock.eventoConProbabilidad(0.8)).thenReturn(true);

        ElementoMapa controlPolicial = new ControlPolicial(randomMock);

        Moto motoMock = mock(Moto.class);
        Efecto efecto = controlPolicial.interactuar(motoMock);

        for (int i = 0; i < 11; i++){
            assertEquals(efecto.actualizar(i), i+3);
        }       
    }

    @Test
    public void motoConCascoResultaEnEfectoQueNoSumaMovimientos(){
        ProveedorDatosAzar randomMock = mock(ProveedorDatosAzar.class);
        when(randomMock.eventoConProbabilidad(0.8)).thenReturn(false);
    
        ElementoMapa controlPolicial = new ControlPolicial(randomMock);
    
        Moto motoMock = mock(Moto.class);
        Efecto efecto = controlPolicial.interactuar(motoMock);
    
        for (int i = 0; i < 11; i++){
            assertEquals(efecto.actualizar(i), i);
        }       
    }
    
    @Test
    public void autoSinCinturonResultaEnEfectoSumaDe3Movimientos(){
        ProveedorDatosAzar randomMock = mock(ProveedorDatosAzar.class);
        when(randomMock.eventoConProbabilidad(0.5)).thenReturn(true);
    
        ElementoMapa controlPolicial = new ControlPolicial(randomMock);
    
        Auto motoMock = mock(Auto.class);
        Efecto efecto = controlPolicial.interactuar(motoMock);
    
        for (int i = 0; i < 11; i++){
            assertEquals(efecto.actualizar(i), i+3);
        }       
    }

// TODO: Resto de los test (son todos asi)

}
