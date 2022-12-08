package src.test;

import org.junit.Test;
import src.main.model.account.Account;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BuyTests {
    
    Account[] accounts;

    @Test
    public void stockIncreaseAfterPurchase () {
        int numberOfCurrentStocks = 0;
        int numberOfBoughtStocks = 5;
        assertEquals(5, Account.stockIncreaseAfterPurchase(numberOfCurrentStocks, numberOfBoughtStocks));
    }

    @Test
    public void enoughFundsTest() {
        double funds = 150;
        double stockPrice = 100;
        assertTrue(Account.enoughFunds(funds, stockPrice));
    }

    @Test
    public void fundsDecreaseAfterPurchaseTest(){
        double funds = 250.4;
        double stockPrice = 100.2;
        double tradeFee = 0.01;
        assertEquals(148.698, funds, Account.fundsDecreaseAfterPurchase(funds, stockPrice, tradeFee));
    }


}
