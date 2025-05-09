import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskManager {
    private static final String FILE_NAME = "tasks.txt"; // Görevlerin saklanacağı dosya adı.

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        manager.run(); // Task Manager çalıştırılıyor.
    }

    // Task Manager'ı çalıştıran ana metod.
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Kullanıcıya menü seçenekleri sunuluyor.
            System.out.println("\n--- Görev Yönetim Sistemi ---");
            System.out.println("1. Görevleri Listele");
            System.out.println("2. Yeni Görev Ekle");
            System.out.println("3. Çıkış");
            System.out.print("Seçiminizi Yapın: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Yeni satır karakterini temizlemek için kullanılır.

            switch (choice) {
                case 1:
                    listTasks(); // Mevcut görevleri listeleme işlemi.
                    break;
                case 2:
                    System.out.print("Yeni görevi girin: ");
                    String task = scanner.nextLine();
                    addTask(task); // Yeni görev ekleme işlemi.
                    break;
                case 3:
                    System.out.println("Çıkış yapılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz seçim! Lütfen tekrar deneyin.");
            }
        } while (choice != 3);
        scanner.close();
    }

    // Dosyadaki mevcut görevleri okuma ve listeleme metodu.
    private void listTasks() {
        List<String> tasks = readTasksFromFile();
        if (tasks.isEmpty()) {
            System.out.println("Görev bulunamadı.");
        } else {
            System.out.println("\n--- Mevcut Görevler ---");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    // Dosyaya yeni görev ekleme metodu.
    private void addTask(String task) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(task); // Dosyaya yeni görev yazılıyor.
            writer.newLine(); // Satır atlanıyor.
            System.out.println("Görev başarıyla eklendi.");
        } catch (IOException e) {
            System.out.println("Görev eklenirken bir hata oluştu.");
            e.printStackTrace();
        }
    }

    // Dosyadaki görevleri okuyan ve bir liste olarak dönen metot.
    private List<String> readTasksFromFile() {
        List<String> tasks = new ArrayList<>();
        File file = new File(FILE_NAME);

        // Dosya yoksa, görev listesi boş döner.
        if (!file.exists()) {
            System.out.println("Görev dosyası bulunamadı. Yeni dosya oluşturulacak.");
            return tasks;
        }

        // Dosya var ise, görevler okunuyor.
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                tasks.add(line); // Okunan satır görev listesine ekleniyor.
            }
        } catch (IOException e) {
            System.out.println("Görevler okunurken bir hata oluştu.");
            e.printStackTrace();
        }

        return tasks;
    }
}
