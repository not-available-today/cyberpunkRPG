package inventory.weapons.ballistic;

import characters.player_characters.PlayerCharacter;
import main.auxilliary_tools.Dice;

public class M249SAW extends BallisticWeapon {
    public M249SAW() {
        setAmmo(3000);
        setMaxAmmo(3000);
        setDamage(Dice.d8(1));
        setName("M249SAW");
    }

    @Override
    public void upgradeWeapon(PlayerCharacter p) {
        setAmmo(getMaxAmmo()*Dice.d20()*5);
        setMaxAmmo(getAmmo());
        setDamage(getDamage()+Dice.d12(2));
    }

    @Override
    public void depleteWeapon(int roll) {
        setAmmo(getAmmo()-roll*10);
    }

    @Override
    public void printInfo() {

    }

}
