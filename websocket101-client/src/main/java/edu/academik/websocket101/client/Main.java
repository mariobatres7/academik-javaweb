package edu.academik.websocket101.client;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.WebSocketContainer;

/**
 *
 * @author Mario Batres
 */
public class Main {

    public static void main(String[] args) throws URISyntaxException, DeploymentException, IOException, InterruptedException {
        
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();

        ClienteEndpoint clienteEndpoint = new ClienteEndpoint();

        container.connectToServer(clienteEndpoint, new URI("ws://localhost:8080/websocket/socket"));

        for (int i = 0; i < 10; i++) {
            String message = "Enviando mi mensaje " + i;
            clienteEndpoint.sendMessage(message);
            System.out.println(message);

            Thread.sleep(2000);
        }

        clienteEndpoint.getSession().close();
    }

}
