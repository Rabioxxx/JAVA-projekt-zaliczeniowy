package com.szymonjasinski;

public class Calendar {
    private Integer day = 1;
    private Integer month = 12;
    private Integer year = 2021;

    public void nextDay() {
        if (this.month == 2) {
            // February
            if (this.day == 28) {
                this.month += 1;
                this.day = 1;
            } else {
                this.day += 1;
            }

        } else if (this.month <= 7 && this.month % 2 == 1) {
            // odd months January - July
            if (this.day == 31) {
                this.month += 1;
                this.day = 1;
            } else {
                this.day += 1;
            }

        } else if (this.month >= 8 && this.month % 2 == 0) {
            // even months August - December
            if (this.day == 31 && this.month == 12) {
                this.year += 1;
                this.month = 1;
                this.day = 1;
            } else if (this.day == 31) {
                this.month += 1;
                this.day = 1;
            } else {
                this.day += 1;
            }

        } else if (this.month <= 7) {
            // even months January - July
            if (this.day == 30) {
                this.month += 1;
                this.day = 1;
            } else {
                this.day += 1;
            }
        } else if (this.month <= 12) {
            // odd months September and November.
            if (this.day == 30) {
                this.month += 1;
                this.day = 1;
            } else {
                this.day += 1;
            }
        } else {
            System.out.println("ERROR/. Something went wrong with this calendar...");
        }
    }

    public Integer getDay() {
        return day;
    }

    public Integer getMonth() {
        return month;
    }

    public Integer getYear() {
        return year;
    }

    public String getDate() {
        return getDay() + "." + getMonth() + "." + getYear();
    }
}