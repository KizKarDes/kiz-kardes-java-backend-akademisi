package bankaccountexample;

class CheckingAccount extends BankAccount {
    private double overdraftLimit;

    // Constructor
    public CheckingAccount(String accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance); // Super class constructor'ı çağırılır
        this.overdraftLimit = overdraftLimit;
    }

    // Overdraft limiti göz önünde bulundurularak para yatırma işlemi, Polymorphism
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            double newBalance = getBalance() + amount;
            withdraw(-newBalance); // Encapsulation kullanılarak balance güncellenir
            System.out.println(amount + " deposited. New balance: " + getBalance());
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Overdraft limitini aşan para çekme işlemi
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= getBalance() + overdraftLimit) {
            withdraw(-amount); // Encapsulation kullanılarak balance güncellenir
            System.out.println(amount + " withdrawn from account " + getAccountNumber() + " with overdraft.");
        } else {
            System.out.println("Overdraft limit exceeded.");
        }
    }
}
