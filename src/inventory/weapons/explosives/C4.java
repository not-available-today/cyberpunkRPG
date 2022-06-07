package inventory.weapons.explosives;

import characters.player_characters.PlayerCharacter;
import main.auxilliary_tools.Dice;

public class C4 extends Explosive{
    public C4(int q) {
        setArea(Dice.d4(2));
        setBurnDamage(Dice.d6(3));
        setDamage(Dice.d12(3));

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
