package characters.npc_classes.npc_subclasses.soldier_subclasses;

import characters.npc_classes.NPC;
import characters.player_characters.PlayerCharacter;
import main.auxilliary_tools.Dice;
import main.gameplay.Attack;

public class STARCorpOfficeDrone extends Soldier {

    public STARCorpOfficeDrone() {
        setStats(rollStats());
        initializeMedPack();
        setEquippedWeapon(generateSTARCorpWeapon());
        setName(generateSTARCorpName());
    }

    @Override
    public void initializeWeapons() {

    }

    @Override
    public void attack(NPC player, PlayerCharacter opponent) {
        int roll = Dice.d12(1) + 1;
        switch (roll) {
            case 12, 11 -> Attack.d8Hit(player, opponent, roll);
            case 8, 7, 6 -> Attack.d6Hit(player, opponent, roll);
            case 5, 4, 3 -> Attack.d4Hit(player, opponent, roll);
            default -> Attack.disadvantagedHitOpponent(player, opponent, roll);

        }
    }


    public static void printClassDescription() {
        System.out.println("STAR Corp. Drone");
    }
}
