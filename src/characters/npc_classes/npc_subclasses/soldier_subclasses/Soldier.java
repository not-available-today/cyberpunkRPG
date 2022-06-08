package characters.npc_classes.npc_subclasses.soldier_subclasses;

import characters.npc_classes.NPC;
import main.auxilliary_tools.Dice;

public abstract class Soldier extends NPC {




    @Override
    public int[] rollStats() {
        int[] stats = new int[3];
        stats[0] = Dice.d8(2)+20;
        stats[1] = Dice.d10(2) ;
        stats[2] = Dice.d4(1);
        return stats;
    }

    @Override
    public void printDamageCapability() {
        System.out.println("1d6 + " + getLevel() * 2);
    }

    @Override
    public String regularAttackToString() {
        return null;
    }

    @Override
    public String toString(){
        return "Soldier";
    }

    @Override
    public void printImage() {
    }


    public static void printClassDescription() {
        System.out.println("Soldier");
    }
}
