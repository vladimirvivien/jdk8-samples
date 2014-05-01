package demo.jdk8;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTime {
    public static void main(String ... args){
        // tell time
        LocalTime now = LocalTime.now();
        System.out.println ("Current time " + now);
        System.out.println ("In two hours it will be " + now.plus(2, ChronoUnit.HOURS) );

        // play with dates
        LocalDate date = LocalDate.now();
        System.out.println ("Today is " + date);
        System.out.println ("In 3 days it will be " + date.plus(3, ChronoUnit.DAYS));
        LocalDate xmas = LocalDate.of(2014, Month.DECEMBER, 25);
        System.out.println ("This year " + xmas.getMonth() + " " + xmas.getDayOfMonth() + " is on " + xmas.getDayOfWeek());

        // Parse
        LocalDate parsed = LocalDate.parse("2014-04-28", DateTimeFormatter.ISO_DATE);
        System.out.println ("Parsed Date = " + parsed);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
        System.out.println ("Parsed Date " + LocalDate.parse("2014-Apr-29", dtf));
    }
}
