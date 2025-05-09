package InnerClassExample;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Tesla", "Model S");
        Car.Engine engine = car.new Engine("Electric");
        engine.displayDetails();
    }
}
