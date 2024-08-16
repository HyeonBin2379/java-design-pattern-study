package example.iterator;

import java.util.Iterator;

// Iterator 패턴의 ConcreteAggregate에 해당
public class BookShelf implements Iterable<Book> {

    private final Book[] books;         // 집합체는 배열로 구현
    private int last = 0;               // 데이터가 저장될 다음 노드이자 집합체의 크기

    public BookShelf(int maxsize) {
        books = new Book[maxsize];
    }

    public Book getBookAt(int index) {
        return books[index];
    }

    public void appendBook(Book book) {
        books[last] = book;
        last++;
    }

    public int getLength() {
        return last;
    }

    // 집합체에 저장된 요소를 1개씩, 순서대로 반환
    @Override
    public Iterator<Book> iterator() {
        return new BookShelfIterator(this);
    }
}
