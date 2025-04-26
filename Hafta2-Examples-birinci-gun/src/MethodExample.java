class BankAccount {
    String accountHolder;
    double balance;

    // Constructor
    BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    // Para yatırma metodu
    void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " deposited. New balance: " + balance);
    }

    // Para çekme metodu
    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn. New balance: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    // Hesap bilgilerini gösterme metodu
    void displayAccountInfo() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }
}

public class MethodExample {
    public static void main(String[] args) {
        // BankAccount class'ından bir object oluşturma
        BankAccount account1 = new BankAccount("John Doe", 1000.00);

        // Object üzerindeki methodları kullanma
        account1.displayAccountInfo();
        account1.deposit(500.00);
        account1.withdraw(200.00);
        account1.withdraw(1500.00);
    }
}



