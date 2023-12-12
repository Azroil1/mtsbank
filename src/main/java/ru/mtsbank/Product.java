package ru.mtsbank;

public class Product {
    /**
     * Класс который создает товары
     * Создан для первого ДЗ
     * */
    //Кол-во товара
    private int countProduct;
    //Сумма товара
    private double costProduct;
    //Скидка на товар
    private double discount;

    public Product(){

    }

    public Product(int countProduct, double costProduct, double discount) {
        this.countProduct = countProduct;
        this.costProduct = costProduct;
        this.discount = discount;
    }

    public static void costCalculation(Product product){
        System.out.printf("Сумма товара без скидки: %.2f\n", product.costProduct*product.countProduct);
        System.out.printf("Сумма товара со скидкой: %.2f\n",product.discount/100*product.costProduct*product.countProduct);
    }

    public int getCountProduct() {
        return countProduct;
    }

    public void setCountProduct(int countProduct) {
        this.countProduct = countProduct;
    }

    public double getCostProduct() {
        return costProduct;
    }

    public void setCostProduct(double costProduct) {
        this.costProduct = costProduct;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
