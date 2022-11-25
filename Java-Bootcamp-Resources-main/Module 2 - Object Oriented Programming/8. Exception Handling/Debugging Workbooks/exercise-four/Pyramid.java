public class Pyramid {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
          for (int j = 0; j < 10; j++) {
            String output = i == j ? " * ":"   ";
            System.out.print(output);
          }
          System.out.println("\n");
        }
    }
}
