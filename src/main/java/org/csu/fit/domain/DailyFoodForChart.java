package org.csu.fit.domain;

public class DailyFoodForChart {
    private String year;
    private String month;
    private String day;
    private double breakfastCa;
    private double lunchCa;
    private double dinnerCa;
    private double othersCa;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public double getBreakfastCa() {
        return breakfastCa;
    }

    public void setBreakfastCa(double breakfastCa) {
        this.breakfastCa = breakfastCa;
    }

    public double getLunchCa() {
        return lunchCa;
    }

    public void setLunchCa(double lunchCa) {
        this.lunchCa = lunchCa;
    }

    public double getDinnerCa() {
        return dinnerCa;
    }

    public void setDinnerCa(double dinnerCa) {
        this.dinnerCa = dinnerCa;
    }

    public double getOthersCa() {
        return othersCa;
    }

    public void setOthersCa(double othersCa) {
        this.othersCa = othersCa;
    }
}
