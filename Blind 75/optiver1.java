/*
 * Complete the function below.
 */

    final static int DAYS_IN_YEAR = 365;
    final static int MONTHS_IN_YEAR = 12;

    final static int[] DEFAULT_MONTH_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    // Assumptions:
    // 1. Every 4th year is a leap year, starting on year 0 except for years that are divisible by 100 unless
    //      they are also divisible by 400
    // 2. Year 0 is a valid year and is a leap year.
    //      This is based on testing the provided DaysInMonth() function. However, 0 AD is not a valid year 
    //      in the Gregorian calendar, nor the Julian calendar.
    // 3. Negative years indicate B.C, and leap years in B.C follow the same pattern as leap years in A.D. 
    // 4. Historically lost days will not be accounted for.

    static int DaysBetween(int year1, int month1, int day1, int year2, int month2, int day2) throws Exception {        
        
        verifyDate(year1, month1, day1);
        verifyDate(year2, month2, day2);

        return daysBefore(year2, month2, day2) - daysBefore(year1, month1, day1);

    }


    // Given a date, returns its distance in days from 1/1/0000.
    // If the year is negative, this distance is also negative.
    static int daysBefore(int year, int month, int day) throws Exception {
        
        if (year < 0) {
            return daysBeforeNegative(year, month, day);
        }
        
        int daysBefore = DAYS_IN_YEAR * year + day;
        
        for (int i = 0; i < month - 1; i ++) {
            daysBefore += DEFAULT_MONTH_DAYS[i];
        }
        
        daysBefore += leapDaysBefore(year, month);
        
        return daysBefore;
        
    }

    // Returns the number of leap years (and equivalently the number of leap days) before a given date
    // starting from 01/01/0000
    static int leapDaysBefore(int year, int month) throws Exception {
             
        if (year == 0) {
            return month > 2 ? 1 : 0;
        }
        
        // Account for leap day already passing this year
        if (month <= 2) {
            year --;
        }
        
        // Leap years occur every 4 years, with the exception of multiples of 100 unless they are also multiples of 400.
        int leapYearsBefore = year / 4 - year / 100 + year / 400;
        
        // However, based on DaysInMonth(), year 0 is a leap year. 
        leapYearsBefore ++;
        
        return leapYearsBefore;
                
    }
     
    // Returns the number of days from the given date (with negative year) to 01/01/0000
    static int daysBeforeNegative(int year, int month, int day) throws Exception {
        
        int total = 0;
        
        int daysLeftInMonth = DaysInMonth(month, year) - day;
        
        total += daysLeftInMonth;
        
        month ++;
        
        // Increment to end of year
        for (int i = month; i <= MONTHS_IN_YEAR; i ++) {
            total += DaysInMonth(i, year);
        }
        
        year ++;
        
        total += DAYS_IN_YEAR * Math.abs(year);
        
        total += leapYearsBeforeNegative(year);
        
        return -1 * total;    
        
    }
    
    // returns the number of leap years from 1/1 on the given year (negative) to 01/01/0000. 
    static int leapYearsBeforeNegative(int year) throws Exception {
        
        year = Math.abs(year);
        
        return year / 4 - year / 100 + year / 400;
        
    }
    

    // validates month and day
    static void verifyDate(int year, int month, int day) throws Exception {
        
        if (month < 1 || month > MONTHS_IN_YEAR) {
           throw new Exception(month + " is not a valid month. Months must be between 1 and 12, inclusive");
        }
        
        if (day < 1 || day > DaysInMonth(month, year)) {
            throw new Exception(day + " is not a valid day for month " + month + " of year " + year);
        }
        
        // The problem does not specify whether years in the future are allowed, or if negative years (BC?) are allowed.
        // After testing DaysInMonth(), these two cases do not throw exceptions, so I assume that these
        // two cases are valid, and I will accept any integer for the year.
        
        // DaysInMonth() does not throw an exception for year 0, even though 0 is not a valid year in the Gregorian calendar
        // (1 BC is followed by 1 AD).
        // In addition, years 0, -4, -8, etc. are defined as leap years.
    }

    // Do not edit below this line. It is only shown so you can see the function signature.
    // The implementation of the function is hidden.

    static int DaysInMonth(int month, int year) throws Exception {