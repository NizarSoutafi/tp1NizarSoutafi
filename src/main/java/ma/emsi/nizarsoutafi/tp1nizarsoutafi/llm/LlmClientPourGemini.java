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
    // Clé pour l'API du LLM
    private final String key;
    // Client REST. Facilite les échanges avec une API REST.
    private Client clientRest; // Pour pouvoir le fermer
    // Représente un endpoint de serveur REST
    private final WebTarget target;

    public LlmClientPourGemini() {
        // Récupère la clé secrète pour travailler avec l'API du LLM, mise dans une variable d'environnement
        // du système d'exploitation.
        this.key = System.getenv("GEMINI_KEY");
        //A ECRIRE...
        // Client REST pour envoyer des requêtes vers les endpoints de l'API d'OpenAI
        this.clientRest = ClientBuilder.newClient();
        // Endpoint REST pour envoyer la question à l'API.
        this.target = clientRest.target("https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash-latest:generateContent?key=" + this.key);
    }

    public Response envoyerRequete(Entity<?> requestEntity) {
        return target.request(MediaType.APPLICATION_JSON_TYPE).post(requestEntity);
    }

    public void closeClient() {
        clientRest.close();
    }
}

