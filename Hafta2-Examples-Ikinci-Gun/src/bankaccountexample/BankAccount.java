package bankaccountexample;

// Abstract class
abstract class BankAccount {
    // Private değişkenler, Encapsulation
    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Getter metodları, Encapsulation
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // Private setter, yalnızca sınıf içinde kullanılabilir, Encapsulation
    private void setBalance(double balance) {
        this.balance = balance;
    }

    // Soyut metod, alt sınıflar tarafından implement edilecek, Abstraction
    abstract void deposit(double amount);

    // Para çekme işlemi, alt sınıflar bu metodu olduğu gibi kullanabilir
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            setBalance(balance - amount); // Encapsulation kullanımı
            System.out.println(amount + " withdrawn from account " + accountNumber);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // Hesap bilgilerini gösterme metodu
    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber + ", Balance: " + balance);
    }
}




