package inventory.weapons.tech;

import characters.player_characters.PlayerCharacter;
import main.auxilliary_tools.Dice;

public class SonicBlast extends TechWeapon{

    public SonicBlast() {
        setUses(5);
        setMaxUses(5);
        setDamage( Dice.d12(6));
        setName("Sonic Blast");
        setPrice(20000);
    }

    public void upgradeWeapon(PlayerCharacter p){

    }

}
