package hw01.weapon;

public abstract class Weapon{
    private final String name;

    protected Weapon(String name) {
        this.name = name;
    }

    public abstract void fire();

    public String getName() {
        return name;
    }
}
