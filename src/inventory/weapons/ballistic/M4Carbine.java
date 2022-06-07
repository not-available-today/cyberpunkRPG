package inventory.weapons.ballistic;

import characters.player_characters.PlayerCharacter;

public class M4Carbine extends BallisticWeapon {

    public M4Carbine() {
        setAmmo(90);
        setMaxAmmo(90);
        setDamage(6);
        setName("M4 Carbine");
    }

    @Override
    public void printInfo() {

    }

    public final int useWeapon(){
        return getDamage();

    }

    public void upgradeWeapon(PlayerCharacter p){
        setDamage(getDamage()+p.getDamageMultiplier());

    }

    @Override
    public void depleteWeapon() {

    }
}
