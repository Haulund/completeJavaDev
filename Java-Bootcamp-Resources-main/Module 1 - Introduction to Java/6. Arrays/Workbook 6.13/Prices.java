public class Prices {
    public static void main(String[] args) {
        // The instructions for this workbook are on Learn the Part (workbook 6.13)
        double[][] values = {
            {12.99, 8.99, 9.99, 10.99, 11.99},
            {0.99, 1.99, 2.49, 1.49, 2.99},
            {8.99, 7.99, 9.49, 9.99, 10.99}
        };


        // Added in 6.13 (revisited)
        for (int i = 0; i < values.length; i++) {
            switch (i) {
                case 0: System.out.print("Baking: ");break;
                case 1: System.out.print("Beverage: ");break;
                case 2: System.out.print("Cereals: ");break;
                default: break;
            }
            for (int j = 0; j < values.length; j++) {
                System.out.print(values[i][j] + " ");
            }
            System.out.print("\n");
        }
        /* System.out.println("Baking: " + values[0][0] + " " + values[0][1] + " " + values[0][2] + " " + values[0][3] + " " + values[0][4]);
        System.out.println("Beverage: " + values[1][0] + " " + values[1][1] + " " + values[1][2] + " " + values[1][3] + " " + values[1][4]);
        System.out.println("Cereals: " + values[2][0] + " " + values[2][1] + " " + values[2][2] + " " + values[2][3] + " " + values[2][4]); */
    }
}
