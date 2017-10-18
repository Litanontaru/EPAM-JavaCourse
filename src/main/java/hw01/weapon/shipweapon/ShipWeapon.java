package hw01.weapon.shipweapon;

import hw01.weapon.Weapon;

public abstract class ShipWeapon extends Weapon implements Cloneable {
    ShipWeapon(String name) {
        super(name);
    }

    @Override
    public ShipWeapon clone() {
        try {
            return (ShipWeapon) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning is not supported.");
            return this;
        }
    }
}
