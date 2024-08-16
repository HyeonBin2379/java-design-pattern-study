package exercise.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

// Iterator 패턴의 ConcreteIterator에 해당
// java.util.Iterator는 Iterator 패턴의 Iterator에 해당
public class BookShelfIterator1 implements Iterator<Book> {

    private final BookShelf bookShelf;
    private int index;

    public BookShelfIterator1(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    // 다음 요소가 존재하는지 확인(반복 종료 조건)
    @Override
    public boolean hasNext() {
        return index < bookShelf.getLength();
    }

    // 인덱스의 각 요소들을 순회
    @Override
    public Book next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Book book = bookShelf.getBookAt(index);
        index++;
        return book;
    }
}
