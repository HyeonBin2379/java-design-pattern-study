package exercise.interpreter.language;

public class InterpreterFacade implements Executor {

    private final ExecutorFactory factory;
    private Node programNode;

    public InterpreterFacade(ExecutorFactory factory) {
        this.factory = factory;
    }

    public void parse(String text) throws ParseException {
        Context context = new Context(text);
        context.setExecutorFactory(factory);
        this.programNode = new ProgramNode();
        programNode.parse(context);
        System.out.println(programNode.toString());
    }

    @Override
    public void execute() {
        if (programNode != null) {
            programNode.execute();
        }
    }
}
