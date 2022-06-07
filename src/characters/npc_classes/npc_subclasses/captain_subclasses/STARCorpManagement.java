package characters.npc_classes.npc_subclasses.captain_subclasses;

import characters.npc_classes.Officer;
import main.auxilliary_tools.Dice;

public class STARCorpManagement extends Officer {
    @Override
    public int dealDamage() {
        return 0;
    }

    @Override
    public int[] rollStats() {
        int[] stats = new int[4];
        stats[0] = Dice.d6(3);
        stats[1] = Dice.d10(1) + 80;
        stats[2] = Dice.d10(1);
        return stats;
    }

    @Override
    public void printDamageCapability() {

    }

    @Override
    public String regularAttackToString() {
        return null;
    }


    public void printClassDescription() {

    }

    @Override
    public void printImage() {

    }
}
