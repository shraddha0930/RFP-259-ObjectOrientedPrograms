package assignments.ObjectOrientedPrograms;

import java.util.ArrayList;
import java.util.Scanner;

public class StockManagement {

    ArrayList<Stock> list = new ArrayList<>();


    public static void main(String[] args) {

        StockManagement report = new StockManagement();    //	class object
        report.getStockData();
        report.printReport();
    }


    // gets user input of stock data

    public void getStockData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of stocks: ");
        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            System.out.print("Enter stock name, number of shares and share price: ");
            String name = scanner.next();
            int numberOfShares = scanner.nextInt();
            int price = scanner.nextInt();
            Stock stockManagement = new Stock(name,numberOfShares,price);
            list.add(stockManagement);

        }
    }
    public int getValue(int stockNumber , int stockPrice ) {
        return stockNumber *stockPrice;
    }


    // prints report

    public void printReport() {
        int totalValue = 0;
        System.out.println("Name  Shares  Price  Value");
        for (Stock stock: list){
            totalValue += getValue(stock.stockNumber,stock.stockPrice);

            System.out.println(stock.getStockName() + " " + stock.getStockNumber()
                    + " " + stock.getStockPrice() + "  " +getValue(stock.stockNumber,stock.stockPrice));
        }
        System.out.println("Total value is: " + totalValue);
    }


}



