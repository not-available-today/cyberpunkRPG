package inventory.weapons.tech;

import characters.player_characters.PlayerCharacter;
import main.auxilliary_tools.Dice;

public class DroneSwarm extends TechWeapon{
    public DroneSwarm() {
        setUses(3);
        setQuantity(60);
        setMaxUses(3);
        setDamage(getQuantity() * Dice.d6(1));
        setName("Drone Swarm");
        setPrice(20000);
    }

    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public void printInfo() {
        System.out.println(getName() + ":" +
                           "\nDamage    :" + getDamage() +
                           "\nQuantity  :" + getQuantity()+
                           "\nUses Left :" + getUses()
        );
    }

    @Override
    public void upgradeWeapon(PlayerCharacter p) {

    }

    @Override
    public void depleteWeapon(int roll) {
        setUses(getUses()-1);
        setQuantity(getQuantity()-roll);
    }
}
