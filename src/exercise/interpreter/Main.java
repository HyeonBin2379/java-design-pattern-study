package exercise.interpreter;

import exercise.interpreter.language.InterpreterFacade;
import exercise.interpreter.language.ParseException;
import exercise.interpreter.turtle.TurtleCanvas;
import exercise.interpreter.turtle.TurtleExecutorFactory;
import java.awt.BorderLayout;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main extends JFrame {

    private final TurtleCanvas canvas = new TurtleCanvas(400, 400);
    private final InterpreterFacade facade = new InterpreterFacade(new TurtleExecutorFactory(canvas));
    private final TextField programTextField = new TextField("program repeat 3 go right go left end end");

    public Main(String title) {
        super(title);
        canvas.setExecutor(facade);
        setLayout(new BorderLayout());
        programTextField.addActionListener(e -> parseAndExecute());
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        add(programTextField, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        pack();
        setVisible(true);
        parseAndExecute();
    }

    private void parseAndExecute() {
        String programText = programTextField.getText();
        System.out.println("programText = " + programText);
        try {
            facade.parse(programText);
            canvas.repaint();
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new Main("Interpreter Pattern Sample");
    }
}
