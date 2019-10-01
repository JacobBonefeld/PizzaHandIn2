package PizzaOrder;

public class Pizza {
    private String name;
    private double price;
    private String size;
    private double toppingTotalPrice;
    private String[] toppingNames;
    private double[] toppingPrices;
    private int numberOfToppings;

    public int getNumberOfToppings() {
        return numberOfToppings;
    }

    public void setNumberOfToppings(int numberOfToppings) {
        this.numberOfToppings = numberOfToppings;
    }

    public double[] getToppingPrices() {
        return toppingPrices;
    }

    public void setToppingPrices(double[] toppingPrices) {
        this.toppingPrices = toppingPrices;
    }

    public double getToppingTotalPrice() {
        return toppingTotalPrice;
    }

    public void setToppingTotalPrice(double toppingTotalPrice) {
        this.toppingTotalPrice = toppingTotalPrice;
    }

    public String[] getToppingNames() {
        return toppingNames;
    }

    public void setToppingNames(String[] toppingNames) {
        this.toppingNames = toppingNames;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
