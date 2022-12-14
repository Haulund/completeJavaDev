package models;

import java.util.Objects;

/**
 * Shirt
 */
public class Shirt extends Product{
    public enum Size {
        SMALL, MEDIUM, LARGE
    }
    private Size size;    

    public Shirt(Size size, double price, String color, String brand) {
        super(price, color, brand);
        this.size = size;
    }

    public Shirt(Shirt source){
        super(source);
        this.size = source.size;
    }


    public Size getSize() {
        return this.size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

   

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Shirt)) {
            return false;
        }
        Shirt shirt = (Shirt) o;
        return 
            this.equals(shirt.size) && 
            super.getPrice() == shirt.getPrice() &&
            super.getColor().equals(shirt.getColor()) &&
            super.getBrand().equals(shirt.getBrand());
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, super.getPrice(), super.getColor(), super.getBrand());
    }

    @Override
    public String toString() {
        return "{" +
            " size='" + getSize() + "'" +
            " price='" + super.getPrice() + "'" +
            " color='" + super.getColor() + "'" +
            " brand='" + super.getBrand() + "'" +
            "}";
    }

    @Override
    public void fold() {
        // TODO Auto-generated method stub
        System.out.println("Lay on flat sruface");
        System.out.println("fold the shirt sideways");
        System.out.println("bring the sleaves in");
        System.out.println("and fold from the bottom up");
    }

}