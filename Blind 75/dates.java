/*
 * Complete the function below.
 */

    final static int DAYS_IN_YEAR = 365;

    final static int[] MONTH_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    static int DaysBetween(int year1, int month1, int day1, int year2, int month2, int day2) throws Exception {        

        verifyDates(year1, month1, day1, year2, month2, day2);
        
        return daysBefore(year2, month2, day2) - daysBefore(year1, month1, day1);
        
    }

    static int daysBefore(int year, int month, int day) throws Exception {
        
        int daysBefore = DAYS_IN_YEAR * year + day;
        
        for (int i = 0; i < month - 1; i ++) {
            daysBefore += MONTH_DAYS[i];
        }
        
        daysBefore += leapYearsBefore(year, month);
        
        return daysBefore;
        
    }

    static int leapYearsBefore(int year, int month) {
        
        if (month <= 2) {
            year --;
        }
        
        return year / 4 - year / 100 + year / 400;
        
    }

    static void verifyMonth(int month) throws Exception {
        
        if (month < 1 || month > 12) {
            throw new Exception("Month " + month + " is not a valid month. Months must be between 1 and 12, inclusive.");
        }
        
    }

    static void verifyDay(int day, int month, int year) throws Exception {
        
        if (day < 1 || day > DaysInMonth(month, year)) {
            throw new Exception(day + " is not a valid day for month " + month + " of year " + year);
        }
        
    }

    static void verifyDates(int year1, int month1, int day1, int year2, int month2, int day2) throws Exception {
        
        verifyMonth(month1);
        verifyMonth(month2);
        
        verifyDay(day1, month1, year1);
        verifyDay(day2, month2, year2);    
        
        // The problem does not specify whether years in the future are allowed, or if negative years (BC?) are allowed.
        // However, after testing the DaysInMonth function, these two cases do not throw exceptions, so I assume that these
        // two cases are allowed. 
    }

    // Do not edit below this line. It is only shown so you can see the function signature.
    // The implementation of the function is hidden.

    static int DaysInMonth(int month, int year) throws Exception {
    }