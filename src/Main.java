import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        //Task1
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        List<String> cars = List.of("BMW", "Mercedes", "Audi", "BYD");
        List<Integer> emptyList = new ArrayList<>();

        System.out.println(filter(numbers, n -> n % 2 == 0));
        System.out.println(filter(cars, s -> s.startsWith("B")));
        System.out.println(filter(emptyList, n -> n % 2 == 0));

        //Task2
        System.out.println(map(cars, String::length));

        System.out.println(reduce(numbers, 0, (a, b) -> a + b));
        System.out.println(reduce(numbers, 1, (a, b) -> a * b));

        forEach(cars, System.out::println);


    }

    // Task-1
    public static <T> List<T> filter(List<T> inputList, Predicate<T> condition) {
        List<T> resultList = new ArrayList<>();
        for (T element : inputList) {
            if (condition.test(element)) {
                resultList.add(element);
            }
        }
        return resultList;
    }

    // Task-2
    public static <T, R> List<R> map(List<T> inputList, Function<T, R> function) {
        List<R> resultList = new ArrayList<>();
        for (T element : inputList) {
            resultList.add(function.apply(element));
        }
        return resultList;
    }

    public static <T> void forEach(List<T> inputList, Consumer<T> consumer) {
        for (T element : inputList) {
            consumer.accept(element);
        }
    }

    public static <T> T reduce(List<T> inputList, T initial, BinaryOperator<T> operator) {
        T result  = initial;
        for (T element : inputList) {
            result  = operator.apply(result , element);
        }
        return result ;
    }
}