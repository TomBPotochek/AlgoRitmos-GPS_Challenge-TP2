package movimientos;

public class MovFactory{

    public static Movimiento MovimientoConstruir(String direccion){
        switch (direccion){
            case "Arriba":
                return new MovArriba();
            case "Abajo":
                return new MovAbajo();
            case "Derecha":
                return new MovDerecha();
            case "Izquierda":
                return new MovIzquierda();
            default:
                return null;//acá podría lanzar una excepción
        }
    }
}
