package inventory.weapons.ballistic;

import characters.player_characters.PlayerCharacter;
import main.auxilliary_tools.Dice;

public class GrenadeLauncher extends BallisticWeapon {

    public GrenadeLauncher() {
        setAmmo(18);
        setMaxAmmo(24);
        setDamage(Dice.d6(3));
        setName("Grenade Launcher");
    }

    @Override
    public int useWeapon() {
        return 0;
    }

    @Override
    public void upgradeWeapon(PlayerCharacter p) {

    }

    @Override
    public void depleteWeapon() {

    }

    @Override
    public void printInfo() {

    }

}
