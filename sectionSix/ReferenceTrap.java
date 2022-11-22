import java.util.Arrays;

public class ReferenceTrap {
    public static void main(String[] args) {
        String[] staffLastYear = {"Tommy", "Joel", "Ellie"};

        // --- Best practise ---
        // of copying an Array
        String[] staffThisYear = Arrays.copyOf(staffLastYear, staffLastYear.length);
        
        //manual copy
        //String[] staffThisYear = new String[3];
        /* for (int i = 0; i < staffThisYear.length; i++) {
            staffThisYear[i] = staffLastYear[i];
        } */


        
        //The reference trap
        //String[] staffThisYear = staffLastYear;
        //
        //This can potencially make you update values in the wrong Array, as there are only one array,
        //but several references to it!!!!


        staffThisYear[1] = "Abby";


        System.out.println(Arrays.toString(staffLastYear));
        System.out.println(Arrays.toString(staffThisYear));

    }
}
