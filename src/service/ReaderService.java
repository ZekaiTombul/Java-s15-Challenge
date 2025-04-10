package service;

import model.Library;
import model.MemberRecord;
import model.Reader;

import java.util.Scanner;

public class ReaderService {
    private Library library;
    private Scanner scanner;

    public ReaderService(Library library, Scanner scanner) {
        this.library = library;
        this.scanner = scanner;
    }

    // --- Okuyucunun bilgilerini göster ---
    public void showReaderInfo() {
        System.out.print("Okuyucu ID: ");
        int readerId = Integer.parseInt(scanner.nextLine());

        Reader reader = library.findReaderById(readerId);
        if (reader != null) {
            System.out.println("ID: " + reader.getId());
            System.out.println("Adı: " + reader.getName());
            System.out.println("Email: " + reader.getEmail());
        } else {
            System.out.println("Okuyucu bulunamadı.");
        }
    }

    // --- Okuyucunun ödünç aldığı kitapları listele ---
    public void showBorrowedBooks() {
        System.out.print("Okuyucu ID: ");
        int readerId = Integer.parseInt(scanner.nextLine());

        MemberRecord record = library.findMemberRecordByReaderId(readerId);
        if (record != null) {
            record.showBorrowedBooks();
        } else {
            System.out.println("Üyelik kaydı bulunamadı.");
        }
    }

}
