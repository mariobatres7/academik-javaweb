package edu.academik.websocket101.client;

import java.io.IOException;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;

/**
 *
 * @author Mario Batres
 */
public class ClienteEndpoint extends Endpoint {

    private Session session;

    @Override
    public void onOpen(Session session, EndpointConfig endpointConfig) {
        
        this.session = session;

        this.session.addMessageHandler(new MessageHandler.Whole<String>() {
            @Override
            public void onMessage(String message) {
                System.out.println("retrieved  !!:  " + message);
            }
        });
    }

    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    

    public Session getSession() {
        return session;
    }

}
