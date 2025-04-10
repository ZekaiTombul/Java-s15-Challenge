package model;

import java.util.ArrayList;
import java.util.List;

public class MemberRecord {
    private Reader reader;
    private String memberType; // Örn: "Student", "Faculty"
    private int maxBookLimit;
    private List<Book> borrowedBooks;

    public MemberRecord(Reader reader, String memberType, int maxBookLimit) {
        this.reader = reader;
        this.memberType = memberType;
        this.maxBookLimit = maxBookLimit;
        this.borrowedBooks = new ArrayList<>();
    }

    public Reader getReader() {
        return reader;
    }

    public String getMemberType() {
        return memberType;
    }

    public int getMaxBookLimit() {
        return maxBookLimit;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public boolean borrowBook(Book book) {
        if (borrowedBooks.size() >= maxBookLimit) {
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

    public void showBorrowedBooks() {
        System.out.println(reader.getName() + " adlı üyenin ödünç aldığı kitaplar:");
        for (Book book : borrowedBooks) {
            System.out.println("- " + book.getTitle());
        }
    }
}
