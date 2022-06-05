package movimientos;

public class MovFactory{

    public static Movimiento MovimientoConstruir(String direccion, int cantidad){
        switch (direccion){
            case "Arriba":
                return new MovArriba(cantidad);
            case "Abajo":
                return new MovAbajo(cantidad);
            case "Derecha":
                return new MovDerecha(cantidad);
            case "Izquierda":
                return new MovIzquierda(cantidad);
            default:
                return null;
        }
    }
}
