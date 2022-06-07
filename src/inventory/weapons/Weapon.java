package inventory.weapons;

import characters.player_characters.PlayerCharacter;
import inventory.Item;

public abstract class Weapon extends Item {

    private int damage;

    public Weapon() {
    }



    //region getters/setters

    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }

    //endregion

    public abstract  int useWeapon();

    public abstract void upgradeWeapon(PlayerCharacter p);

    public abstract void depleteWeapon();
    @Override
    public abstract String toString();
}
