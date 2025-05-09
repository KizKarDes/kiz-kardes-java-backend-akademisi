import java.util.Scanner;

// Özel exception sınıfı
class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

public class UserInputValidation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kullanıcı adını giriniz (min 5 karakter): ");
        String username = scanner.nextLine();

        try {
            validateUsername(username);
            System.out.println("Kullanıcı adı geçerli.");
        } catch (InvalidInputException e) {
            // Custom exception handle ediliyor
            System.out.println("Hata: Kullanıcı adı uzunlupu hatalı." + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Giriş doğrulama işlemi tamamlandı.");
        }
    }

    // Kullanıcı adı doğrulama metodu
    public static void validateUsername(String username) throws InvalidInputException {
        if (username.length() < 5) {
            throw new InvalidInputException("Kullanıcı adı en az 5 karakter olmalıdır.");
        }
    }


    public static void validatePassword(String password) throws InvalidInputException {
        if (password.length() < 10) {
            throw new InvalidInputException("Şifre min 10 karakter olmalıdır.");
        }
    }
}

