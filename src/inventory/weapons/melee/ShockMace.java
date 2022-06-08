package inventory.weapons.melee;

import characters.player_characters.PlayerCharacter;
import main.auxilliary_tools.Dice;

public class ShockMace extends CQCWeapon {

    private int shockDamage;

    public ShockMace() {
        setNumberOfUsesLeft(12);
        setShockDamage(Dice.d6(1));
        setDamage(getShockDamage()+Dice.d10(1));
        setName("Shock Mace");
        setPrice(1200);
    }

    public int getShockDamage() {
        return shockDamage;
    }

    public void setShockDamage(int shockDamage) {
        this.shockDamage = shockDamage;
    }

    @Override
    public void printInfo() {
        System.out.println(getName() + ":" +
                           "\nDamage:      " + getDamage() +
                           "\nShockDamage:" + getShockDamage()+
                           "\nNumber of Uses Left" + getNumberOfUsesLeft()
        );
    }

    @Override
    public void upgradeWeapon(PlayerCharacter p) {

    }

}
