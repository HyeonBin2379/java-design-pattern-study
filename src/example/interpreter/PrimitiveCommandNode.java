package example.interpreter;

public class PrimitiveCommandNode extends Node {

    private String name;

    @Override
    public void parse(Context context) throws ParseException {
        name = context.currentToken();
        if (name == null) {
            throw new ParseException("Error: missing <primitive command>");
        } else if (!name.equals("go") && !name.equals("left") && !name.equals("right")) {
            throw new ParseException("Error: Unknown <primitive command>: '" + name + "'");
        }
        context.skipToken(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
