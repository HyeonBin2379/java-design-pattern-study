package example.command.drawer;

import example.command.command.Command;
import java.awt.Point;

// Command 패턴에서의 ConcreteCommand에 해당
public class DrawCommand implements Command {

    /* ConcreteCommand의 명령을 실행할 Receiver */
    protected Drawable drawable;
    private final Point position;

    // 명령어 실행 대상 설정
    public DrawCommand(Drawable drawable, Point position) {
        this.drawable = drawable;
        this.position = position;
    }

    /* ConcreteCommand의 명령을 Receiver에게 실행 */
    @Override
    public void execute() {
        drawable.draw(position.x, position.y);
    }
}