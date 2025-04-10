package model;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Reader> readers;
    private List<MemberRecord> memberRecords;

    public Library() {
        this.books = new ArrayList<>();
        this.readers = new ArrayList<>();
        this.memberRecords = new ArrayList<>();
    }

    // --- Kitap İşlemleri ---

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Kitap eklendi: " + book.getTitle());
    }

    public List<Book> getBooks() {
        return books;
    }

    public void showBooks() {
        System.out.println("Kütüphanedeki kitaplar:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book findBookById(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }

    // --- Kullanıcı (Reader) ve Üyelik (MemberRecord) İşlemleri ---

    public void addReader(Reader reader, String memberType, int maxBookLimit) {
        readers.add(reader);
        MemberRecord record = new MemberRecord(reader, memberType, maxBookLimit);
        memberRecords.add(record);
        System.out.println("Okuyucu ve üyelik kaydı oluşturuldu: " + reader.getName());
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public Reader findReaderById(int id) {
        for (Reader reader : readers) {
            if (reader.getId() == id) {
                return reader;
            }
        }
        return null;
    }

    public MemberRecord findMemberRecordByReaderId(int readerId) {
        for (MemberRecord record : memberRecords) {
            if (record.getReader().getId() == readerId) {
                return record;
            }
        }
        return null;
    }

    // --- Kitap Ödünç Verme ve Geri Alma ---

    public void lendBook(int readerId, int bookId) {
        MemberRecord record = findMemberRecordByReaderId(readerId);
        Book book = findBookById(bookId);

        if (record == null || book == null) {
            System.out.println("Üye kaydı veya kitap bulunamadı.");
            return;
        }

        if (record.borrowBook(book)) {
            System.out.println(record.getReader().getName() + " kitabı ödünç aldı: " + book.getTitle());
        }
    }

    public void takeBackBook(int readerId, int bookId) {
        MemberRecord record = findMemberRecordByReaderId(readerId);
        Book book = findBookById(bookId);

        if (record == null || book == null) {
            System.out.println("Üye kaydı veya kitap bulunamadı.");
            return;
        }

        if (record.returnBook(book)) {
            System.out.println(record.getReader().getName() + " kitabı iade etti: " + book.getTitle());
        } else {
            System.out.println("Kitap zaten iade edilmiş veya bu üyeye ait değil.");
        }
    }

    public void showBorrowedBooks(int readerId) {
        MemberRecord record = findMemberRecordByReaderId(readerId);
        if (record != null) {
            record.showBorrowedBooks();
        } else {
            System.out.println("Üye kaydı bulunamadı.");
        }
    }
}
