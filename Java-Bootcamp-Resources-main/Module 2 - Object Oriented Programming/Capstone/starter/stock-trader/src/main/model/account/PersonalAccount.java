package src.main.model.account;

import java.util.HashMap;

public class PersonalAccount extends Account{
    private static final double FEE = 0.01;

    public PersonalAccount(double funds, HashMap<String, Integer> portfolio) {
        super(funds,portfolio);
    }

    

   // public String toString() {
     //   return "\n  Stock\t\t"  + Color.RESET + "Shares" +
       //         "\n\n" + displayPortofolio() + Color.RESET +
         //       "\n  Funds Left\t" + Color.GREEN + "$" + round(this.getFunds()) + Color.RESET;
    //}
}
