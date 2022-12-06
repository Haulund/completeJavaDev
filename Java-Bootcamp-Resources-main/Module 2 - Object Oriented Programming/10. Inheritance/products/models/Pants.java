package models;

import java.util.Objects;

/**
 * Pants
 */
public class Pants extends Product implements Discaoutable, Comparable<Pants>{
    private int waist;

    public Pants(int waist, double price, String color, String brand) {
        super(price, color, brand);
        this.waist = waist;
    }

    public Pants(Pants source){
        super(source);
        this.waist = source.waist;
    }

    public int getWaist() {
        return this.waist;
    }

    public void setWaist(int waist) {
        this.waist = waist;
    }

    @Override
    public int compareTo(Pants specifiedObject) {
        // TODO Auto-generated method stub
        return  (int)Math.round(super.getPrice() - super.getPrice());
    }

    @Override
    public void discount() {
        // TODO Auto-generated method stub
        super.setPrice(super.getPrice()/2);
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pants)) {
            return false;
        }
        Pants pants = (Pants) o;
        return 
            waist == pants.waist &&
            super.getPrice() == pants.getPrice() &&
            super.getBrand().equals(pants.getBrand()) &&
            super.getColor().equals(pants.getColor())
        ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(waist, super.getPrice(), super.getColor(), super.getBrand());
    }


    @Override
    public String toString() {
        return "{" +
            " waist='" + getWaist() + "'" +
            " price='" + super.getPrice() + "'" +
            " color='" + super.getColor() + "'" +
            " brand='" + super.getBrand() + "'" +
            "}";
    }

    @Override
    public void fold() {
        System.out.println("Lay on flat sruface");
        System.out.println("fold the shirt sideways");
        System.out.println("bring the sleaves in");
        System.out.println("and fold from the bottom up");
    }
    
}