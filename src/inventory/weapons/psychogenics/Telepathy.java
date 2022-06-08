package inventory.weapons.psychogenics;

import characters.player_characters.PlayerCharacter;
import main.auxilliary_tools.Dice;

public class Telepathy extends Psychogenic{

    public Telepathy() {
        setEnergy(15);
        setMaxEnergy(15);
        setDamage(Dice.d6(4));
        setName("Telekenesis");
    }

    @Override
    public void printInfo() {
        System.out.println("\b"+getName()  +
                           "\nDamage          : " + getDamage() +
                           "\nEnergy          : " + getEnergy()
        );
    }

    @Override
    public void upgradeWeapon(PlayerCharacter p) {

    }

}
