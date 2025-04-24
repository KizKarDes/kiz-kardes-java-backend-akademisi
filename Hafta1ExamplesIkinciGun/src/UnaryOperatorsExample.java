public class UnaryOperatorsExample {
    public static void main(String[] args) {
        int number = 5;

        number++; // Pre-increment
        System.out.println("After increment: " + number);

        number--; // Post-decrement
        System.out.println("After decrement: " + number);

        int positive = +number;
        System.out.println("Positive: " + positive);

        int negative = -number;
        System.out.println("Negative: " + negative);
    }
}
