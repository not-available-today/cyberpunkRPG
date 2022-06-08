package characters.player_characters.player_classes.metahumans;

import characters.npc_classes.NPC;
import characters.player_characters.PlayerCharacter;
import inventory.weapons.ballistic.Glock17;
import inventory.weapons.melee.ShockMace;
import main.auxilliary_tools.Dice;
import main.auxilliary_tools.Narrator;

public class Replicant extends Metahuman {

    public Replicant() {
        setMoveCounter(0);
        startStatSelection();
        selectAffiliation();
        setDamageMultiplier(6);
        selectPlayerColor();
        initializeMedPack();
        initializeWeapons();
        equipWeapon();
    }

    @Override
    public int[] rollStats() {
        int[] stats = new int[4];
        stats[0] = Dice.d6(2) + 60;
        stats[1] = Dice.d10(3);
        stats[2] = Dice.d8(1);
        stats[3] = Dice.d4(1);
        return stats;
    }

    @Override
    public void initializeWeapons() {
        setPrimaryWeapon(new ShockMace());
        setSecondaryWeapon(new Glock17());
    }

    @Override
    public void attack(NPC opponent, PlayerCharacter player) {
        super.attack(opponent, player);
    }

    @Override
    public String regularAttackToString() {
        return "Shock Blast";
    }

    @Override
    public String specialMoveToString() {
        return "Supernove Explosion";
    }

    @Override
    public void printDamageCapability() {
    }

    public static void printClassDescription() {
        System.out.println(Narrator.PURPLE + "REPLICANT:" + Narrator.ANSI_RESET+
                           "\nHighly endurant, stronger than humans.\n" +
                           "\nWeapons:Shock Mace /Glock 17" +
                           "\nInitial Damage Range: 12-120 " +
                           "\nInitial Health Range: 60-72" );

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
