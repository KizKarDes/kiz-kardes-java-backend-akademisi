class Person {
    String name;
    int age;
    String nationality;

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Nationality: " + nationality);
    }
}

public class ClassAndObjectExample {
    public static void main(String[] args) {
        // Person class'ından bir object oluşturma
        Person person = new Person();
        person.name = "Alice";
        person.age = 30;
        person.nationality = "American";

        // Object bilgilerini gösterme
        person.displayInfo();
    }
}
