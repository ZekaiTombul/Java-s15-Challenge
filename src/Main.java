

import model.Library;
import service.LibraryService;
import service.ReaderService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        LibraryService libraryService = new LibraryService(library, scanner);
        ReaderService readerService = new ReaderService(library, scanner);

        boolean running = true;

        while (running) {
            System.out.println("\n--- KÜTÜPHANE OTOMASYON SİSTEMİ ---");
            System.out.println("1. Kitap Ekle");
            System.out.println("2. Okuyucu Ekle");
            System.out.println("3. Kitap Ödünç Ver");
            System.out.println("4. Kitap İade Et");
            System.out.println("5. Tüm Kitapları Listele");
            System.out.println("6. Okuyucunun Kitaplarını Göster");
            System.out.println("7. Okuyucu Bilgilerini Göster");
            System.out.println("0. Çıkış");
            System.out.print("Seçiminiz: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    libraryService.addBook();
                    break;
                case "2":
                    libraryService.addReader();
                    break;
                case "3":
                    libraryService.lendBook();
                    break;
                case "4":
                    libraryService.returnBook();
                    break;
                case "5":
                    libraryService.showAllBooks();
                    break;
                case "6":
                    readerService.showBorrowedBooks();
                    break;
                case "7":
                    readerService.showReaderInfo();
                    break;
                case "0":
                    System.out.println("Sistemden çıkılıyor...");
                    running = false;
                    break;
                default:
                    System.out.println("Geçersiz seçim! Lütfen tekrar deneyin.");
            }
        }

        scanner.close();
    }
}
