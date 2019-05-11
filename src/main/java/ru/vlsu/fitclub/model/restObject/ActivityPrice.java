package ru.vlsu.fitclub.model.restObject;


public class ActivityPrice {
    private int priceForYear;
    private int priceForMonth;
    private int priceForWeek;
    private int priceForTrain;

    public ActivityPrice(int priceForYear, int priceForMonth, int priceForWeek, int priceForTrain) {
        this.priceForYear = priceForYear;
        this.priceForMonth = priceForMonth;
        this.priceForWeek = priceForWeek;
        this.priceForTrain = priceForTrain;
    }

    public int getPriceForYear() {
        return priceForYear;
    }

    public void setPriceForYear(int priceForYear) {
        this.priceForYear = priceForYear;
    }

    public int getPriceForMonth() {
        return priceForMonth;
    }

    public void setPriceForMonth(int priceForMonth) {
        this.priceForMonth = priceForMonth;
    }

    public int getPriceForWeek() {
        return priceForWeek;
    }

    public void setPriceForWeek(int priceForWeek) {
        this.priceForWeek = priceForWeek;
    }

    public int getPriceForTrain() {
        return priceForTrain;
    }

    public void setPriceForTrain(int priceForTrain) {
        this.priceForTrain = priceForTrain;
    }


}
