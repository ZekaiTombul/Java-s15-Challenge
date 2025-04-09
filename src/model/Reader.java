package model;

import java.util.HashSet;
import java.util.Set;

public class Reader extends Person{

    private Set<Book> borrowedBooks;

    private static final int MAX_BOOKS =5;

    public Reader(int id, String name, String email) {
        super(id, name, email);
        this.borrowedBooks = new HashSet<>();
    }

    @Override
    public String getRole() {
        return "Reader";
    }

    public boolean borrowBook(Book book) {
        if (borrowedBooks.size() >= MAX_BOOKS) {
            System.out.println("Kitap limitine ulaşıldı.");
            return false;
        }

        if (!book.isAvailable()) {
            System.out.println("Kitap şu anda ödünçte.");
            return false;
        }

        borrowedBooks.add(book);
        book.setAvailable(false);
        return true;
    }

    public boolean returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.setAvailable(true);
            return true;
        }
        return false;
    }

    public Set<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

}
