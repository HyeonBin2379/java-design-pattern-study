package example.iterator;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book("Around the World in 80 days"));
        bookShelf.appendBook(new Book("Bible"));
        bookShelf.appendBook(new Book("Cinderella"));
        bookShelf.appendBook(new Book("Daddy-Long-Legs"));

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
