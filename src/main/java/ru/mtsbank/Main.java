package ru.mtsbank;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product();
        product1.setCostProduct(12);
        product1.setCountProduct(25);
        product1.setDiscount(0.75);
        Product.calculatingTheAmountOfTheProduct(product1);

        Product product2 = new Product(100, 99.9, 42.575);
        Product.calculatingTheAmountOfTheProduct(product2);

        Product product3 = new Product(10,64.3, 59.1);
        Product.calculatingTheAmountOfTheProduct(product3);

    }
}
