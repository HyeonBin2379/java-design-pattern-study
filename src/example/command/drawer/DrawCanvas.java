package example.command.drawer;

import example.command.command.MacroCommand;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

// Command 패턴에서의 Receiver에 해당
public class DrawCanvas extends Canvas implements Drawable {

    private Color color;
    private int radius;

    /* 이전의 명령어 수행 이력 */
    private final MacroCommand history;

    // 생성자
    public DrawCanvas(int width, int height, MacroCommand history) {
        setSize(width, height);
        setBackground(Color.WHITE);
        this.history = history;
        init();
    }

    // 이력 전체 다시 그리기
    @Override
    public void paint(Graphics g) {
        /* 이전에 실행했던 명령을 재실행 */
        history.execute();
    }

    // 사용할 색, 점의 크기 초기화
    @Override
    public void init() {
        color = Color.red;
        radius = 6;
        history.append(new ColorCommand(this, color));
    }

    // 지정한 위치에 그리기
    @Override
    public void draw(int x, int y) {
        Graphics g = getGraphics();
        g.setColor(color);
        g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
    }

    // 지정한 색으로 색 변경하기
    @Override
    public void setColor(Color color) {
        this.color = color;
    }
}
