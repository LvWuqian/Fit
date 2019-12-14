package org.csu.fit.domain;

public class DailyFood {

    private String date;
    private String[] breakfast;
    private String[] lunch;
    private String[] dinner;
    private String[] others;
    private double breakfastCa;
    private double lunchCa;
    private double dinnerCa;
    private double othersCa;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String[] getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String[] breakfast) {
        this.breakfast = breakfast;
    }

    public String[] getLunch() {
        return lunch;
    }

    public void setLunch(String[] lunch) {
        this.lunch = lunch;
    }

    public String[] getDinner() {
        return dinner;
    }

    public void setDinner(String[] dinner) {
        this.dinner = dinner;
    }

    public String[] getOthers() {
        return others;
    }

    public void setOthers(String[] others) {
        this.others = others;
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
