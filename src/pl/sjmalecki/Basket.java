package pl.sjmalecki;

import java.util.Map;
import java.util.TreeMap;

public class Basket {

    private final String name;
    private final Map<Product, Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new TreeMap<>();
    }

    public int addToBasket(Product product, int amount) {
        if ((product != null) || (amount > 0)) {
            int addedToBasket = list.getOrDefault(product, null);
            list.put(product, addedToBasket + amount);
            return addedToBasket;
        }
        return 0;
    }


}
