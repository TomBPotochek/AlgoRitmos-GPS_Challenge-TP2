package edu.fiuba.algo3.modelo.Logging;

public class LoggerConsola implements LoggingI {

    @Override
    public void log(String evento) {
            System.out.println(evento);
    }
    
}
