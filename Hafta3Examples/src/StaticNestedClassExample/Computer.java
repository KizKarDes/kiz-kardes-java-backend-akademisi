package StaticNestedClassExample;

public class Computer {
    private static String brand = "TechBrand";

    // Statik iç sınıf
    static class Processor {
        private String model;
        private double speed;

        Processor(String model, double speed) {
            this.model = model;
            this.speed = speed;
        }

        void displayDetails() {
            System.out.println("Processor Model: " + model);
            System.out.println("Processor Speed: " + speed + " GHz");
            System.out.println("Computer Brand: " + brand);
        }
    }
}
