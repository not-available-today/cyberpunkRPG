package inventory.weapons.psychogenics;

import characters.player_characters.PlayerCharacter;
import main.auxilliary_tools.Dice;

public class Telekenesis extends Psychogenic{
    private int darkMatterDamage;

    public Telekenesis() {
        setEnergy(15);
        setMaxEnergy(15);
        setDarkMatterDamage(Dice.d10(1));
        setDamage(Dice.d6(1)+getDarkMatterDamage());
        setName("Telekenesis");
    }

    public int getDarkMatterDamage() {
        return darkMatterDamage;
    }

    public void setDarkMatterDamage(int darkMatterDamage) {
        this.darkMatterDamage = darkMatterDamage;
    }

    @Override
    public void printInfo() {
        System.out.println("\b"+getName()  +
                           "\nDamage          : " + getDamage() +
                           "\nDarkMatterDamage: " + getDarkMatterDamage()+
                           "\nEnergy          : " + getEnergy()
        );
    }


    @Override
    public void upgradeWeapon(PlayerCharacter p) {

    }


}
