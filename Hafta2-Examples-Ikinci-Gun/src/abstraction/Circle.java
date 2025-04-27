package abstraction;

// Concrete class 1
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        // Dairenin alanını hesaplar
        return Math.PI * radius * radius;

    }

}