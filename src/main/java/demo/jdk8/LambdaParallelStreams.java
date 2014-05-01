package demo.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class LambdaParallelStreams {
    static List<Months> months = Arrays.asList(Months.values());
    public static void main(String ... args){
        // calclualte average in parllell
        double avgDays = months
                .parallelStream()
                .mapToInt(m -> m.days)
                .average()
                .getAsDouble();

        // concurrent reduction of all month with 31 days
        IntStream.of(1, 2, 3, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
                .parallel()
                .filter( x -> (x % 2) == 0)
                .forEach(System.out::println);
    }
}
