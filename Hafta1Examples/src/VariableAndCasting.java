public class VariableAndCasting {
    public static void main(String[] args) {
        // Değişken tanımlama
        int age = 30;
        double wage = 4500.75;
        char level = 'B';
        boolean married = false;

        // Tip dönüşümü (Widening Conversion - Otomatik)
        double largeWage = age; // int tipi otomatik olarak double'a dönüştürülür

        // Tip dönüşümü (Narrowing Conversion - Cast ile)
        int rollingWage = (int) wage; // double'dan int'e dönüşüm yapılır, ondalık kısım kaybedilir

        System.out.println("Yaş: " + age);
        System.out.println("Maaş: " + wage);
        System.out.println("Geniş Maaş: " + largeWage);
        System.out.println("Yuvarlanan Maaş: " + rollingWage);
        System.out.println("Seviye: " + level);
        System.out.println("Evli mi?: " + married);
    }
}
