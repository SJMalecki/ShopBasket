package pl.sjmalecki;

import java.util.Collections;
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
            Integer addedToBasket = list.getOrDefault(product, 0);
            list.put(product, addedToBasket + amount);
            return addedToBasket;
        }
        return 0;
    }

    public Map<Product, Integer> getBasketList(){
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\nBackpack Item List" + this.name + " contains: " + list.size()
                + ((list.size() == 1) ? " item" : " items") + "\n");
        double totalCost = 0.0;
        for (Map.Entry<Product, Integer> item : list.entrySet()) {

            sb.append(item.getKey() + " There is: " + item.getValue() + " in backpack\n");
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return sb.toString() + "Total cost " + totalCost;
    }


}
