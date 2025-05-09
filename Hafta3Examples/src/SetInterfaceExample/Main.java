package SetInterfaceExample;


import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> uniqueCountries = new HashSet<>();
        uniqueCountries.add("USA");
        uniqueCountries.add("Canada");
        uniqueCountries.add("Germany");
        uniqueCountries.add("USA"); // Aynı değer eklenmez

        System.out.println("Benzersiz Ülkeler Kümesi:");
        for (String country : uniqueCountries) {
            System.out.println(country);
        }
    }
}

