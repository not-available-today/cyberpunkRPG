package inventory.weapons.ballistic;

import characters.player_characters.PlayerCharacter;

public class M82A1SniperRile extends BallisticWeapon {
    public M82A1SniperRile() {
        setAmmo(200);
        setMaxAmmo(20);
        setDamage(15);
        setName("M82A1 Sniper Rile");
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
