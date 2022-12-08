package src.test;

import org.junit.Test;
import src.main.model.account.Account;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SellTests {
    
    Account[] accounts;

    @Test
    public void stockDecreaseAfterPurchaseTest () {
        int numberOfCurrentStocks = 8;
        int numberOfBoughtStocks = 3;
        assertEquals(5, Account.stockDecreaseAfterPurchase(numberOfCurrentStocks, numberOfBoughtStocks));
    }

    @Test
    public void notEnoughSharesTest(){
        int numberOfCurrentStocks = 8;
        int numberOfBoughtStocks = 10;
        assertTrue(Account.notEnoughShares(numberOfCurrentStocks,numberOfBoughtStocks));
    }

    @Test
    public void fundsIncreaseAfterSaleTest(){
        double currentFunds = 100.5;
        double incomingFunds = 99.99;
        double fee = 0.05;
        ;
        assertEquals(190.4655, 100.5, Account.fundsIncreaseAfterPurchase(currentFunds, incomingFunds, fee));
    }

}
