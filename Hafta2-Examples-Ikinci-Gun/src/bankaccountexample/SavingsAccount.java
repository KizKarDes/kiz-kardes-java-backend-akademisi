package bankaccountexample;

// Inheritance kullanarak subclass oluşturma
class SavingsAccount extends BankAccount {
    private double interestRate;

    // Constructor
    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance); // Super class constructor'ı çağırılır
        this.interestRate = interestRate;
    }

    // Faiz oranı ekleyerek para yatırma işlemi, Polymorphism
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            double newBalance = getBalance() + amount + (amount * interestRate / 100);
            // Encapsulation kullanılarak balance güncellenir
            withdraw(-newBalance); // withdraw metoduyla dolaylı olarak balance güncellenir
            System.out.println(amount + " deposited with interest. New balance: " + getBalance());
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
}
