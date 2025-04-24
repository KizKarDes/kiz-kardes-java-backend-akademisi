import java.util.Scanner;

public class UserInputExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Kullanıcıdan veri almak için Scanner nesnesi oluşturuyoruz

        System.out.print("Adınızı girin: ");
        String name = scanner.nextLine(); // Kullanıcının girdiği metni okur

        System.out.print("Yaşınızı girin: ");
        int age = scanner.nextInt(); // Kullanıcının girdiği tamsayıyı okur

        System.out.print("Maaşınızı girin: ");
        double wage = scanner.nextDouble(); // Kullanıcının girdiği ondalıklı sayıyı okur

        System.out.println("\nKullanıcı Bilgileri:");
        System.out.println("Ad: " + name);
        System.out.println("Yaş: " + age);
        System.out.println("Maaş: " + wage);
    }
}
