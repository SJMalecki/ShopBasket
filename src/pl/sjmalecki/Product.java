package pl.sjmalecki;

public class Product implements Comparable<Product>{

    private final String name;
    private double price;
    private int amount;

    public Product(String name,  double price, int amount){
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.amount = 0;
    }

    public void setPrice(double price) {
        if(price > 0.0){
            this.price = price;
        }
    }

    public void adjustAmount(int amount){
        int updatedAmount = this.amount + amount;
        if(updatedAmount >= 0){
            this.amount = updatedAmount;
        }
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public int compareTo(Product o){
        if(this == o){
            return 0;
        }

        if(o != null){
            return this.name.compareTo(o.getName());
        }

        throw new NullPointerException();
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }

        if((obj == null) || (obj.getClass() != this.getClass())){
            return false;
        }

        String objName = ((Product) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode(){
        return this.name.hashCode() + 32;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.name)
                .append(" - price: " + this.price);
        return sb.toString();
    }
}
