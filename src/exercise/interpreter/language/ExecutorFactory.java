package exercise.interpreter.language;

public interface ExecutorFactory {

    Executor createExecutor(String name);
}
