package hw01.character;

import hw01.ship.SpaceShip;

public abstract class Character {
    private final String name;
    private SpaceShip ship;

    Character(String name, SpaceShip ship) {
        this.name = name;
        this.ship = ship.clone();
    }

    public String getName() {
        return name;
    }

    public void attack(Character target) {
        System.out.printf("%s attacks %s's ship with the %s! ", this.getName(), target.getName(), ship.getWeaponName());
        ship.attack();
    }

    public abstract void extraAbility(Character target);
}
