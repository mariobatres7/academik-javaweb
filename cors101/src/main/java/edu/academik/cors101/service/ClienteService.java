package edu.academik.cors101.service;

import edu.academik.cors101.modelo.Cliente;
import javax.ejb.Stateless;

/**
 *
 * @author Mario Batres
 */
@Stateless
public class ClienteService {

    public void crearCliente(Cliente cliente) {
        if (cliente.getClienteId() == 1L) {
            throw new ClienteException();
        }
        
        System.out.println("guardando ... " + cliente);
    }

}
