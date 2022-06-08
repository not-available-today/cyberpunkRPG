package inventory.weapons.melee;

import characters.player_characters.PlayerCharacter;
import main.auxilliary_tools.Dice;

public class HuntingKnife extends CQCWeapon {
    public HuntingKnife() {
        setNumberOfUsesLeft(50);
        setDamage(Dice.d4(1));
        setName("Hunting Knife");
        setPrice(400);
    }

    @Override
    public void upgradeWeapon(PlayerCharacter p) {

    }

    @Override
    public void printInfo() {
        System.out.println("\b"+getName()+":" +
                           "\nDamage       :" + getDamage() +
                           "\nBurnDamage   :" + getNumberOfUsesLeft()
        );
    }
}
