package InnerClassExample;

class Car {
    private String make;
    private String model;

    Car(String make, String model) {
        this.make = make;
        this.model = model;
    }
    // İç sınıf
    class Engine {
        private String type;

        Engine(String type) {
            this.type = type;
        }

        void displayDetails() {
            System.out.println("Car Make: " + make);
            System.out.println("Car Model: " + model);
            System.out.println("Engine Type: " + type);
        }
    }
}


