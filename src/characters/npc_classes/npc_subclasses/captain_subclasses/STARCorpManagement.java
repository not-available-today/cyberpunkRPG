package characters.npc_classes.npc_subclasses.captain_subclasses;

import characters.npc_classes.NPC;
import characters.player_characters.PlayerCharacter;
import main.auxilliary_tools.Dice;
import main.gameplay.Attack;

public class STARCorpManagement extends Officer {

    public STARCorpManagement() {
        setStats(rollStats());
        initializeMedPack();
        setEquippedWeapon(generateSTARCorpWeapon());
        setName(generateSTARCorpName());
    }

    @Override
    public int[] rollStats() {
        int[] stats = new int[4];
        stats[0] = Dice.d6(4) + 50;
        stats[1] = Dice.d10(2) ;
        stats[2] = Dice.d10(1);
        return stats;
    }

    @Override
    public void attack(NPC player, PlayerCharacter opponent) {
        int roll = Dice.d12(1) + 1;
        switch (roll) {
            case 12, 11 -> Attack.d12Hit(player, opponent, roll);
            case 8, 7, 6 -> Attack.d10Hit(player, opponent, roll);
            case 5, 4, 3 -> Attack.d8Hit(player, opponent, roll);
            default -> Attack.regularHitOpponent(player, opponent, roll);

        }
    }

    @Override
    public void printDamageCapability() {

    }

    @Override
    public void initializeWeapons() {

    }

    @Override
    public String regularAttackToString() {
        return null;
    }


    public static void printClassDescription() {
        System.out.println("STAR Corp Officer");
    }

    @Override
    public void printImage() {

    }
}
