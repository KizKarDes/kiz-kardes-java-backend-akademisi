package polymorphism;

// Sub class 1
public class Bird extends Animal {
    @Override
    public void makeSound() {
        // kuşa özgü ses çıkarma
        System.out.println("Bird sings");
    }
}
