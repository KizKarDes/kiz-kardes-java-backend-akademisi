import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.TreeSet;


public class SuperheroTeam {

    public static void main(String[] args) {
        SuperheroTeam team = new SuperheroTeam();
        team.createSuperheroTeams();
    }

    public void createSuperheroTeams() {
        // ArrayList kullanarak bir süper kahraman listesi oluşturuyoruz
        ArrayList<String> superheroes = new ArrayList<>();
        superheroes.add("Batman");
        superheroes.add("Superman");
        superheroes.add("Wonder Woman");
        superheroes.add("Flash");
        superheroes.add("Aquaman");

        System.out.println("Süper Kahramanlar: " + superheroes);

        // LinkedList kullanarak bir takım listesi oluşturuyoruz
        LinkedList<String> teamAlpha = new LinkedList<>();
        teamAlpha.add("Batman");
        teamAlpha.add("Wonder Woman");
        teamAlpha.add("Aquaman");

        LinkedList<String> teamBeta = new LinkedList<>();
        teamBeta.add("Superman");
        teamBeta.add("Flash");

        System.out.println("Takım Alpha: " + teamAlpha);
        System.out.println("Takım Beta: " + teamBeta);

        // HashSet kullanarak hangi süper kahramanın hangi yeteneklere sahip olduğunu takip ediyoruz
        HashSet<String> batmanSkills = new HashSet<>(Arrays.asList("Zeka", "Dövüş", "Dedektiflik"));
        HashSet<String> supermanSkills = new HashSet<>(Arrays.asList("Uçuş", "Süper Güç", "X-Işını"));

        System.out.println("Batman'in Yetenekleri: " + batmanSkills);
        System.out.println("Superman'in Yetenekleri: " + supermanSkills);

        // TreeSet kullanarak yetenekleri alfabetik sıraya göre saklıyoruz
        TreeSet<String> wonderWomanSkills = new TreeSet<>(Arrays.asList("Uçuş", "Süper Güç", "Bilezik Savunması"));
        System.out.println("Wonder Woman'in Yetenekleri (Alfabetik): " + wonderWomanSkills);

        // HashMap kullanarak kahramanları ve takımlarını ilişkilendiriyoruz
        HashMap<String, LinkedList<String>> teams = new HashMap<>();
        teams.put("Team Alpha", teamAlpha);
        teams.put("Team Beta", teamBeta);
        System.out.println("Takımlar " + teams);

        // LinkedHashMap kullanarak kahramanların takımlarını eklenme sırasına göre saklıyoruz
        LinkedHashMap<String, String> superheroTeams = new LinkedHashMap<>();
        superheroTeams.put("Batman", "Team Alpha");
        superheroTeams.put("Superman", "Team Beta");
        superheroTeams.put("Wonder Woman", "Team Alpha");
        superheroTeams.put("Flash", "Team Beta");
        superheroTeams.put("Aquaman", "Team Alpha");

        System.out.println("Süper Kahramanlar ve Takımları: " + superheroTeams);

        // Iterator kullanarak takım üyelerini dolaşıyoruz
        Iterator<String> iterator = teamAlpha.iterator();
        System.out.print("Takım Alpha Üyeleri: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
