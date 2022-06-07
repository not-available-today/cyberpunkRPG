package inventory.power_ups;

import main.auxilliary_tools.Dice;

public class MedPack extends PowerUp {
    private int strength;
    private int quantity;

    public MedPack() {
        setStrength(Dice.d12(1) + 1);
        setQuantity(Dice.d10(1)+2);
    }

    public int getStrength() {
        return this.strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public void printInfo() {
        System.out.println("Med-Pack: " +
                           "\nStrength: +" + getStrength() + "HP"+
                           "\nQuantity:  " + getQuantity()+ " left");

    }
}
