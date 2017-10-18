package hw02;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Main {
    private static List<Integer> originalList = Arrays.asList(-223, -67, -67, -11, 0, 32, 32, 87, 189, 200, 200);
    private static List<Integer> predicate = Arrays.asList(-67, 0, 87, 200);
    private static List<Integer> list = new ListWithIgnoredElements<>(originalList, predicate);

    public static void main(String[] args) {
        System.out.print("Original: ");
        originalList.forEach(s -> System.out.print(s + " "));
        System.out.println();
        System.out.print("Predicate: ");
        predicate.forEach(s -> System.out.print(s + " "));
        System.out.println();
        printResult();

        Iterator<Integer> itr = list.iterator();
        System.out.println();
        System.out.println("Trying to call hasNext() method two times in a row before iterating.");
        itr.hasNext();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        System.out.println("\n\nIterating without hasNext() method:");
        itr = list.iterator();
        while (true) {
            try {
                int i = itr.next();
                System.out.print(i + " ");
            } catch (NoSuchElementException e) {
                System.out.println();
                break;
            }
        }

        System.out.println();
        removeWhileIterating(-11);
        removeWhileIterating(87);

        System.out.println();
        testRemove(1);
        testRemove(0);

        System.out.println();
        testRemove(Integer.valueOf(32));
        testRemove(Integer.valueOf(87));

        System.out.println();
        testAdd(200);
        testAdd(300);

        System.out.println();
        testAdd(0, 87);
        testAdd(1, 999);
    }

    private static void printResult() {
        System.out.print("Iterable result: ");
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void removeWhileIterating(Integer element) {
        int temp = list.size();
        System.out.printf("Trying to remove %d while iterating. ", element);
        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()) {
            int i = itr.next();
            if (i == element) {
                itr.remove();
                break;
            }
        }
        if (list.size() != temp) {
            printResult();
        } else {
            System.out.println("The element is ignored!");
        }

    }

    private static void testRemove(int index) {
        System.out.printf("Trying to remove an element at the index %d (%d). ", index, list.get(index));
        if (list.remove(index) != null) {
            printResult();
        }
    }

    private static void testRemove(Integer element) {
        System.out.printf("Trying to remove %d from the list. ", element);
        if (list.remove(element)) {
            printResult();
        } else {
            System.out.println("The element is ignored!");
        }
    }

    private static void testAdd(int element) {
        System.out.printf("Trying to add %d. ", element);
        if (list.add(element)) {
            printResult();
        } else {
            System.out.println("The element is ignored!");
        }
    }

    private static void testAdd(int index, int element) {
        int temp = list.size();
        System.out.printf("Trying to insert %d at the index %d. ", element, index);
        list.add(index, element);
        if (list.size() != temp) {
            printResult();
        }
    }
}
