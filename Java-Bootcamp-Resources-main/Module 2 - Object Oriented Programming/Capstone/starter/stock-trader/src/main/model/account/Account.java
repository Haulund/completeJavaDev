package src.main.model.account;

import java.util.HashMap;

public abstract class Account {
    private double funds;
    private HashMap<String, Integer> portfolio;

    public Account(double funds, HashMap<String, Integer> portfolio) {
        this.funds = funds;
        this.portfolio = portfolio;
    }

    public static int stockIncreaseAfterPurchase(int currentStocks, int boughtStocks) {
        return currentStocks += boughtStocks;
    }

    public static boolean enoughFunds(double funds, double stockPrice) {
        return funds > stockPrice;
    }

    public static double fundsDecreaseAfterPurchase(double funds, double stockPrice, double fee) {
        return (funds - stockPrice)*1-fee;
    }

    public static int stockDecreaseAfterPurchase(int numberOfCurrentStocks, int numberOfBoughtStocks) {
        return numberOfCurrentStocks -= numberOfBoughtStocks;
    }

    public static boolean notEnoughShares(int numberOfCurrentStocks, int numberOfBoughtStocks) {
        return numberOfBoughtStocks > numberOfCurrentStocks;
    }

    public static double fundsIncreaseAfterPurchase(double currentFunds, double incomingFunds, double fee ) {
        return (currentFunds += incomingFunds)*1-fee;
    }
}
