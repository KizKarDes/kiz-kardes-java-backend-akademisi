package ListInterfaceExample;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> studentNames = new ArrayList<>();
        studentNames.add("Deniz Gungor");
        studentNames.add("Ahmet Yilmaz");
        studentNames.add("Ayşe Demir");
        studentNames.add("Ayşe Demir");
        studentNames.add("Ayşe Demir");
        studentNames.add("Ayşe Demir");

        System.out.println("Öğrenci Listesi:");
        for (String name : studentNames) {
            System.out.println(name);
        }

        // Bir elemana indeks ile erişim
        String firstStudent = studentNames.getFirst();
        System.out.println("İlk öğrenci: " + firstStudent);
    }
}


