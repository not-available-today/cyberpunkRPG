package inventory.weapons;

import characters.player_characters.PlayerCharacter;
import inventory.Item;

public abstract class Weapon extends Item {

    private int damage;
    private int weaponLevel;

    public Weapon() {

    }




    //region getters/setters
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getWeaponLevel() {
        return weaponLevel;
    }

    public void setWeaponLevel(int weaponLevel) {
        this.weaponLevel = weaponLevel;
    }

    //endregion

    public abstract void upgradeWeapon(PlayerCharacter p);

    public abstract void depleteWeapon(int roll);
    @Override
    public abstract String toString();
}
