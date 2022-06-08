package inventory.weapons.explosives;

import characters.player_characters.PlayerCharacter;
import main.auxilliary_tools.Dice;

public class FragGrenade extends Explosive {
    private int shrapnelDamage;

    public FragGrenade() {
        setQuantity(20);
        setBurnDamage(Dice.d4(1));
        setShrapnelDamage(Dice.d6(1));
        setDamage(Dice.d4(1) + getShrapnelDamage() + getBurnDamage());
        setName("Frag Grenade");


    }

    public int getShrapnelDamage() {
        return shrapnelDamage;
    }

    public void setShrapnelDamage(int shrapnelDamage) {
        this.shrapnelDamage = shrapnelDamage;
    }


    @Override
    public void upgradeWeapon(PlayerCharacter p) {
        setQuantity(getMaxQuantity() + Dice.d4(2));
        setMaxQuantity(getQuantity());
        setShrapnelDamage(Dice.d6(1));
        setBurnDamage(getBurnDamage() + Dice.d4(1));
        setDamage(getDamage() + getShrapnelDamage() + getBurnDamage());
    }

    @Override
    public void depleteWeapon(int roll) {

    }
}
