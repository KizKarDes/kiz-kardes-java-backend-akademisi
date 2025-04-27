package encapsulation;

public class Employee {
    // Değişkenler private olarak tanımlanır, dışarıdan doğrudan erişim engellenir.
    private String name;
    private int age;
    private double salary;

    // Constructor ile değişkenler başlatılır.
    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // Getter ve Setter metodları ile değişkenlere kontrollü erişim sağlanır.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) { // Yaşın pozitif olması kontrol edilir.
            this.age = age;
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary >= 0) { // Maaşın negatif olmaması kontrol edilir.
            this.salary = salary;
        }
    }

    // Çalışan bilgilerini ekrana yazdıran metod
    public void displayEmployeeInfo() {
        System.out.println("Name: " + name + ", Age: " + age + ", Salary: " + salary);
    }
}
