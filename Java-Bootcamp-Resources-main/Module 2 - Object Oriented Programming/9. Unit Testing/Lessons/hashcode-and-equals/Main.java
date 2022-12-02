import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Car nissan = new Car("nissan", 2016);
        System.out.println("Nissan: " + nissan.hashCode());
        Car dodge = new Car("dodge", 2018);
        System.out.println("Dodge: " + dodge.hashCode());
        Car toyota = new Car("toyota", 2020);
        System.out.println("toyota: " + toyota.hashCode());
        
        Car nissan2 = new Car(nissan);
        System.out.println("nissan2: " + nissan2.hashCode());

        HashMap<Car, Double> prices = new HashMap<Car, Double>();
        prices.put(nissan, 1000.);
        prices.put(dodge, 1200.);
        prices.put(toyota, 1020.);

    }

    
}
