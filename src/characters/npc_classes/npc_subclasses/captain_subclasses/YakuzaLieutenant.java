package characters.npc_classes.npc_subclasses.captain_subclasses;

import characters.npc_classes.NPC;
import characters.player_characters.PlayerCharacter;
import main.auxilliary_tools.Dice;
import main.gameplay.Attack;

public class YakuzaLieutenant extends Officer {

    public YakuzaLieutenant() {
        setStats(rollStats());
        initializeMedPack();
        setEquippedWeapon(generateYakuzaWeapon());
        setName(generateYakuzaName());
    }

    @Override
    public int[] rollStats() {
        int[] stats = new int[4];
        stats[0] = Dice.d6(3)+45;
        stats[1] = Dice.d10(2);
        stats[2] = Dice.d10(1);
        return stats;
    }

    @Override
    public void attack(NPC player, PlayerCharacter opponent) {
        int roll = Dice.d8(1) + 1;
        switch (roll) {
            case 8, 7 -> Attack.d8Hit(player, opponent, roll);
            case 6, 5 -> Attack.d6Hit(player, opponent, roll);
            case 4, 3 -> Attack.d4Hit(player, opponent, roll);
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
        System.out.println("Yakuza Lieutenant");
    }

    @Override
    public void printImage() {

    }

}
