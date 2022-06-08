package inventory.weapons.ballistic;

import characters.player_characters.PlayerCharacter;
import main.auxilliary_tools.Dice;

public class Glock17 extends BallisticWeapon {

    public Glock17() {
        setAmmo(60);
        setMaxAmmo(60);
        setWeaponLevel(1);
        setDamage(Dice.d4(getWeaponLevel()));
        setName("Glock-17");
    }

    @Override
    public void upgradeWeapon(PlayerCharacter p) {

    }

    @Override
    public void depleteWeapon(int roll) {
        setAmmo(getAmmo()-roll/4);
    }

    @Override
    public void printInfo() {
        System.out.println(getName() + ":" +
                "\nDamage:      " + getDamage() +
                "\nAmmoCapacity:" + getMaxAmmo() +
                "\nAmmoLeft:    " + getAmmo());

    }

}
