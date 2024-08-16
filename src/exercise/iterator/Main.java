package exercise.iterator;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf();
        bookShelf.appendBook(new Book("Around the World in 80 days"));
        bookShelf.appendBook(new Book("Bible"));
        bookShelf.appendBook(new Book("Cinderella"));
        bookShelf.appendBook(new Book("Daddy-Long-Legs"));
        bookShelf.appendBook(new Book("East of Eden"));
        bookShelf.appendBook(new Book("Frankenstein"));
        bookShelf.appendBook(new Book("Gulliver's Travels"));
        bookShelf.appendBook(new Book("Hamlet"));

        // 명시적으로 Iterator를 사용1: 모든 요소 순회
        System.out.println("Using explicit iterator1:");
        Iterator<Book> iterator = bookShelf.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            System.out.println(book.getName());
        }
        System.out.println();

        // 명시적으로 Iterator를 사용2: 인덱스가 짝수인 요소만 순회
        System.out.println("Using explicit iterator2:");
        Iterator<Book> iterator2 = bookShelf.iterator2();
        while (iterator2.hasNext()) {
            Book book = iterator2.next();
            System.out.println(book.getName());
        }
        System.out.println();

        // 확장 for문을 사용하는 방법
        System.out.println("Using for-each loop:");
        for (Book book : bookShelf) {
            System.out.println(book.getName());
        }
        System.out.println();
    }
}
