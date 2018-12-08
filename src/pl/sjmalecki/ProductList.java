package pl.sjmalecki;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ProductList {

    private final Map<String, Product> list;

    public ProductList(){
        this.list = new HashMap<>();
    }

    public int addProduct(Product product){
        if(product != null){
            Product productInStore = list.getOrDefault(product.getName(), product);

            if(productInStore != product){
                product.adjustAmount(productInStore.getAmount());
            }

            list.put(product.getName(), product);
            return product.getAmount();
        }
        return 0;
    }

    public int sellProduct(String product, int amount){
        Product productInStore = list.getOrDefault(product, null);
        if((productInStore != null) && (productInStore.getAmount() >= amount) && (amount > 0)){
            productInStore.adjustAmount(-amount);
            return amount;
        }

        if(productInStore.getAmount() < amount){
            System.out.println(productInStore.getName() + " - available: "
                    + productInStore.getAmount() + " can't sell " + amount);
        }
        return 0;
    }

    public int sellProduct(Basket basket, String item, int amount){
        Product listProduct = list.get(item);
        if(listProduct == null){
            System.out.println("We don't sell " + item);
            return 0;
        }

        if(sellProduct(item, amount) != 0){
            basket.addToBasket(listProduct, amount);
            return amount;
        }
        return 0;
    }

    public Product get(String key){
        return list.get(key);
    }

    public Map<String, Double> priceList(){
        Map<String, Double> prices = new LinkedHashMap<>();
        for(Map.Entry<String, Product> product : list.entrySet()){
            prices.put(product.getKey(), product.getValue().getPrice());
        }
        return Collections.unmodifiableMap(prices);
    }

    public Map<String, Product> products(){
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        for(Map.Entry<String, Product> article : list.entrySet()){
            Product product = article.getValue();

            double productValue = product.getPrice() * product.getAmount();

            s = s + product + ". There are " + product.getAmount() + " in stock. Value of items: ";
            s = s + String.format("%.2f", productValue) + "\n";
            totalCost += productValue;
        }

        return s + "Total vlaue " + String.format("%.2f", totalCost);
    }
}
