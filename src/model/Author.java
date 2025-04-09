package model;

import java.util.ArrayList;
import java.util.List;

public class Author extends Person {
    private List<Book> books;

    public Author(int id, String name, String email) {
        super(id, name, email);
        this.books = new ArrayList<>();
    }

    @Override
    public String getRole() {
        return "Author";
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Yeni kitap eklendi: " + book.getTitle());
    }

    public void showBooks() {
        System.out.println(getName() + " adlı yazarın kitapları:");
        for (Book book : books) {
            System.out.println("- " + book.getTitle());
        }
    }

    public List<Book> getBooks() {
        return books;
    }
}
