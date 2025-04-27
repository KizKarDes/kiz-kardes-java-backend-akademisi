package inheritance;

// Base class (Super class)
public class Vehicle {
    protected String brand;

    public Vehicle(String brand) {
        this.brand = brand;
    }

    public void honk() {
        // Aracın korna çalma metodu
        System.out.println("Beep beep!");
    }
}
