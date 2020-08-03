package edu.academik.cors101.service;

/**
 *
 * @author Mario Batres
 */
public class ClienteException extends RuntimeException {

    public ClienteException() {
        super("Error en la creación de clientes");
    }

}
