package exercise.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BookShelfIterator2 implements Iterator<Book> {

    private final BookShelf bookShelf;
    private int index;

    public BookShelfIterator2(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    // 다음 요소가 존재하는지 확인(반복 종료 조건)
    @Override
    public boolean hasNext() {
        return index < bookShelf.getLength();
    }

    // 인덱스가 짝수인 요소만 순회(반복 진행)
    @Override
    public Book next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Book book = bookShelf.getBookAt(index);
        index += 2;
        return book;
    }
}
