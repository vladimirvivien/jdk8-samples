package demo.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LambdaStreams {
    static List<Months> months = Arrays.asList(Months.values());


    public static void main (String[] args){

        double avgDays = months
            .stream()
            .mapToInt(m -> m.days)
            .average()
            .getAsDouble();
        System.out.println ("Average days / moth = " + avgDays);

        System.out.println ();
        System.out.println ("---- First Half of Year ---");
        Stream.of(
                Months.January,
                Months.February,
                Months.March,
                Months.April,
                Months.May,
                Months.June).forEach(System.out::println);

        System.out.println();
        System.out.println (" ---- Quarter 3 ----");
        Arrays.stream(new String[]{"July", "August", "September"}).forEach(System.out::println);
    }
}
