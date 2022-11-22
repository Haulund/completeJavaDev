public class Scope {
    public static void main(String[] args) {
        System.out.println(dogs);
        someFunction();
    }
    
    
    public static void someFunction() {
        System.out.println(dogs);
    }
    static int dogs = 5;
}
