package encapsulation;

public class Main
{
    // Main metodu
    public static void main(String[] args) {
        // Encapsulation örneği ile çalışan nesnesi oluşturuluyor
        Employee emp = new Employee("Ediz Ali", 30, 50000);

        // Çalışan bilgilerini ekrana yazdır
        emp.displayEmployeeInfo();

        // Çalışan yaşı ve maaşı güncelle
        emp.setAge(32);
        emp.setSalary(55000);

        // Güncellenmiş bilgileri ekrana yazdır
        emp.displayEmployeeInfo();
    }
}
