package inventory.weapons.melee;

import inventory.weapons.Weapon;
import main.auxilliary_tools.Dice;

public abstract class CQCWeapon extends Weapon {
    private int numberOfUsesLeft;

    public int getNumberOfUsesLeft() {
        return numberOfUsesLeft;
    }

    public void setNumberOfUsesLeft(int numberOfUsesLeft) {
        this.numberOfUsesLeft = numberOfUsesLeft;
    }

    @Override
    public String toString() {
        return "Close Quarters Combat Weapon";
    }

    @Override
    public void depleteWeapon(int roll) {
        setNumberOfUsesLeft(getNumberOfUsesLeft()-(roll - Dice.d6(1)));
    }




}
