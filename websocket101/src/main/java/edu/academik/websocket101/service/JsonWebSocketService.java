package edu.academik.websocket101.service;

import edu.academik.websocket101.util.WrapperDecoder;
import edu.academik.websocket101.util.WrapperEncoder;
import edu.academik.websocket101.wrapper.Wrapper;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.EncodeException;
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
@ServerEndpoint(value = "/json", encoders = WrapperEncoder.class, decoders = WrapperDecoder.class)
public class JsonWebSocketService {

    private Map<Session, Timer> sessionTimerMap = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session) {

        System.out.println(" json conectado:  " + session.getId());

        Wrapper wrapper = new Wrapper();
        wrapper.setCode(1L);
        wrapper.setMessage("Conectado con éxito");
        wrapper.setStatus("Activo");

        try {
            session.getBasicRemote().sendObject(wrapper);
        } catch (IOException | EncodeException ex) {
            Logger.getLogger(JsonWebSocketService.class.getName()).log(Level.SEVERE, null, ex);
        }

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                try {
                    Wrapper wrapper2 = new Wrapper();
                    wrapper2.setCode(2L);
                    wrapper2.setMessage("Con timer");
                    wrapper2.setStatus("PROCESANDO");

                    session.getBasicRemote().sendObject(wrapper2);
                } catch (IOException | EncodeException ex) {
                    Logger.getLogger(JsonWebSocketService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };

        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(timerTask, 0, 5 * 1000);

        sessionTimerMap.put(session, timer);
    }

    @OnClose
    public void onClose(Session session) {

        Optional.ofNullable(sessionTimerMap.get(session)).ifPresent(timer -> {

            System.out.println(" cancelando timer:  " + session.getId());
            timer.cancel();
        });

        System.out.println(" json cerrado:  " + session.getId());

    }

    @OnError
    public void onError(Session session, Throwable error) {

        System.out.println(" json error:  " + session.getId() + ", " + error.getMessage());
    }

    @OnMessage
    public void onMessage(Session session, Wrapper wrapper) {

        try {
            System.out.println(" json recibido: " + wrapper);

            session.getOpenSessions().stream().forEach(s -> {

                try {

                    s.getBasicRemote().sendObject(wrapper);

                } catch (IOException | EncodeException ex) {
                    Logger.getLogger(JsonWebSocketService.class.getName()).log(Level.SEVERE, null, ex);
                }

            });

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}
