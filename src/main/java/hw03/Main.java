package hw03;

import hw03.function.BinaryOperator;
import hw03.function.Function;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> listInt = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> predicateInt = Arrays.asList(2, 3);
        ListWithMapAndReduce<Integer> list1 = new ListWithMapAndReduce<>(listInt, predicateInt);

        printLists(listInt, predicateInt, list1);

        Function<Integer,Integer> mapFunction1 = new Function<Integer,Integer>(){
            @Override
            public Integer apply(Integer integer) {
                return integer * 2;
            }
        };
        testMapping(list1, mapFunction1);

        BinaryOperator<Integer> biOperator1 = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer int1, Integer int2) {
                return int1 + int2;
            }
        };
        testReduction(list1, biOperator1);

        System.out.println();

        List<String> listStr = Arrays.asList("1", "2", "door", "knot", "6");
        List<String> predicateStr = Arrays.asList("door", "knot");
        ListWithMapAndReduce<String> list2 = new ListWithMapAndReduce<>(listStr, predicateStr);

        printLists(listStr, predicateStr, list2);

        Function<String,Integer> mapFunction2 = new Function<String,Integer>(){
            @Override
            public Integer apply(String s) {
                return Integer.valueOf(s) * 3;
            }
        };
        testMapping(list2, mapFunction2);

        BinaryOperator<String> biOperator2 = new BinaryOperator<String>() {
//            @Override
            public String apply(String s1, String s2) {
                return s1 + "/" + s2;
            }
        };
        testReduction(list2, biOperator2);
    }

    private static <E> void printLists(List<E> original, List<E> predicate, List<E> result){
        System.out.print("Original: ");
        original.forEach(s -> System.out.print(s + " "));
        System.out.println();
        System.out.print("Predicate: ");
        predicate.forEach(s -> System.out.print(s + " "));
        System.out.println();
        System.out.print("Iterable result: ");
        for (E e : result) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    private static <E,R> void testMapping(ListWithMapAndReduce<E> list, Function<E, R> mapper) {
        System.out.print("After mapping: ");
        for (R e : list.map(mapper)) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    private static <E> void testReduction(ListWithMapAndReduce<E> list, BinaryOperator<E> accumulator) {
        System.out.print("After reduction: ");
        System.out.println(list.reduce(accumulator));
    }
}
