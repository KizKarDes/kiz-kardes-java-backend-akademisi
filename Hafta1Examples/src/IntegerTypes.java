public class IntegerTypes {
    public static void main(String[] args) {
        byte age = 25;          // 8 bit, -128 ile 127 arasında değer alır
        short shortNumber = 150;   // 16 bit, -32,768 ile 32,767 arasında değer alır
        int wage = 50000;       // 32 bit, -2^31 ile 2^31-1 arasında değer alır
        long population = 7800000000L; // 64 bit, L harfi ile long tipi belirtilir

        System.out.println("Yaş: " + age);
        System.out.println("Kısa Sayı: " + shortNumber);
        System.out.println("Maaş: " + wage);
        System.out.println("Nüfus: " + population);
    }
}
