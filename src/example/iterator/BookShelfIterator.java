package example.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

// Iterator 패턴의 ConcreteIterator에 해당
public class BookShelfIterator implements Iterator<Book> {

    private final BookShelf bookShelf;
    private int index;

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    // 다음에 접근할 집합체의 요소가 존재하는지 확인
    @Override
    public boolean hasNext() {
        return index < bookShelf.getLength();
    }

    // 현재 요소를 반환하고 다음 위치로 진행
    @Override
    public Book next() {
        // 다음에 접근할 집합체의 요소가 없으면 예외 발생
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        // 다음에 접근할 요소가 존재하면 그 요소를 반환
        Book book = bookShelf.getBookAt(index);

        // 현재 요소를 다음 위치로 변경
        index++;
        return book;
    }
}
