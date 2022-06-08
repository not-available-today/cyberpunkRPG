package characters.player_characters.player_classes.metahumans;

import characters.npc_classes.NPC;
import characters.player_characters.PlayerCharacter;
import main.auxilliary_tools.Dice;
import main.gameplay.Attack;


public abstract class Metahuman extends PlayerCharacter {

    @Override
    public void attack(NPC opponent, PlayerCharacter player) {
        int roll = Dice.d20() + 1;
        switch (roll) {
            case 20 -> Attack.criticalHit(opponent, player, roll);
            case 19, 18 -> Attack.fantasticHit(opponent, player, roll);
            case 17, 16 -> Attack.greatHit(opponent, player, roll);
            case 15, 14 -> Attack.goodHit(opponent, player, roll);
            case 13, 12 -> Attack.regularHit(opponent, player, roll);
            case 11, 10 -> Attack.disadvantagedHit(opponent, player, roll);
            default -> printInflictedDamage(0);
        }
    }

    @Override
    public int getHealthFormula() {
        return (this.getLevel() + 15) * 2;
    }

    @Override
    public void useSpecialAbility(NPC opponent, PlayerCharacter activePlayer) {

    }

    @Override
    public String baseClassToString() {
        return "Metahuman";
    }

}
