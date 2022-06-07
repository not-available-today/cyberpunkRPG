package inventory.weapons.melee;

import inventory.weapons.Weapon;

public abstract class CQCWeapon extends Weapon {
    private int durability;

    @Override
    public String toString() {
        return "Close Quarters Combat Weapon";
    }

}
