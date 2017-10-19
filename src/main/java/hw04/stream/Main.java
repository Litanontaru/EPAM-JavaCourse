package hw04.stream;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

public class Main {
    private static Map<String, Author> authors = new HashMap<>();
    private static List<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        populateAuthors();
        populateBooks();

        System.out.print("1. Average author age (years): ");
        int averageAge = authors.values().stream()
                .collect(averagingInt(Author::getAge))
                .intValue();
        System.out.println(averageAge + "\n");

        System.out.println("2. The list of authors sorted by age in ascending order:");
        System.out.println(authors.values().stream()
                .sorted(Comparator.comparing(Author::getAge))
                .map(Author::getName)
                .collect(joining(", ")) + "\n");

        System.out.println("3. The list of retirees among authors:");
        System.out.println(authors.values().stream()
                .filter(author -> (author.getGender().equals(Gender.MALE) && author.getAge() > 65)
                        || (author.getGender().equals(Gender.FEMALE) && author.getAge() > 63))
                .map(Author::getName)
                .collect(joining(", ")));

        System.out.println("\n\n4. Book | Years since the publication date:");
        books.forEach(book -> System.out.print(book.getName() + " | "
                + ChronoUnit.YEARS.between(LocalDate.ofYearDay(book.getYearOfPublication(),
                1), LocalDate.now()) + "\n"));

        System.out.println("\n\n5. Authors who wrote collaboratively:");
        Set<Author> coAuthors = books.stream()
                .filter(book -> book.getAuthors().size() > 1)
                .collect(flatMapping(book -> book.getAuthors().stream(), toSet()));
        System.out.println(coAuthors.stream().map(Author::getName).collect(joining(",")));

        Map<Author, List<Book>> booksByAuthor = books.stream()
                .flatMap(book -> book.getAuthors().stream())
                .distinct()
                .collect(toMap(Function.identity(), author -> books.stream()
                        .filter(book -> book.getAuthors().contains(author))
                        .collect(toList())));

        booksByAuthor.forEach((author, books) -> {
            System.out.println("Author: " + author.getName());
            System.out.println("Books: " + books.stream().map(Book::getName).collect(joining(" | ")));
            System.out.println();
        });
    }

    private static void populateAuthors() {
        authors.put("Pushkin", new Author("Alexander Pushkin", Gender.MALE,
                LocalDate.of(1799, 6, 6), LocalDate.of(1837, 2, 10)));
        authors.put("Kiyosaki", new Author("Robert Kiyosaki", Gender.MALE,
                LocalDate.of(1947, 4, 8)));
        authors.put("Dontsova", new Author("Darya Dontsova", Gender.FEMALE,
                LocalDate.of(1952, 6, 7)));
        authors.put("Landau", new Author("Lev Landau", Gender.MALE,
                LocalDate.of(1908, 1, 22), LocalDate.of(1968, 4, 1)));
        authors.put("Lifshitz", new Author("Evgeny Lifshitz", Gender.MALE,
                LocalDate.of(1915, 2, 21), LocalDate.of(1985, 10, 29)));
        authors.put("Yudkowsky", new Author("Eliezer Yudkowsky", Gender.MALE,
                LocalDate.of(1979, 9, 11)));
        authors.put("Ilf", new Author("Ilya Ilf", Gender.MALE,
                LocalDate.of(1897, 10, 15), LocalDate.of(1937, 4, 13)));
        authors.put("Petrov", new Author("Evgeny Petrov", Gender.MALE,
                LocalDate.of(1902, 12, 13), LocalDate.of(1942, 7, 2)));
        authors.put("Rowling", new Author("Joanne Rowling", Gender.FEMALE,
                LocalDate.of(1965, 7, 31)));
    }

    private static void populateBooks() {
        books.add(new Book("Dubrovsky", 1841, Arrays.asList(authors.get("Pushkin"))));
        books.add(new Book("The Captain's Daughter", 1836, Arrays.asList(authors.get("Pushkin"))));
        books.add(new Book("Ruslan and Ludmila", 1820, Arrays.asList(authors.get("Pushkin"))));
        books.add(new Book("Second Chance: for Your Money, Your Life and Our World",
                2015, Arrays.asList(authors.get("Kiyosaki"))));
        books.add(new Book("Blablabla", 2011, Arrays.asList(authors.get("Dontsova"))));
        books.add(new Book("Mechanics", 1975,
                Arrays.asList(authors.get("Landau"), authors.get("Lifshitz"))));
        books.add(new Book("The Classical Theory of Fields", 1976,
                Arrays.asList(authors.get("Landau"), authors.get("Lifshitz"))));
        books.add(new Book("Statistical Physics, Part 1", 1980,
                Arrays.asList(authors.get("Landau"), authors.get("Lifshitz"))));
        books.add(new Book("Levels of Organization in General Intelligence",
                2007, Arrays.asList(authors.get("Yudkowsky"))));
        books.add(new Book("Friendly Artificial Intelligence",
                2012, Arrays.asList(authors.get("Yudkowsky"))));
        books.add(new Book("The Twelve Chairs", 1928,
                Arrays.asList(authors.get("Ilf"), authors.get("Petrov"))));
        books.add(new Book("The Little Golden Calf", 1931,
                Arrays.asList(authors.get("Ilf"), authors.get("Petrov"))));
        books.add(new Book("Harry Potter and the Goblet of Fire", 2000,
                Arrays.asList(authors.get("Rowling"))));
    }
}
