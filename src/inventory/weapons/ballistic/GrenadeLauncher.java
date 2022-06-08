package inventory.weapons.ballistic;

import characters.player_characters.PlayerCharacter;
import main.auxilliary_tools.Dice;

public class GrenadeLauncher extends BallisticWeapon {

    public GrenadeLauncher() {
        setAmmo(18);
        setMaxAmmo(24);
        setDamage(Dice.d10(getWeaponLevel()));
        setName("Grenade Launcher");
    }

    @Override
    public void upgradeWeapon(PlayerCharacter p) {
        setAmmo(getMaxAmmo()*Dice.d6(3));
        setMaxAmmo(getAmmo());
        setDamage(getDamage()+Dice.d12(2));
    }

    @Override
    public void depleteWeapon(int roll) {
        setAmmo(getAmmo()-roll/3);
    }

    @Override
    public void printInfo() {
        System.out.println(getName() + ":" +
                           "\nDamage:      " + getDamage() +
                           "\nAmmoCapacity:" + getMaxAmmo() +
                           "\nAmmoLeft:    " + getAmmo());
    }

}
