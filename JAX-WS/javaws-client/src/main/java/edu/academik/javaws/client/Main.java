package edu.academik.javaws.client;

/**
 *
 * @author Mario Batres
 */
public class Main {

    public static void main(String[] args) {

        var clienteWebService = new ClienteWebService();

        var clienteResponseList = clienteWebService.getClientesPort().buscarClientes();
        
        clienteResponseList.stream().forEach(clienteResponse -> {
            System.out.print(clienteResponse.clienteId);
            System.out.print("\t" + clienteResponse.codigo);
            System.out.print("\t" + clienteResponse.nombre);
            System.out.println("\t" + clienteResponse.creadoEl);
        });
    }
}
