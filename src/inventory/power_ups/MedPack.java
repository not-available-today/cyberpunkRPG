package inventory.power_ups;

import inventory.Item;
import main.auxilliary_tools.Dice;

public class MedPack extends Item {
    private int strength;
    private int quantity;

    public MedPack() {
        setName("MedPack");
        setPrice(50);
        setStrength(Dice.d12(1) + 1);
        setQuantity(Dice.d10(1) + 2);
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
                           "\nName:     :  " + getName() +
                           "\nStrength  : +" + getStrength() + "HP" +
                           "\nQuantity  :  " + getQuantity() + " left" +
                           "\nPrice     :  " + getPrice());

    }
}
