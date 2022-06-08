package inventory.weapons.melee;

import characters.player_characters.PlayerCharacter;
import main.auxilliary_tools.Dice;

public class Katana extends CQCWeapon{

    public Katana() {
        setNumberOfUsesLeft(100);
        setDamage(Dice.d10(5));
        setName("Katana");
        setPrice(10000);
    }

    @Override
    public void printInfo() {

    }

    @Override
    public void upgradeWeapon(PlayerCharacter p) {

    }


}
