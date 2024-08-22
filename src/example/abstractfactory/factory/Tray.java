package example.abstractfactory.factory;

import java.util.ArrayList;
import java.util.List;

// Abstract Factory 패턴의 AbstractProduct에 해당
// 이 클래스의 하위 클래스가 구현해야 할 메서드는 이미 Item에서 정의
// 여러 개의 List나 Tray를 모아 한데 묶는 클래스
public abstract class Tray extends Item{

    protected List<Item> tray = new ArrayList<>();

    public Tray(String caption) {
        super(caption);
    }

    public void add(Item item) {
        tray.add(item);
    }
}
