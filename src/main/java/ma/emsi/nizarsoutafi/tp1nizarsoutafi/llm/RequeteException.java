package ma.emsi.nizarsoutafi.tp1nizarsoutafi.llm;

public class RequeteException extends RuntimeException {
    public RequeteException(String message, String prettyPrinting) {
        super(message + "\n" + prettyPrinting);
    }
}