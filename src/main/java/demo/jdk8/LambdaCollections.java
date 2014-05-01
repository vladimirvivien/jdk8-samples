package demo.jdk8;

import java.util.Arrays;
import java.util.List;

public class LambdaCollections {
    static List<Months> months = Arrays.asList(Months.values());

    private static void printMonthInfo (Months m) {
        System.out.println(m.toString() + "-> (" + m.days + ") days ");
    }

    public static void main (String[] args){
        System.out.println ("---- Months with 31 days ----");
        months
            .stream()
            .filter(m -> m.days > 30)
            .forEach(m -> System.out.println (m.toString()));
        System.out.println ();

        System.out.println ("---- Months starting with 'J' with 31 days ----");
        months
                .stream()
                .filter(m -> m.toString().startsWith("J"))
                .filter(m -> m.days > 30)
                .forEach(m -> System.out.println (m.toString()));
        System.out.println ();

        System.out.println ("---- Print Month Info ----");
        months
                .stream()
                .forEach(LambdaCollections::printMonthInfo);

        int totalDays = months
            .stream()
            .mapToInt(m -> m.days)
            .sum();
        System.out.println ();
        System.out.println ("Total days = " + totalDays);
    }


}
