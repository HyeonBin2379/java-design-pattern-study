package example.command;

import example.command.command.*;
import example.command.drawer.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Command 패턴에서의 Client이자 Invoker에 해당
public class Main extends JFrame {

    /* Command 실행 이력 저장용*/
    private final MacroCommand history = new MacroCommand();

    /* Command를 실행할 Receiver*/
    private final DrawCanvas canvas = new DrawCanvas(400, 400, history);    // 그리기 영역

    public Main(String title) {
        super(title);

        // 윈도우 닫기 버튼 클릭 시 실행 종료
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        // 화면에서 마우스 드래그 시 점 그리기를 수행하는 Command를 지정한 Receiver에서 실행하도록 설정
        canvas.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                Command cmd = new DrawCommand(canvas, e.getPoint());
                history.append(cmd);
                cmd.execute();
            }
        });

        /* Invoker는 버튼 클릭 시 실행할 Command를 호출한 후 실행 이력에 추가 */
        Box buttonBox = new Box(BoxLayout.X_AXIS);
        // 전체 지우기 버튼
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(e -> {
            history.clear();
            canvas.repaint();
        });
        buttonBox.add(clearButton);

        // 되돌리기 버튼
        JButton undoButton = new JButton("Undo");
        undoButton.addActionListener(e -> {
            history.undo();
            canvas.repaint();
        });
        buttonBox.add(undoButton);

        // 빨간색으로 변경
        JButton redButton = new JButton("Red");
        redButton.addActionListener(e -> {
            Command cmd = new ColorCommand(canvas, Color.red);
            history.append(cmd);
            cmd.execute();
        });
        buttonBox.add(redButton);

        // 초록색으로 변경
        JButton greenButton = new JButton("Green");
        greenButton.addActionListener(e -> {
            Command cmd = new ColorCommand(canvas, Color.green);
            history.append(cmd);
            cmd.execute();
        });
        buttonBox.add(greenButton);

        // 파란색으로 변경
        JButton blueButton = new JButton("Blue");
        blueButton.addActionListener(e -> {
            Command cmd = new ColorCommand(canvas, Color.BLUE);
            history.append(cmd);
            cmd.execute();
        });
        buttonBox.add(blueButton);

        // 버튼 모음, 그림판 추가
        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox);

        // 실행창 띄우기
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main("Command Pattern Sample");
    }
}
