package characters.player_characters.player_classes.metahumans;

import inventory.Inventory;
import inventory.weapons.explosives.C4;
import inventory.weapons.explosives.FragGrenade;
import main.auxilliary_tools.Dice;

public class Biodroid extends Metahuman {

    public Biodroid() {
        setMoveCounter(0);
        startStatSelection();
        chooseAffiliation();
        setDamageMultiplier(5);
        selectPlayerColor();
        setPrimaryWeapon(new C4(Dice.d8(1)));
        setSecondaryWeapon(new FragGrenade());
        setRucksack(new Inventory(this));
    }

    @Override
    public int[] rollStats() {
        int[] stats = new int[4];
        stats[0] = Dice.d8(5) + 5;
        stats[1] = Dice.d10(1) + 89;
        stats[2] = Dice.d8(1) + 1;
        stats[3] = Dice.d6(1);
        return stats;
    }

    @Override
    public int dealDamage() {
        return 0;
    }

    @Override
    public String regularAttackToString() {
        return null;
    }

    @Override
    public String specialMoveToString() {
        return null;
    }

    @Override
    public void printDamageCapability() {

    }


    public static void printClassDescription() {

    }

    @Override
    public void printImage() {

    }
}
