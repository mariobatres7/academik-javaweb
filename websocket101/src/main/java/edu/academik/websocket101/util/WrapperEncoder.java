package edu.academik.websocket101.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.academik.websocket101.wrapper.Wrapper;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author Mario Batres
 */
public class WrapperEncoder implements Encoder.Text<Wrapper> {

    @Override
    public String encode(Wrapper wrapper) throws EncodeException {

        try {
            ObjectMapper mapper = new ObjectMapper();

            return mapper.writeValueAsString(wrapper);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return "{}";
    }

    @Override
    public void init(EndpointConfig ec) {

    }

    @Override
    public void destroy() {

    }

}
