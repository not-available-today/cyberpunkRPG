package inventory.weapons.tech;

import inventory.weapons.Weapon;

public abstract class TechWeapon extends Weapon {
    private int uses;
    private int maxUses;

    public int getUses() {
        return uses;
    }

    public void setUses(int uses) {
        this.uses = uses;
    }

    public int getMaxUses() {
        return maxUses;
    }

    public void setMaxUses(int maxUses) {
        this.maxUses = maxUses;
    }

    @Override
    public String toString() {
        return "Tech Weapon";
    }


    @Override
    public void depleteWeapon(int roll) {
        setUses(getUses()-roll/2);
    }

    @Override
    public void printInfo() {
        System.out.println(getName() + ":" +
                           "\nDamage    :" + getDamage() +
                           "\nUses Left :" + getUses()
        );
    }
}
