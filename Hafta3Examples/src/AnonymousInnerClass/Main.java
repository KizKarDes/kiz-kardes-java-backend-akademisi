package AnonymousInnerClass;

public class Main {
    public static void main(String[] args) {
        // Button arayüzünü uygulayan anonim iç sınıf
        Button submitButton = new Button() {
            @Override
            public void click() {
                System.out.println("Submit button clicked!");
            }
        };

        Button cancelButton = new Button() {
            @Override
            public void click() {
                System.out.println("Cancel button clicked!");
            }
        };

        submitButton.click();
        cancelButton.click();
    }
}
