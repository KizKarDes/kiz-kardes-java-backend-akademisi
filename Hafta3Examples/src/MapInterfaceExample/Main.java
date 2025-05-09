package MapInterfaceExample;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> productPrices = new HashMap<>();
        productPrices.put("Laptop", 1200);
        productPrices.put("Smartphone", 800);
        productPrices.put("Tablet", 500);

        System.out.println("Ürün Fiyatları:");
        for (Map.Entry<String, Integer> entry : productPrices.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }

        // Anahtarla bir değere erişim
        int laptopPrice = productPrices.get("Laptop");
        System.out.println("Laptop Fiyatı: $" + laptopPrice);
    }
}

