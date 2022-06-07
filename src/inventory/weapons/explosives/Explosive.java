package inventory.weapons.explosives;

import inventory.weapons.Weapon;

public abstract class Explosive extends Weapon {
    private int area;
    private int burnDamage;

    private int quantity;

    public Explosive() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getBurnDamage() {
        return burnDamage;
    }

    public void setBurnDamage(int burnDamage) {
        this.burnDamage = burnDamage;
    }

    @Override
    public String toString() {
        return "Explosive";
    }

}
