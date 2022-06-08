package characters.npc_classes.npc_subclasses.captain_subclasses;

import characters.npc_classes.NPC;
import characters.player_characters.PlayerCharacter;
import main.auxilliary_tools.Dice;
import main.gameplay.Attack;

public class Sicario extends Officer {

    public Sicario() {
        initializeMedPack();
        setEquippedWeapon(generateCartelWeapon());
        setName(generateCartelName());
    }

    @Override
    public int[] rollStats() {
        int[] stats = new int[4];
        stats[0] = Dice.d4(3) + 40;
        stats[1] = Dice.d10(3);
        stats[2] = Dice.d10(1);
        return stats;
    }


    @Override
    public void initializeWeapons() {

    }

    @Override
    public void attack(NPC player, PlayerCharacter opponent) {
        int roll = Dice.d10(1);
        switch (roll) {
            case 10, 9 -> Attack.d10Hit(player, opponent, roll);
            case 8, 7 -> Attack.d8Hit(player, opponent, roll);
            case 5, 4 -> Attack.d6Hit(player, opponent, roll);
            default -> Attack.regularHitOpponent(player, opponent, roll);

        }
    }

    @Override
    public void printDamageCapability() {

    }


    public static void printClassDescription() {
        System.out.println("Cartel Sicario");
    }

    @Override
    public void printImage() {

    }

    @Override
    public String regularAttackToString() {
        return null;
    }
}
