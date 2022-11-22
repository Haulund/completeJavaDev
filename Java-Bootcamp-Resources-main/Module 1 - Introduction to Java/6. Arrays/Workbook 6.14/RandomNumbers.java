public class RandomNumbers {
    public static void main(String[] args) {
        int[][] array = {
            {48, 56, 56, 76, 0, 81, 51, 81, 99, 70},
            {38, 52, 73, 6, 10, 56, 1, 71, 47, 9},
            {85, 35, 47, 98, 91, 25, 69, 52, 2, 93}
        };
        // The instructions for this workbook are on Learn the Part (Workbook 6.14)
        //print2DArray(array);

        int[][] randomArray = new int[100][10];
        
        for (int i = 0; i <  randomArray.length; i++) {
            for (int j = 0; j < randomArray[i].length; j++) {
                int input = randomNumber();
                randomArray[i][j] = input;
            }
        }

        print2DArray(randomArray);
    }

    public static int randomNumber() {
        double randomNumber = Math.random()*100;
        return (int)randomNumber;
    }

    public static void print2DArray(int[][] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                System.out.print(inputArray[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

}
