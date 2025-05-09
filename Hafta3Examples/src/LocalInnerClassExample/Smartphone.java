package LocalInnerClassExample;

public class Smartphone {
    private String brand;
    private String model;

    Smartphone(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    void displaySpecifications() {
        //Yerel iç sınıf
        class Specifications {
            private String operatingSystem;
            private int storageCapacity;

            Specifications(String operatingSystem, int storageCapacity) {
                this.operatingSystem = operatingSystem;
                this.storageCapacity = storageCapacity;
            }

            void show() {
                System.out.println("Smartphone Brand: " + brand);
                System.out.println("Smartphone Model: " + model);
                System.out.println("Operating System: " + operatingSystem);
                System.out.println("Storage Capacity: " + storageCapacity + " GB");
            }
        }

        Specifications specs = new Specifications("Android", 128);
        specs.show();
    }
}
