package inventory.weapons.ballistic;

import inventory.weapons.Weapon;

public abstract class BallisticWeapon extends Weapon {
    private int ammo;
    private int maxAmmo;


    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    public int getMaxAmmo() {
        return maxAmmo;
    }

    public void setMaxAmmo(int maxAmmo) {
        this.maxAmmo = maxAmmo;
    }

    @Override
    public String toString() {
        return "Ballistic";
    }


}
