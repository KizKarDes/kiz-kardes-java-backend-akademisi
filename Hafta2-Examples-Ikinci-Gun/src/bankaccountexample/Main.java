package bankaccountexample;

public class Main {

    public static void main(String[] args) {
        // Polymorphism ile farklı hesap türleri oluşturma
        BankAccount savings = new SavingsAccount("SA123", 1000, 5);
        BankAccount checking = new CheckingAccount("CA123", 500, 200);

        // Hesap bilgilerini gösterme
        savings.displayAccountInfo();
        checking.displayAccountInfo();

        // Para yatırma işlemleri
        savings.deposit(200);
        checking.deposit(150);

        // Para çekme işlemleri
        savings.withdraw(100);
        checking.withdraw(600);

        // Güncellenen hesap bilgilerini gösterme
        savings.displayAccountInfo();
        checking.displayAccountInfo();
    }
}
