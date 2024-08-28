package example.command.drawer;

import java.awt.Color;

// Command 패턴에서의 Receiver가 수행하는 주요 기능을 정의
public interface Drawable {

    void init();
    void draw(int x, int y);
    void setColor(Color color);
}
