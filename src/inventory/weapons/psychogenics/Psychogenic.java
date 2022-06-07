package inventory.weapons.psychogenics;

import inventory.weapons.Weapon;

public abstract class Psychogenic extends Weapon {
    private int energy;
    private int maxEnergy;

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }

    public void setMaxEnergy(int maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    @Override
    public String toString() {
        return "Psychogenic Powers";
    }


}
