import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NotePad {
    private static final String FILE_NAME = "notes.txt"; // Notların saklanacağı dosya adı.

    public static void main(String[] args) {
        NotePad notePad = new NotePad();
        notePad.run(); // Not Defteri uygulaması çalıştırılıyor.
    }

    // Not Defteri uygulamasını çalıştıran ana metod.
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Kullanıcıya menü seçenekleri sunuluyor.
            System.out.println("\n--- Not Defteri Uygulaması ---");
            System.out.println("1. Notları Listele");
            System.out.println("2. Yeni Not Ekle");
            System.out.println("3. Notu Sil");
            System.out.println("4. Tüm Notları Temizle");
            System.out.println("5. Çıkış");
            System.out.print("Seçiminizi Yapın: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Yeni satır karakterini temizlemek için kullanılır.

            switch (choice) {
                case 1:
                    listNotes(); // Mevcut notları listeleme işlemi.
                    break;
                case 2:
                    System.out.print("Yeni notunuzu girin: ");
                    String note = scanner.nextLine();
                    addNote(note); // Yeni not ekleme işlemi.
                    break;
                case 3:
                    System.out.print("Silmek istediğiniz notun numarasını girin: ");
                    int noteIndex = scanner.nextInt();
                    scanner.nextLine(); // Yeni satır karakterini temizlemek için kullanılır.
                    deleteNote(noteIndex); // Belirli bir notu silme işlemi.
                    break;
                case 4:
                    clearAllNotes(); // Tüm notları temizleme işlemi.
                    break;
                case 5:
                    System.out.println("Çıkış yapılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz seçim! Lütfen tekrar deneyin.");
            }
        } while (choice != 5);
        scanner.close();
    }

    // Dosyadaki mevcut notları okuma ve listeleme metodu.
    private void listNotes() {
        List<String> notes = readNotesFromFile();
        if (notes.isEmpty()) {
            System.out.println("Henüz kaydedilmiş bir not yok.");
        } else {
            System.out.println("\n--- Mevcut Notlar ---");
            for (int i = 0; i < notes.size(); i++) {
                System.out.println((i + 1) + ". " + notes.get(i));
            }
        }
    }

    // Dosyaya yeni not ekleme metodu.
    private void addNote(String note) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(note); // Dosyaya yeni not yazılıyor.
            writer.newLine(); // Satır atlanıyor.
            System.out.println("Not başarıyla eklendi.");
        } catch (IOException e) {
            System.out.println("Not eklenirken bir hata oluştu.");
            e.printStackTrace();
        }
    }

    // Belirli bir notu silme metodu.
    private void deleteNote(int noteIndex) {
        List<String> notes = readNotesFromFile();
        if (noteIndex <= 0 || noteIndex > notes.size()) {
            System.out.println("Geçersiz not numarası.");
            return;
        }

        notes.remove(noteIndex - 1); // Belirtilen index'teki not siliniyor.
        writeNotesToFile(notes); // Güncellenmiş notlar dosyaya yazılıyor.
        System.out.println("Not başarıyla silindi.");
    }

    // Tüm notları temizleme metodu.
    private void clearAllNotes() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write(""); // Dosyanın içeriği temizleniyor.
            System.out.println("Tüm notlar başarıyla temizlendi.");
        } catch (IOException e) {
            System.out.println("Notlar temizlenirken bir hata oluştu.");
            e.printStackTrace();
        }
    }

    // Dosyadaki notları okuyan ve bir liste olarak dönen metot.
    private List<String> readNotesFromFile() {
        List<String> notes = new ArrayList<>();
        File file = new File(FILE_NAME);

        // Dosya yoksa, not listesi boş döner.
        if (!file.exists()) {
            System.out.println("Not dosyası bulunamadı. Yeni dosya oluşturulacak.");
            return notes;
        }

        // Dosya var ise, notlar okunuyor.
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                notes.add(line); // Okunan satır not listesine ekleniyor.
            }
        } catch (IOException e) {
            System.out.println("Notlar okunurken bir hata oluştu.");
            e.printStackTrace();
        }

        return notes;
    }

    // Not listesini dosyaya yazan metot.
    private void writeNotesToFile(List<String> notes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String note : notes) {
                writer.write(note); // Liste içindeki her not dosyaya yazılıyor.
                writer.newLine(); // Satır atlanıyor.
            }
        } catch (IOException e) {
            System.out.println("Notlar dosyaya yazılırken bir hata oluştu.");
            e.printStackTrace();
        }
    }
}
