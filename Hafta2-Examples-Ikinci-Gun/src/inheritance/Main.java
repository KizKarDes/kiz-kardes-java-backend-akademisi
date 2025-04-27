package inheritance;

public class Main {

    // Main metodu
    public static void main(String[] args) {
        // Inheritance örneği ile araç nesnesi oluşturuluyor
        Car car = new Car("Fiat", "Egea");

        // Aracın bilgilerini ekrana yazdır
        car.displayInfo();

        // Aracın korna çalmasını sağla
        car.honk();
    }
}
