package assignments.ObjectOrientedPrograms;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
public class StockAccount implements InterfaceStock{
    static List<CompanyShare> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    public static double balance;
    public static double valueOf() {
        System.out.println(" Current Balance is : " + getBalance());
        return getBalance();
    }
    public CompanyShare findStock(String symbol) {
        for (CompanyShare temp : list) {
            if (temp.getSymbol().equalsIgnoreCase(symbol)) {
                return temp;
            }
        }
        return null;
    }
    public CompanyShare createStockData(String symbol) {
        System.out.println("Enter no of shares");
        int numOfShares = sc.nextInt();
        System.out.println("Enter price of each share");
        int sharePrice = sc.nextInt();
        int totalvalue=sharePrice*numOfShares;
        System.out.println("Total Value of ecah stock: "+totalvalue);
        CompanyShare obj = new CompanyShare( symbol, numOfShares, new Date());
        list.add(obj);
        return obj;
    }
    public CompanyShare sellStockData(String symbol) {
        int numOfShares = 0;
        System.out.println("Enter price of each share");
        int sharePrice = sc.nextInt();
        int totalvalue=numOfShares*sharePrice;
        System.out.println("total value sell stock: "+totalvalue);
        CompanyShare obj = new CompanyShare(symbol, numOfShares,new Date());
        list.add(obj);
        return obj;
    }
    @Override
    public void buy(int amount, String symbol) {
        if (amount > getBalance()) {
            System.out.println("Insufficient fund");
            return;
        }

        CompanyShare stock = findStock(symbol);

        if (stock == null) {
            stock = createStockData(symbol);
        }
        int quantity = (amount / stock.getSharePrice());
        if (quantity < stock.getNumOfShares()) {
            System.out.println("Buying shares on : " +dateGenerator() );
            stock.setNumOfShares(stock.getNumOfShares() - quantity);
            stock.setTotalValue(stock.getSharePrice() * stock.getNumOfShares());
           StockAccount.debit(stock.getNumOfShares(), stock.getSharePrice());
        } else {
            System.out.println("Insufficient");
        }

    }
    public static void credit() {
        double Amount = getBalance() + valueOf();
        setBalance(Amount);
        System.out.println("Amount Credited Successfully");
        viewBalance();
    }

    private static void viewBalance() {
        System.out.println("\nCurrent Balance is : " + balance);

    }

    public static double getBalance() {
        return balance;
    }
    public static void setBalance(double currentBalance) {
        balance = currentBalance;
    }

    public static int debit(int numOfShares, int SharePrice ){
        return numOfShares *SharePrice;
    }

    @Override
    public void sell(int amount, String symbol) {
        CompanyShare stock = findStock(symbol);

        if (stock == null) {
            stock = sellStockData(symbol);
        }

        System.out.println("Selling shares on : " + dateGenerator());
        stock.setTotalValue(stock.getSharePrice() * stock.getNumOfShares());
        StockAccount.credit();

    }
    public String dateGenerator() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return formatter.format(date);
    }

    public static void main(String[] args) {
        StockAccount stockAccount = new StockAccount();
        stockAccount.createStockData("tcs");
        stockAccount.findStock("tcs");
        stockAccount.buy(20000, "tcs");
        stockAccount.sell(40000,"tcs");


    }
}
