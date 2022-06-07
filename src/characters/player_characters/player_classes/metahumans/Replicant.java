package characters.player_characters.player_classes.metahumans;

import main.auxilliary_tools.Dice;
import main.auxilliary_tools.Narrator;

public class Replicant extends Metahuman {
    public Replicant() {
    }

    @Override
    public int[] rollStats() {
        int[] stats = new int[4];
        stats[0] = Dice.d8(5) + 5;
        stats[1] = Dice.d10(1) + 89;
        stats[2] = Dice.d8(1) + 1;
        stats[3] = Dice.d8(1);
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
        System.out.println(Narrator.PURPLE + "REPLICANT:" +
                           "\nHighly endurant, stronger than humans.\n" +
                           "\nWeapons:Sonic Blast/Glock 17" +
                           "\nInitial Damage Range: 12-120 " +
                           "\nInitial Health Range: 50-66" + Narrator.ANSI_RESET);

    }

    @Override
    public void printImage() {
        System.out.println("""
                ||
                  ||_________________________/'|
                 _| O======/                   |
                |_|              ============  |
                  |  __  ______________________|
                  |_/  )(     |___||     O-   /
                      (  )    /  / |_________/
                      (  )   /  /    | ) |   |
                      (__)  /  /     \\___|__(
                           /  / BigFoot  )   \\
                          /  /            )   \\
                         /  /              )___\\
                        /  /
                       /__/""");

    }
}
