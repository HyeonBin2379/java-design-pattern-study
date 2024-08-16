package exercise.iterator;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf();
        bookShelf.appendBook(new Book("Stranger"));
        bookShelf.appendBook(new Book("Le Miserable"));
        bookShelf.appendBook(new Book("Three Musketeer"));
        bookShelf.appendBook(new Book("Bible"));

        Iterator<Book> iterator = bookShelf.iterator();
        while (!iterator.hasNext()) {
            Book book = iterator.next();
            System.out.println(book.getName());
        }
        System.out.println();

        for (Book book : bookShelf) {
            System.out.println(book.getName());
        }
        System.out.println();
    }
}
