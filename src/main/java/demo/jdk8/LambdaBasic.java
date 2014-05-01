package demo.jdk8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaBasic {
    // use built-in generic functional interface from JDK
    static List<Months> search(Predicate<Months> tester){
        ArrayList<Months> months = new ArrayList<>();
        for(Months m : Months.values()){
            if (tester.test(m)){
                months.add(m);
            }
        }
        return months;
    }

    // functional interface
    interface MonthPredicate {
        boolean test(Months m);
    }

    // uses functional interface MothTester to find/filder list.
        static List<Months> find(MonthPredicate tester){
            ArrayList<Months> months = new ArrayList<>();
            for(Months m : Months.values()){
               if (tester.test(m)){
                   months.add(m);
               }
            }
            return months;
        }

    // use built-in type (Consumer) to apply closure actions
    static void doWithMonths(Consumer<Months> action){
        for (Months m : Months.values()){
            action.accept(m);
        }
    }

    // use built-in type (Function<T,R>) get values from closure
    static int collect(Function<Months, Integer> f) {
        Integer total = 0;
        for (Months m : Months.values()){
            total += f.apply(m);
        }
        return total;
    }
    public static void main(String[] args){
        System.out.println ("---- Months with 31 days ----");
        for (Months month : search ((m) -> {return m.days > 30;})){
            System.out.println (month);
        }
        System.out.println ();

        MonthPredicate mMonths = m -> m.toString().startsWith("M");
        System.out.println ("---- Months starting with M ----");
        for (Months month : find(mMonths)){
            System.out.println (month);
        }
        System.out.println ();

        System.out.println ("---- Months Info ----");
        doWithMonths(
                m -> {
                    System.out.println(m.toString() + " has " + m.days + " days ");
                }
        );
        System.out.println();

        // NOTE: lambdas can be expressed as the functional interface they implement as below.
        // the same could be expressed as totalDays = collect(m->m.days);
        int totalDays = collect(new Function<Months, Integer>() {
            @Override
            public Integer apply(Months month) {
                return month.days;
            }
        });
        System.out.println ("Total days = " + totalDays);

    }

}
