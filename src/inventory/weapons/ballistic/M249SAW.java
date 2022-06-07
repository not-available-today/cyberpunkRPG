package inventory.weapons.ballistic;

import characters.player_characters.PlayerCharacter;

public class M249SAW extends BallisticWeapon {
    public M249SAW() {
        setAmmo(3000);
        setMaxAmmo(3000);
        setDamage(7);
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
