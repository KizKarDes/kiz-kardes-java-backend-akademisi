// Özel exception sınıfları
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class NegativeAmountException extends Exception {
    public NegativeAmountException(String message) {
        super(message);
    }
}

// Banka hesap sınıfı
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Para çekme metodu
    public void withdraw(double amount) throws InsufficientBalanceException, NegativeAmountException {
        if (amount < 0) {
            throw new NegativeAmountException("Çekilecek miktar negatif olamaz.");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Hata: Hesap bakiyesi yetersiz.");
        }
        balance -= amount;
        System.out.println("Başarıyla " + amount + " TL çekildi. Kalan bakiye: " + balance + " TL.");
    }
}

public class BankAccountExample {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000); // Başlangıç bakiyesi 1000 TL

        try {
            account.withdraw(500); // Geçerli işlem
            account.withdraw(600); // Bakiye yetersiz hatası
        } catch (InsufficientBalanceException | NegativeAmountException e) {
            // Birden fazla custom exception burada handle ediliyor
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Para çekme işlemi tamamlandı.");
        }
    }
}
