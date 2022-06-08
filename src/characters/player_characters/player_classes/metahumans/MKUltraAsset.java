package characters.player_characters.player_classes.metahumans;

import characters.npc_classes.NPC;
import characters.player_characters.PlayerCharacter;
import inventory.weapons.psychogenics.Telekenesis;
import inventory.weapons.psychogenics.Telepathy;
import main.auxilliary_tools.Dice;
import main.auxilliary_tools.Narrator;

public class MKUltraAsset extends Metahuman {
    public MKUltraAsset() {
        setMoveCounter(0);
        startStatSelection();
        selectAffiliation();
        setDamageMultiplier(5);
        selectPlayerColor();
        initializeMedPack();
        initializeWeapons();
        equipWeapon();
    }

    @Override
    public int[] rollStats() {
        int[] stats = new int[4];
        stats[0] = Dice.d8(5) +40;
        stats[1] = Dice.d10(3);
        stats[2] = Dice.d8(1);
        stats[3] = Dice.d8(1);
        return stats;
    }

    @Override
    public void initializeWeapons() {
        setPrimaryWeapon(new Telekenesis());
        setSecondaryWeapon(new Telepathy());
    }

    @Override
    public void attack(NPC opponent, PlayerCharacter player) {
        super.attack(opponent, player);
    }

    @Override
    public String regularAttackToString() {
        return "Telepathic Blast!";
    }

    @Override
    public String specialMoveToString() {
        return null;
    }

    @Override
    public void printDamageCapability() {

    }

    public static void printClassDescription() {
        System.out.println(Narrator.PURPLE + "MK-ULTRA ASSET:" + Narrator.ANSI_RESET+
                           "\nOne of Uncle Sam's dark secrets from\n" +
                           "\nthe past, a rogue psyonic force" +
                           "\nWeapons:Telekenesis/Telepathy" +
                           "\nInitial Damage Range: 12-120 " +
                           "\nInitial Health Range: 50-66" );
    }

    @Override
    public void printImage() {
        System.out.println("""
                Colt m4a1 carabine

                                     ,1             ,-===========.
                                    /,| ___________((____________\\\\_                _
                 ,========.________//_|/===========._#############L_Y_....-----====//
                (#######(==========\\################\\=======.______ --############((
                 `=======`"        ` ===============|::::.___|[ ))[JW]#############\\\\
                                                    |####|     ""\\###|   :##########\\\\
                                                   /####/         \\##\\     ```""\"=,,,))
                                                  /####/           \\##\\
                                                 '===='             `=`
                """);

    }
}
