package hw04.stream;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Author {
    private final String name;
    private final LocalDate birthDate;
    private LocalDate deathDate;
    private final Gender gender;

    public Author(String name, Gender gender, LocalDate birthDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    public Author(String name, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        this(name, gender, birthDate);
        this.deathDate = deathDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getAge() {
        return (int) ChronoUnit.YEARS.between(this.getBirthDate(), LocalDate.now());
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public boolean isAlive() {
        return getDeathDate() == null;
    }
}
