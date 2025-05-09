package ListSetMapExample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Çalışanların listesi
        List<String> employeeNames = new ArrayList<>();
        employeeNames.add("Alice");
        employeeNames.add("Bob");
        employeeNames.add("Charlie");
        employeeNames.add("Alice"); // Aynı isim birden fazla kez eklenebilir

        // Benzersiz departmanlar kümesi
        Set<String> departments = new HashSet<>();
        departments.add("İnsan Kaynakları");
        departments.add("IT");
        departments.add("Finans");
        departments.add("İnsan Kaynakları"); // Aynı değer eklenmez

        // Çalışan maaşlarının haritası
        Map<String, Integer> employeeSalaries = new HashMap<>();
        employeeSalaries.put("Alice", 70000);
        employeeSalaries.put("Bob", 85000);
        employeeSalaries.put("Charlie", 60000);

        // Çalışanların listesini göster
        System.out.println("Çalışan Listesi:");
        for (String name : employeeNames) {
            System.out.println(name);
        }

        // Benzersiz departmanları göster
        System.out.println("\nBenzersiz Departmanlar Kümesi:");
        for (String department : departments) {
            System.out.println(department);
        }

        // Çalışan maaşlarını göster
        System.out.println("\nÇalışan Maaşları:");
        for (Map.Entry<String, Integer> entry : employeeSalaries.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }
    }
}

