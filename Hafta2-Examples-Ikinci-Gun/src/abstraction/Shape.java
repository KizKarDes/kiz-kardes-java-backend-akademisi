package abstraction;

// Abstract class
abstract class Shape {
    // Soyut metod (gövdesiz)
    abstract double calculateArea();

    // Genel bir metod (gövdesi var)
    public void display() {
        // Şekil bilgilerini ekrana yazdırır
        System.out.println("This is a shape");
    }
}
