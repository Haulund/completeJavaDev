package src.main.models;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;

public class Cart {
    ArrayList<Item> items;

    public Cart() {
        this.items = new ArrayList<Item>();
    }

    public Item getItem(int index) {
        return new Item(this.items.get(index));
    }

    public void setItem(int index, Item item) {
        this.items.set(index, new Item(item));
    }

    public boolean add(Item item) {
        if(this.items.contains(item)){
            return false;
        }
        return this.items.add(item);
    }

    public boolean contains(Item item) {
        return this.items.contains(item);
    }

    public boolean remove(String itemName) {
        if(this.items.isEmpty()){
            throw new IllegalStateException("Cart is empty");
        }
        return this.items.removeIf(item -> item.getName().equals(itemName));
    }

    public double getSubtotal() {
        return this.items.stream()
            .mapToDouble(item -> item.getPrice())
            .sum();
    }

    public double getTax(double subtotal) {
        DecimalFormat formatter = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.ENGLISH));
        return Double.parseDouble(formatter.format(subtotal * 0.13));
    }

    public double getTotal(double subtotal, double tax) {
        return subtotal + tax;
    }

    public void clear() {
        this.items.clear();
    }

    public String checkout() {
        if(this.items.isEmpty()){
            throw new IllegalStateException("Cart is empty");
        }
        return  "\tRECEIPT\n\n" +
                "\tSubtotal: $" + getSubtotal() + "\n" +
                "\tTax: $" + getTax(getSubtotal()) + "\n" +
                "\tTotal: $" + getTotal(getSubtotal(), getTax(getSubtotal())) + "\n";
    }
    
    public String toString() {
        String temp = "";
        for (int i = 0; i < this.items.size(); i++) {
            temp += this.items.get(i).toString();
            temp += "\n";
        }
        return temp;
    }

}
