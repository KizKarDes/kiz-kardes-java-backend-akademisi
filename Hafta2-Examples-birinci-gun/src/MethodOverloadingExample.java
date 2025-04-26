class Calculator {

    // İki sayı toplama metodu
    int add(int a, int b) {
        return a + b;
    }

    // Üç sayı toplama metodu
    int add(int a, int b, int c) {
        return a + b + c;
    }

    // İki ondalıklı sayı toplama metodu
    double add(double a, double b) {
        return a + b;
    }
}

public class MethodOverloadingExample {
    public static void main(String[] args) {
        // Calculator class'ından bir object oluşturma
        Calculator calculator = new Calculator();

        // Farklı add metodlarını çağırma
        System.out.println("Sum of 10 and 20: " + calculator.add(10, 20));
        System.out.println("Sum of 10, 20, and 30: " + calculator.add(10, 20, 30));
        System.out.println("Sum of 10.5 and 20.5: " + calculator.add(10.5, 20.5));
    }
}


