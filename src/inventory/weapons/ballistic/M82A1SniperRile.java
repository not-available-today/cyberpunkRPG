package inventory.weapons.ballistic;

import characters.player_characters.PlayerCharacter;
import main.auxilliary_tools.Dice;

public class M82A1SniperRile extends BallisticWeapon {
    public M82A1SniperRile() {
        setAmmo(20);
        setMaxAmmo(20);
        setDamage(Dice.d8(1));
        setName("M82A1 Sniper Rile");
    }

    @Override
    public void upgradeWeapon(PlayerCharacter p) {
        setAmmo(getMaxAmmo()*Dice.d10(1)+Dice.d4(1));
        setMaxAmmo(getAmmo());
        setDamage(getDamage()+Dice.d10(2));
    }

    @Override
    public void depleteWeapon(int roll) {
        setAmmo(getAmmo()-1);
    }

    @Override
    public void printInfo() {
        System.out.println(getName() + ":" +
                           "\nDamage:      " + getDamage() +
                           "\nAmmoCapacity:" + getMaxAmmo() +
                           "\nAmmoLeft:    " + getAmmo());
    }

}
