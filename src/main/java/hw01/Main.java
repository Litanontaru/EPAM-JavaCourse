package hw01;

import hw01.character.Character;
import hw01.character.DarkInvader;
import hw01.character.GalacticMaverick;
import hw01.ship.SpeedRocket;
import hw01.weapon.shipweapon.Laser;
import hw01.weapon.shipweapon.Plasmagun;

public class Main {
    public static void main(String[] args) {
        Character char1 = new DarkInvader("Teobaldus", new SpeedRocket("45MH-32", new Plasmagun()));
        Character char2 = new GalacticMaverick("Zoiqshee", new SpeedRocket("*@*ZQ7", new Laser()));

        System.out.println("\nThe most epic space battle (ever):\n");
        char1.attack(char2);
        char2.extraAbility(char1);
        char1.extraAbility(char2);
        char2.attack(char1);
    }
}
