package inheritance;

// Sub class (Derived class)
public class Car extends Vehicle {
    private String model;

    public Car(String brand, String model) {
        // Super class constructor'ı çağırılır
        super(brand);
        this.model = model;
    }

    public void displayInfo() {
        // Araç bilgileri ekrana yazdırılır
        System.out.println("Brand: " + brand + ", Model: " + model);
    }
}
