package abstraction;

public class Main {

    // Main metodu
    public static void main(String[] args) {
        // Abstraction örneği ile şekil nesnesi oluşturuluyor
        Shape circle = new Circle(5);

        // Şekil bilgilerini ekrana yazdır
        circle.display();

        // Şeklin alanını hesapla ve ekrana yazdır
        System.out.println("Area: " + circle.calculateArea());
    }
}
