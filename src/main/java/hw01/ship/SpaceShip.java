package hw01.ship;

import hw01.weapon.shipweapon.ShipWeapon;

public abstract class SpaceShip implements Cloneable {
    private final String name;
    private ShipWeapon weapon;

    SpaceShip(String name, ShipWeapon weapon) {
        this.name = name;
        this.weapon = weapon.clone();
    }

    public String getName() {
        return name;
    }

    public String getWeaponName() {
        return weapon.getName();
    }

    public void setWeapon(ShipWeapon weapon) {
        this.weapon = weapon.clone();
    }

    public void attack() {
        weapon.fire();
    }

    @Override
    public SpaceShip clone() {
        try {
            return (SpaceShip) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning isn't supported.");
            return this;
        }
    }
}
