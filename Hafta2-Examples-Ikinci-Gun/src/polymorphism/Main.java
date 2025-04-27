package polymorphism;

public class Main {

    // Main metodu
    public static void main(String[] args) {
        // Polymorphism örneği ile hayvan nesneleri oluşturuluyor
        Animal myBird = new Bird(); // Polymorphism ile Bird class'ı kullanılır
        Animal myCat = new Cat(); // Polymorphism ile Cat class'ı kullanılır

        // Hayvanların ses çıkarma davranışları
        myBird.makeSound(); // Bird sings
        myCat.makeSound(); // Cat meows
    }
}
