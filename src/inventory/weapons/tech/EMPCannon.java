package inventory.weapons.tech;

import characters.player_characters.PlayerCharacter;
import main.auxilliary_tools.Dice;

public class EMPCannon extends TechWeapon {
    public EMPCannon() {
        setUses(30);
        setMaxUses(30);
        setDamage(Dice.d20()+Dice.d6(4));
        setName("EMP Cannon");
        setPrice(30000);
    }

    @Override
    public void upgradeWeapon(PlayerCharacter p) {

    }

}
