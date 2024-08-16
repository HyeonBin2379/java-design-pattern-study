package exercise.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Iterator 패턴의 ConcreteAggregate에 해당
// java.lang.Itarable<Book>은 Iterator 패턴의 Aggregation
public class BookShelf implements Iterable<Book> {

    private final List<Book> books;

    public BookShelf() {
        books = new ArrayList<>();
    }

    public Book getBookAt(int index) {
        return books.get(index);
    }

    public void appendBook(Book book) {
        books.add(book);
    }

    public int getLength() {
        return books.size();
    }

    // BookShelf의 각 요소마다 처리를 반복하기 위한 ConcreteIterator 생성
    @Override
    public Iterator<Book> iterator() {
        return new BookShelfIterator1(this);
    }
    // 1개의 ConcreteAggregate에 여러 개의 ConcreteIterator 사용
    public Iterator<Book> iterator2() {
        return new BookShelfIterator2(this);
    }
}
