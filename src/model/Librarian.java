package model;

import java.util.List;

public class Librarian extends Person {
    private String password;

    public Librarian(int id, String name, String email, String password) {
        super(id, name, email);
        this.password = password;
    }

    @Override
    public String getRole() {
        return "Librarian";
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void searchBook(String keyword, List<Book> bookList) {
        System.out.println("Arama sonuçları:");
        for (Book book : bookList) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(book);
            }
        }
    }

    public void verifyReader(Reader reader) {
        System.out.println(reader.getName() + " doğrulandı.");
    }

    public void issueBook(Reader reader, Book book) {
        if (reader.borrowBook(book)) {
            System.out.println("Kitap ödünç verildi: " + book.getTitle());
        }
    }

    public void returnBook(Reader reader, Book book) {
        if (reader.returnBook(book)) {
            System.out.println("Kitap iade edildi: " + book.getTitle());
        }
    }
}
