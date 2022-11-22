public class Parameters {
    public static void main(String[] args) {
        calculateArea(2.3, 3.6);
        calculateArea(1.6, 2.4);
        calculateArea(2.6, 4.2);
    }

    public static void calculateArea(double length, double width) {
        System.out.println("Area: " + (length * width));
    }
}
