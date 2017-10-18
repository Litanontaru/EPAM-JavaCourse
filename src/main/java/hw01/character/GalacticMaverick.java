package hw01.character;

import hw01.ship.SpaceShip;

public final class GalacticMaverick extends Character{
    public GalacticMaverick(String name, SpaceShip ship) {
        super(name, ship);
    }

    public void extraAbility(Character attacker) {
        System.out.printf("%s reflects %s's attack!\n", this.getName(), attacker.getName());
    }
}
