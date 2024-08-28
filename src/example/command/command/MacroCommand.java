package example.command.command;

import java.util.ArrayDeque;
import java.util.Deque;

// Command 패턴에서의 ConcreteCommand에 해당
// 여러 개의 명령어를 저장
public class MacroCommand implements Command {

    /* Command 실행 이력 저장(Memento 패턴 차용) - Stack 사용
    * (최신 자바 버전에서는 Stack 사용 시 java.util.Stack보다 Java Collection Framework의 덱을 사용할 것을 권장)*/
    private final Deque<Command> commands = new ArrayDeque<>();

    /* 명령 실행 이력에 저장된 모든 Command를 실행 */
    @Override
    public void execute() {
        for (Command cmd : commands) {
            cmd.execute();
        }
    }

    public void append(Command cmd) {   // 사용한 명령어를 이력에 추가
        if (cmd == this) {
            throw new IllegalArgumentException("infinite loop caused by append");
        }
        commands.push(cmd);
    }

    public void undo() {    // 마지막으로 사용했던 명령 취소
        if (!commands.isEmpty()) {
            commands.pop();
        }
    }

    public void clear() {   // 전체 이력 삭제
        commands.clear();
    }
}
