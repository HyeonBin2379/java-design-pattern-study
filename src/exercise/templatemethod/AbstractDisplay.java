package exercise.templatemethod;

public interface AbstractDisplay {

    void open();
    void close();
    void print();

    default void display() {
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}
