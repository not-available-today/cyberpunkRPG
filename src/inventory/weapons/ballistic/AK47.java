package inventory.weapons.ballistic;

import characters.player_characters.PlayerCharacter;
import main.auxilliary_tools.Dice;

public class AK47 extends BallisticWeapon {

    public AK47() {
        setAmmo(400);
        setMaxAmmo(400);
        setDamage(Dice.d6(1) * Dice.d8(3));
        setName("AK-47");
        setPrice(1200);
    }

    @Override
    public void printInfo() {
        System.out.println(getName() +
                           "\nAmmo              :" + getAmmo() +
                           "\nMaximum Capacity  :" + getMaxAmmo() +
                           "\nDamage            :" + getDamage());
    }

    @Override
    public void upgradeWeapon(PlayerCharacter p) {
        setAmmo(getMaxAmmo() + (Dice.d20() * 5));
        setMaxAmmo(getAmmo());
        setDamage(getDamage() + Dice.d10(3));
    }

    @Override
    public void depleteWeapon(int roll) {
        setAmmo(getAmmo() - roll * 4);
    }
}
