package edu.fiuba.algo3.modelo.Logging;

public class Logger {
    
    private static LoggingI logger;
    private static boolean loggear = false;


    public static void enableLogging(boolean value){
        loggear = value;
    }

    public static void setLogger(LoggingI log){
        logger = log;
    }

    public static void log(String evento){
        if (loggear)
            logger.log(evento);
    }
}
