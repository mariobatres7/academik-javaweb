package edu.academik.websocket101.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.academik.websocket101.wrapper.Wrapper;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author Mario Batres
 */
public class WrapperDecoder implements Decoder.Text<Wrapper> {

    @Override
    public Wrapper decode(String string) throws DecodeException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(string, Wrapper.class);
        } catch (IOException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return null;
    }

    @Override
    public boolean willDecode(String string) {
        return string != null;
    }

    @Override
    public void init(EndpointConfig ec) {

    }

    @Override
    public void destroy() {

    }

}
