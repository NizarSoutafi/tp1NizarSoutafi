package ma.emsi.nizarsoutafi.tp1nizarsoutafi.llm;

import jakarta.enterprise.context.Dependent;
import jakarta.ws.rs.client.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.Serializable;

/**
 * Gère l'interface avec l'API de Gemini.
 */
@Dependent
public class LlmClientPourGemini implements Serializable {
    private final String key = "AIzaSyC9O7NTcmXz7oSPpCTvhb-FdvumUT_w97Y";
    private final Client clientRest = ClientBuilder.newClient();
    private final WebTarget target;

    public LlmClientPourGemini() {
        this.target = clientRest.target("https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash-latest:generateContent?key=" + this.key);
    }

    public Response envoyerRequete(Entity<?> requestEntity) {
        return target.request(MediaType.APPLICATION_JSON_TYPE).post(requestEntity);
    }

    public void closeClient() {
        clientRest.close();
    }
}

