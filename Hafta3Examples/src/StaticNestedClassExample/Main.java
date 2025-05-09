package StaticNestedClassExample;

public class Main {
    public static void main(String[] args) {
        Computer.Processor processor = new Computer.Processor("Intel i7", 3.5);
        processor.displayDetails();
    }
}
