package hw01.weapon.shipweapon;

public class Plasmagun extends ShipWeapon {
    public Plasmagun() {
        super("plasmagun");
    }

    @Override
    public void fire() {
        System.out.println("Ommmmm!");
    }
}
