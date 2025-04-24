import java.util.Scanner;

public class KullaniciBilgileri {
    public static void main(String[] args) {
        // Scanner nesnesi oluşturuyoruz
        Scanner scanner = new Scanner(System.in);

        // Kullanıcıdan veri alma
        System.out.print("Adınızı girin: ");
        String name = scanner.nextLine(); // String veri tipi

        System.out.print("Yaşınızı girin: ");
        int age = scanner.nextInt(); // int veri tipi

        System.out.print("Maaşınızı girin: ");
        double wage = scanner.nextDouble(); // double veri tipi

        System.out.print("Ortalama sıcaklığı girin (°C): ");
        float heat = scanner.nextFloat(); // float veri tipi

        System.out.print("Cinsiyetinizi girin (E/K): ");
        char gender = scanner.next().charAt(0); // char veri tipi

        System.out.print("Evli misiniz? (true/false): ");
        boolean evliMi = scanner.nextBoolean(); // boolean veri tipi

        // Verilerin işlenmesi
        double yillikMaas = wage * 12; // Maaşı yıllık olarak hesaplıyoruz
        int yas10YilSonra = age + 10; // 10 yıl sonraki yaşı hesaplıyoruz
        double sicaklikFahrenheit = heat * 9/5 + 32; // Sıcaklığı Fahrenheit'a çeviriyoruz

        // Sonuçların ekrana yazdırılması
        System.out.println("\nKullanıcı Bilgileri:");
        System.out.println("Ad: " + name);
        System.out.println("Yaş: " + age + " (10 yıl sonra: " + yas10YilSonra + ")");
        System.out.println("Maaş: " + wage + " TL (Yıllık: " + yillikMaas + " TL)");
        System.out.println("Ortalama Sıcaklık: " + heat + " °C (Fahrenheit: " + sicaklikFahrenheit + " °F)");
        System.out.println("Cinsiyet: " + gender);
        System.out.println("Evli mi?: " + evliMi);

        // Tip dönüşümü örneği
        long genisYas = age; // int'den long'a otomatik dönüşüm (Widening Conversion)
        int daraltmaMaas = (int) yillikMaas; // double'dan int'e dönüşüm (Narrowing Conversion)

        System.out.println("\nEk Bilgiler:");
        System.out.println("Genişletilmiş Yaş (long): " + genisYas);
        System.out.println("Daraltılmış Yıllık Maaş (int): " + daraltmaMaas);
    }
}
