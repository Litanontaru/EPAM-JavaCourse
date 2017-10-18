package hw01.weapon.shipweapon;

public final class Laser extends ShipWeapon {
    public Laser() {
        super("laser");
    }
    @Override
    public void fire() {
        System.out.println("Pew-pew-pew!");
    }
}
