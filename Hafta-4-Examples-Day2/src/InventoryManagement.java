// Özel exception sınıfı
class OutOfStockException extends Exception {
    public OutOfStockException(String message) {
        super(message);
    }
}

// Ürün sınıfı
class Product {
    private String name;
    private int stock;

    public Product(String name, int stock) {
        this.name = name;
        this.stock = stock;
    }

    // Ürün satın alma metodu
    public void purchase(int quantity) throws OutOfStockException {
        if (quantity > stock) {
            throw new OutOfStockException("Hata: " + name + " için yeterli stok yok.");
        }
        stock -= quantity;
        System.out.println(quantity + " adet " + name + " satın alındı. Kalan stok: " + stock);
    }
}

public class InventoryManagement {
    public static void main(String[] args) {
        Product laptop = new Product("Laptop", 10);

        try {
            laptop.purchase(5); // Geçerli işlem
            laptop.purchase(6); // Stok yetersiz hatası
        } catch (OutOfStockException e) {
            // Stok hatası handle ediliyor
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Satın alma işlemi tamamlandı.");
        }
    }
}
