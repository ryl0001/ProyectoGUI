package DB4O_1;


/**
 * Esta clase será la excepción para gestionar las excepciones con DB4O
 * @author Francisco Jesús Delgado Almirón
 */
public class DB4OException extends Exception {

    public DB4OException(String mensaje) {
        super(mensaje);
    }
}
