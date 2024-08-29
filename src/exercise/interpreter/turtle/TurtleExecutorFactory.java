package exercise.interpreter.turtle;

import exercise.interpreter.language.Executor;
import exercise.interpreter.language.ExecutorFactory;

public class TurtleExecutorFactory implements ExecutorFactory {

    private final TurtleCanvas canvas;

    private class GoExecutor implements Executor {
        @Override
        public void execute() {
            canvas.go();
        }
    }

    private class LeftExecutor implements Executor {
        @Override
        public void execute() {
            canvas.setRelativeDirection(TurtleCanvas.RELATIVE_DIRECTION_LEFT);
        }
    }

    private class RightExecutor implements Executor {
        @Override
        public void execute() {
            canvas.setRelativeDirection(TurtleCanvas.RELATIVE_DIRECTION_RIGHT);
        }
    }

    public TurtleExecutorFactory(TurtleCanvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public Executor createExecutor(String name) {
        return switch (name) {
            case "go" -> new GoExecutor();
            case "left" -> new LeftExecutor();
            case "right" -> new RightExecutor();
            default -> throw new IllegalArgumentException("Error: Unknown <primitive command>: '" + name + "'");
        };
    }
}
