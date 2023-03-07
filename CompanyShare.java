package assignments.ObjectOrientedPrograms;

import java.util.Date;

public class CompanyShare {

    public String symbol;
   public int numOfShares;
   public Date date;

    public CompanyShare(String symbol, int numOfShares, Date date) {
        this.symbol = symbol;
        this.numOfShares = numOfShares;
        this.date = date;
    }

    public static double getBalance() {
        return getBalance();
    }



    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getNumOfShares() {
        return numOfShares;
    }

    public void setNumOfShares(int numOfShares) {
        this.numOfShares = numOfShares;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "CompanyShare{" +
                "symbol='" + symbol + '\'' +
                ", numOfShares=" + numOfShares +
                ", date=" + date +
                '}';
    }

    public String getStockSymbol() {
        return null;
    }

    public int getSharePrice() {
        return 0;
    }

    public void setTotalValue(int i) {
    }
}
