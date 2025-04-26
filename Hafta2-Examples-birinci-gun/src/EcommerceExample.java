import java.util.ArrayList;
import java.util.List;

class Product{
    String name;
    double price;


    //Constructor
    Product(String name, double price){
        this.name = name;
        this.price = price;
    }

    //Ürün bilgilerini gösteren method
    void displayProductInfo(){
        System.out.println("Product Name:" + name);
        System.out.println("Price:" + price);
    }
}

class ShoppingCart{
    List<Product> products;

    ShoppingCart() {
        products = new ArrayList<>();
    }

    //Sepete ürün ekleme methodu
    void displayCartContents(){
        System.out.println("Shopping Cart:");
        for (Product product: products){
            product.displayProductInfo();
        }
    }

    //Sepetteki ürünlerin toplam fiyatını hesaplayan method
    double calculateTotal(){
        double total = 0;
        for(Product product : products){
            total += product.price;
        }
        return total;
    }

    void addProduct(Product product){
        products.add(product);
        System.out.println(product.name + " ürün sepete eklendi.");

    }

}

class Customer {
    String name;
    ShoppingCart cart;

    Customer(String name){
        this.name = name;
        this.cart = new ShoppingCart();

    }
    void displayCustomerInfo(){
        System.out.println("Customer Name: " + name);
        cart.displayCartContents();
        System.out.println("Total  Price: " + cart.calculateTotal());
    }
}

public class EcommerceExample {
    public static void main(String[] args) {
        //Ürün oluşturalım
        Product product1 = new Product("Laptop", 999.99);
        Product product2 = new Product("Smartphone", 499.99);
        Product product3 = new Product("Headphones",89.99);

        //Müşteri Olşturalım
        Customer customer1 = new Customer("Hatice");

        //Ürünlerimizi sepete ekleyelim
        customer1.cart.addProduct(product1);
        customer1.cart.addProduct(product2);
        customer1.cart.addProduct(product3);

        //Müşteri ve sepet bilgisi göster
        customer1.displayCustomerInfo();
    }

}
