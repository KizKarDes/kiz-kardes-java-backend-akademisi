class Person1 {
    String name;
    int age;
    String nationality;

    // Constructor
    Person1(String name, int age, String nationality) {
        this.name = name;
        this.age = age;
        this.nationality = nationality;
        //displayInfo();
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Nationality: " + nationality);
    }
}

public class ConstructorExample {
    public static void main(String[] args) {
        // Constructor kullanarak bir object oluşturma
        Person1 person1 = new Person1("Alice", 30, "American");

        // Object bilgilerini gösterme
        person1.displayInfo();
    }
}





