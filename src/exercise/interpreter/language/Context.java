package exercise.interpreter.language;

public class Context implements ExecutorFactory {

    private final String[] tokens;

    private String lastToken;
    private ExecutorFactory factory;
    private int index;

    public Context(String text) {
        this.tokens = text.split("\\s+");
        this.index = 0;
        nextToken();
    }

    public String nextToken() {
        if (index < tokens.length) {
            lastToken = tokens[index++];
        } else {
            lastToken = null;
        }
        return lastToken;
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

    public void setExecutorFactory(ExecutorFactory factory) {
        this.factory = factory;
    }

    @Override
    public Executor createExecutor(String name) {
        return factory.createExecutor(name);
    }
}
