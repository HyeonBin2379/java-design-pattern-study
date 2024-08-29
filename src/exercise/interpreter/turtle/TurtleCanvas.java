package exercise.interpreter.turtle;

import exercise.interpreter.language.Executor;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

public class TurtleCanvas extends Canvas {

    final static int UNIT_LENGTH = 30;
    final static int DIRECTION_UP = 0;
    final static int DIRECTION_RIGHT = 3;
    final static int DIRECTION_DOWN = 6;
    final static int DIRECTION_LEFT = 9;

    final static int RELATIVE_DIRECTION_RIGHT = 3;
    final static int RELATIVE_DIRECTION_LEFT = -3;
    final int RADIUS = 3;

    private int direction = 0;
    private Point position;
    private Executor executor = null;

    public TurtleCanvas(int width, int height) {
        setSize(width, height);
        initialize();
    }

    private void initialize() {
        Dimension size = getSize();
        position = new Point(size.width / 2, size.height / 2);
        direction = 0;
        setForeground(Color.red);
        setBackground(Color.white);
        Graphics g = getGraphics();
        if (g != null) {
            g.clearRect(0, 0, size.width, size.height);
        }
    }

    public void setExecutor(Executor executor) {
        this.executor = executor;
    }

    void setRelativeDirection(int relativeDirection) {
        setDirection(direction + relativeDirection);
    }

    void setDirection(int direction) {
        if (direction < 0) {
            direction = 12 - (-direction) % 12;
        } else {
            direction = direction % 12;
        }
        this.direction = direction % 12;
    }

    void go() {
        int newX = position.x;
        int newY = position.y;
        switch (direction) {
            case DIRECTION_UP:
                newY -= TurtleCanvas.UNIT_LENGTH;
                break;
            case DIRECTION_RIGHT:
                newX += TurtleCanvas.UNIT_LENGTH;
                break;
            case DIRECTION_DOWN:
                newY += TurtleCanvas.UNIT_LENGTH;
                break;
            case DIRECTION_LEFT:
                newX -= TurtleCanvas.UNIT_LENGTH;
                break;
        }
        Graphics g = getGraphics();
        if (g != null) {
            g.drawLine(position.x, position.y, newX, newY);
            g.fillOval(newX-RADIUS, newY-RADIUS, RADIUS*2+1, RADIUS*2+1);
        }
        position.x = newX;
        position.y = newY;
    }

    @Override
    public void paint(Graphics g) {
        initialize();
        if (executor != null) {
            executor.execute();
        }
    }
}
