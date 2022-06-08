package inventory.weapons.explosives;

import characters.player_characters.PlayerCharacter;
import main.auxilliary_tools.Dice;

public class C4 extends Explosive {
    public C4() {
        setQuantity(5);
        setArea(Dice.d4(2));
        setBurnDamage(Dice.d10(1));
        setDamage(Dice.d10(1) + getBurnDamage());
        setName("C4");

    }


    public void upgradeWeapon(PlayerCharacter p) {
        setDamage(getDamage() + p.getDamageMultiplier());
    }

}
