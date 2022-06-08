package characters.player_characters.player_classes.commandos;

import characters.npc_classes.NPC;
import characters.player_characters.PlayerCharacter;
import main.auxilliary_tools.Dice;
import main.gameplay.Attack;

public abstract class Commando extends PlayerCharacter {


    @Override
    public void attack(NPC opponent, PlayerCharacter player) {
        incrementMoveCounter();
        int roll = Dice.d20();
        switch (roll) {
            case 20, 19, 18 -> Attack.criticalHit(opponent, player, roll);
            case 17, 16 -> Attack.tremendousHit(opponent, player, roll);
            case 15, 14 -> Attack.greatHit(opponent, player, roll);
            case 13, 12 -> Attack.goodHit(opponent, player, roll);
            case 11, 10 -> Attack.regularHit(opponent, player, roll);
            case 9, 8 -> Attack.disadvantagedHit(opponent, player, roll);
            default -> printInflictedDamage(0);
        }
    }


    @Override
    public final int getHealthFormula() {
        return Dice.d4(1) + 8;
    }


    @Override
    public String baseClassToString() {
        return "Commando";
    }


    public static void printClassDescription() {
        System.out.println("""
                Commandos are front-line fighters. They pack a big punch,
                but are useless with anything high tech, or anything that requires\s
                patience. Commandos are supreme tacticians, fearless warriors, and\s
                explosive combatants.""");
    }
}
