package assignments.ObjectOrientedPrograms;


public class Stock {
    public String stockName;
    public int stockPrice;
    public int stockNumber;


    public Stock(String stockName, int stockPrice, int stockNumber) {
        this.stockName = stockName;
        this.stockPrice = stockPrice;
        this.stockNumber = stockNumber;
    }

    public String getStockName(){
        return stockName;
    }

    public int getStockPrice(){
        return stockPrice;
    }

    public int getStockNumber(){
        return stockNumber;
    }


    public String toString(){
        return stockName+" "+stockPrice+" "+stockNumber+"  "+(stockPrice*stockNumber)+" "+"\n";

    }


}
