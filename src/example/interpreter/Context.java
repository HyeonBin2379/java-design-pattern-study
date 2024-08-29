package example.interpreter;

public class Context {

    private final String[] tokens;
    private String lastToken;
    private int index;

    public Context(String text) {
        this.tokens = text.split("\\s+");
        this.index = 0;
        nextToken();
    }

    public String nextToken() {
        return lastToken = (index < tokens.length) ? tokens[index++] : null;
    }

    public String currentToken() {
        return lastToken;
    }

    public void skipToken(String token) throws ParseException {
        if (currentToken() == null) {
            throw new ParseException(String.format("Error: '%s' is expected, "
                    + "but no more token is found.\n", token));
        } else if (!token.equals(currentToken())) {
            throw new ParseException(String.format("Error: '%s' is expected, "
                    + "but '%s' is found.\n", token, currentToken()));
        }
        nextToken();
    }
    public int currentNumber() throws ParseException {
        if (currentToken() == null) {
            throw new ParseException("Error: No more token.");
        }
        int number = 0;
        try {
            number = Integer.parseInt(currentToken());
        } catch (NumberFormatException e) {
            throw new ParseException("Error: " + e);
        }
        return number;
    }
}
