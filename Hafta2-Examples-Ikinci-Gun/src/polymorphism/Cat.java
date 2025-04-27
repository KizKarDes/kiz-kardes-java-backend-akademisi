package polymorphism;

// Sub class 2
public class Cat extends Animal {
    @Override
    public void makeSound() {
        // Kediye özgü ses çıkarma
        System.out.println("Cat meows");
    }
}