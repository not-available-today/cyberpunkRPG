package inventory.weapons.ballistic;

import characters.player_characters.PlayerCharacter;

public class Glock17 extends BallisticWeapon {

    public Glock17() {
        setAmmo(60);
        setMaxAmmo(60);
        setDamage(4);
        setName("Glock-17");
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
        System.out.println(getName() + ":" +
                "\nDamage:      " + getDamage() +
                "\nAmmoCapacity:" + getMaxAmmo() +
                "\nAmmoLeft:    " + getAmmo());

    }

}
