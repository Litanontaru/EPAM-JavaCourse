package hw01.character;

import hw01.ship.SpaceShip;

public final class DarkInvader extends Character {
    public DarkInvader(String name, SpaceShip ship) {
        super(name, ship);
    }

    public void extraAbility(Character target) {
        System.out.println(this.getName() + " undertakes an attempt of the combo:");
        attack(target);
        attack(target);
    }
}
