package pl.sjmalecki;

public class Main {

    private static ProductList productList = new ProductList();

    public static void main(String[] args) {

        Product product = new Product("Kasza", 1.23,2);
        productList.addProduct(product);
        product = new Product("Mleko", 2.67,2);
        productList.addProduct(product);

        Basket basket = new Basket("Default Basket");
        productList.sellProduct(basket, "Kasza",1);
        System.out.println(basket);
    }
}
