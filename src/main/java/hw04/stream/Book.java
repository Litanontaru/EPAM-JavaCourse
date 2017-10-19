package hw04.stream;

import java.util.List;

public class Book {
    private final String name;
    private final int publicationYear;
    private final List<Author> authors;

    public Book(String name, int publicationYear, List<Author> authors) {
        this.name = name;
        this.publicationYear = publicationYear;
        this.authors = authors;
    }

    public String getName() {
        return name;
    }

    public int getYearOfPublication() {
        return publicationYear;
    }

    public List<Author> getAuthors() {
        return authors;
    }
}
