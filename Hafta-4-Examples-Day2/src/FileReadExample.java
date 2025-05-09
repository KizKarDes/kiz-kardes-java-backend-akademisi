import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReadExample {
    public static void main(String[] args) {
        String filePath = "data.txt"; // Okunacak dosya

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // Dosya bulunamaması veya okuma hatası durumunda burası çalışır
            System.out.println("Hata: Dosya okuma sırasında bir problem oluştu - " + e.getMessage());
        } finally {
            // try-with-resources kullandığımız için dosya otomatik kapanır
            System.out.println("Dosya okuma işlemi tamamlandı.");
        }
    }
}
