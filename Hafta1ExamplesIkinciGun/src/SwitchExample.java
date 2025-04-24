import java.util.Scanner;
public class SwitchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select a fruit:");
        System.out.println("1. Apple");
        System.out.println("2. Banana");
        System.out.println("3. Orange");
        System.out.println("4. Grape");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1":  //Seçenek 1: Kullanıcı 1'i seçtiğinde, program "You selected Apple." mesajını gösterir.
                System.out.println("You selected Apple.");
                break;

            case "2":  //Seçenek 2: Kullanıcı 2'yi seçtiğinde, program "You selected Banana." mesajını gösterir.
                System.out.println("You selected Banana.");
                break;

            case "3":  //Seçenek 3: Kullanıcı 3'ü seçtiğinde, program "You selected Orange." mesajını gösterir.
                System.out.println("You selected Orange.");
                break;

            case "4":  //Seçenek 4: Kullanıcı 4'ü seçtiğinde, program "You selected Grape." mesajını gösterir.
                System.out.println("You selected Grape.");
                break;

            default: //Default Durumu: Kullanıcı geçersiz bir seçenek girdiğinde, "Invalid choice! bla bla" mesajı gösterilir.

                System.out.println("Invalid choice! Please select a number between 1 and 4.");
        }

        scanner.close();





    }
}
