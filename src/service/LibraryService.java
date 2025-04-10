package service;

import model.*;

import java.time.LocalDate;
import java.util.Scanner;

public class LibraryService {
    private Library library;
    private Scanner scanner;

    public LibraryService(Library library, Scanner scanner) {
        this.library = library;
        this.scanner = scanner;
    }

    // --- Kitap Ekleme ---
    public void addBook() {
        System.out.print("Kitap başlığı: ");
        String title = scanner.nextLine();

        System.out.print("Yazar adı: ");
        String authorName = scanner.nextLine();

        System.out.print("Yazar email: ");
        String authorEmail = scanner.nextLine();

        Author author = new Author(generateId(), authorName, authorEmail);

        System.out.print("Fiyat: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.print("Baskı bilgisi: ");
        String edition = scanner.nextLine();

        LocalDate purchaseDate = LocalDate.now();

        BookType type = getBookTypeFromUser();

        Book book = new Book(generateId(), title, author, price, edition, purchaseDate, type);
        library.addBook(book);

        // ✅ Kitap ID'si yazdırılıyor
        System.out.println("Kitap eklendi: " + book.getTitle() + " | Kitap ID: " + book.getBookId());
    }

    // --- Üye (Reader + MemberRecord) Ekleme ---
    public void addReader() {
        System.out.print("Okuyucu adı: ");
        String name = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Üyelik tipi (örn: Student, Faculty): ");
        String memberType = scanner.nextLine();

        System.out.print("Maksimum kitap sayısı: ");
        int maxBookLimit = Integer.parseInt(scanner.nextLine());

        Reader reader = new Reader(generateId(), name, email);
        library.addReader(reader, memberType, maxBookLimit);

        // ✅ Okuyucu ID'si yazdırılıyor
        System.out.println("Okuyucu ve üyelik kaydı oluşturuldu: " + reader.getName() + " | Okuyucu ID: " + reader.getId());
    }

    // --- Kitap Ödünç Verme ---
    public void lendBook() {
        System.out.print("Okuyucu ID: ");
        int readerId = Integer.parseInt(scanner.nextLine());

        System.out.print("Kitap ID: ");
        int bookId = Integer.parseInt(scanner.nextLine());

        library.lendBook(readerId, bookId);
    }

    // --- Kitap İade ---
    public void returnBook() {
        System.out.print("Okuyucu ID: ");
        int readerId = Integer.parseInt(scanner.nextLine());

        System.out.print("Kitap ID: ");
        int bookId = Integer.parseInt(scanner.nextLine());

        library.takeBackBook(readerId, bookId);
    }

    // --- Tüm Kitapları Listele ---
    public void showAllBooks() {
        library.showBooks();
    }

    // --- Okuyucunun Ödünç Aldığı Kitapları Göster ---
    public void showReaderBooks() {
        System.out.print("Okuyucu ID: ");
        int readerId = Integer.parseInt(scanner.nextLine());

        library.showBorrowedBooks(readerId);
    }

    // --- Kitap Türünü Kullanıcıdan Al ---
    private BookType getBookTypeFromUser() {
        BookType[] types = BookType.values();

        System.out.println("Kitap türünü seçin:");
        for (int i = 0; i < types.length; i++) {
            System.out.println((i + 1) + ". " + types[i]);
        }

        int choice = -1;
        while (choice < 1 || choice > types.length) {
            System.out.print("Seçiminiz (1-" + types.length + "): ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // boş satırı temizle
            } else {
                scanner.next(); // geçersiz input'u at
            }
        }

        return types[choice - 1];
    }

    // --- Geçici ID üretici ---
    private int generateId() {
        return (int) (Math.random() * 10000);
    }
}
