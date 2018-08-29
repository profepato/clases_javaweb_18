package model.exceptions;

public class ClienteNoEncontradoException extends Exception {

    public ClienteNoEncontradoException() {
    }

    public ClienteNoEncontradoException(String msg) {
        super(msg);
    }
}
