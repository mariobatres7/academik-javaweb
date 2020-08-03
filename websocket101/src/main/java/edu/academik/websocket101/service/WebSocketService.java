package edu.academik.websocket101.service;

import java.io.IOException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author Mario Batres
 */
@ServerEndpoint(value = "/socket")
public class WebSocketService {

    
    
    @OnOpen
    public void onOpen(Session session) {

        System.out.println("conectado:  " + session.getId());
    }

    @OnClose
    public void onClose(Session session) {

        System.out.println("cerrado:  " + session.getId());

    }

    @OnError
    public void onError(Session session, Throwable error) {

        System.out.println("error:  " + session.getId() + ", " + error.getMessage());
    }

    @OnMessage
    public void onMessage(Session session, String message) {

        try {
            System.out.println("recibido: " + message);

            //session.getBasicRemote().sendText("Tu mensaje ha sido recibido " + session.getId());
            System.out.println("mensaje contestado " + session.getOpenSessions().size());

            session.getOpenSessions()
                    .stream()
                    .filter(s -> !s.equals(session))
                    .forEach(s -> {

                        try {
                            s.getBasicRemote().sendText(s.getId() + " Notificando mensajes a otras sessiones:  " + message);

                        } catch (IOException ex) {
                            System.err.println(ex.getMessage());
                        }
                    });

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}
