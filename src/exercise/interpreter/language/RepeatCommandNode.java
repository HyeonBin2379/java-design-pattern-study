package exercise.interpreter.language;

public class RepeatCommandNode extends Node {

    private int number;
    private Node commandListNode;

    @Override
    public void parse(Context context) throws ParseException {
        context.skipToken("repeat");
        number = context.currentNumber();
        context.nextToken();
        commandListNode = new CommandListNode();
        commandListNode.parse(context);
    }

    @Override
    public void execute() {
        for (int i = 0; i < number; i++) {
            commandListNode.execute();
        }
    }

    @Override
    public String toString() {
        return String.format("[repeat %d %s]", number, commandListNode);
    }
}
