package model;

import java.time.LocalDate;

public class Book implements BookActions {
    private int bookId;
    private String title;
    private Author author;
    private double price;
    private boolean available;
    private String edition;
    private LocalDate dateOfPurchase;
    private BookType type;

    public Book(int bookId, String title, Author author, double price, String edition,
                LocalDate dateOfPurchase, BookType type) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
        this.edition = edition;
        this.dateOfPurchase = dateOfPurchase;
        this.available = true;
        this.type = type;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    // 🔧 Yeni eklenen metot (diğer sınıflarda çağrılıyor!)
    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public void updateStatus(boolean isAvailable) {
        this.available = isAvailable;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(LocalDate dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public BookType getType() {
        return type;
    }

    public void setType(BookType type) {
        this.type = type;
    }

    @Override
    public void changeOwner(Person newOwner) {
        System.out.println("Kitap artık " + newOwner.getName() + " kişisine aittir.");
    }

    @Override
    public String toString() {
        return "Kitap ID: " + bookId +
                ", Başlık: " + title +
                ", Yazar: " + author.getName() +
                ", Tür: " + type.name() +
                ", Fiyat: " + price +
                ", Baskı: " + edition +
                ", Alım Tarihi: " + dateOfPurchase +
                ", Durum: " + (available ? "Uygun" : "Ödünçte");
    }
}
