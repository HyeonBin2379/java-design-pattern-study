package example.command.drawer;

import example.command.command.Command;
import java.awt.Color;

// Command 패턴에서의 ConcreteCommand에 해당
public class ColorCommand implements Command {

    private final Color color;

    /* Command를 적용할 Receiver */
    protected Drawable drawable;

    public ColorCommand(Drawable drawable, Color color) {
        this.drawable = drawable;
        this.color = color;
    }

    /* 지정한 Receiver에 명령을 수행 */
    // Drawable이 가리키는 Receiver가 현재 사용 중인 색을 변경
    @Override
    public void execute() {
        drawable.setColor(color);
    }
}
