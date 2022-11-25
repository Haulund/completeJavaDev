public class Pyramid {

    public static void main(String[] args) {
        int rows = 5;
        for (int i = 0; i < rows; i++) {
            for (int j = 1; j <= rows; j++) {
                    String output = j == rows-i ? "* " : "  ";
                    System.out.print(output);
                }
            
            System.out.print("\n");
        }
    }
}
