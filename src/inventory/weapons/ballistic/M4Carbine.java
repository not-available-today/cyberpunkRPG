package inventory.weapons.ballistic;

import characters.player_characters.PlayerCharacter;
import main.auxilliary_tools.Dice;

public class M4Carbine extends BallisticWeapon {

    public M4Carbine() {
        setAmmo(90);
        setMaxAmmo(90);
        setDamage(Dice.d6(5));
        setName("M4 Carbine");
    }

    public void upgradeWeapon(PlayerCharacter p){
        setAmmo(getMaxAmmo()+Dice.d4(3));
        setDamage(getDamage()+p.getDamageMultiplier());
    }

    @Override
    public void depleteWeapon(int roll) {
        setAmmo(getAmmo()-roll);
    }

    @Override
    public void printInfo() {
        System.out.println(getName() + ":" +
                           "\nDamage:      " + getDamage() +
                           "\nAmmoCapacity:" + getMaxAmmo() +
                           "\nAmmoLeft:    " + getAmmo());

    }
}
