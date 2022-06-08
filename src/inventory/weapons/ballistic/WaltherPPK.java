package inventory.weapons.ballistic;

import characters.player_characters.PlayerCharacter;
import main.auxilliary_tools.Dice;

public class WaltherPPK extends BallisticWeapon {

    public WaltherPPK() {
        setAmmo(40);
        setMaxAmmo(40);
        setDamage(Dice.d6(1));
        setName("Walther PPK");
    }

    @Override
    public void printInfo() {
        System.out.println(getName() +":" +
                           "\nDamage        :" +  getDamage() +
                           "\nAmmoCapacity  :" + getMaxAmmo() +
                           "\nAmmoLeft      :" + getAmmo());

    }


    @Override
    public void upgradeWeapon(PlayerCharacter p) {

    }

    @Override
    public void depleteWeapon(int roll) {
        setAmmo(getAmmo() - roll / 4);
    }
}
