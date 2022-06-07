package characters.player_characters.player_classes.operatives;


import characters.npc_classes.NPC;
import characters.player_characters.PlayerCharacter;
import main.auxilliary_tools.Dice;
import main.gameplay.Attack;


public abstract class Operative extends PlayerCharacter {

    @Override
    public void attack(NPC opponent, PlayerCharacter player) {
        int roll = Dice.d20() + 1;
        switch (roll) {
            case 20 -> Attack.criticalHit(opponent, player);
            case 19, 18 -> Attack.d8Hit(opponent, player);
            case 17, 16 -> Attack.d6Hit(opponent, player);
            case 15, 14 -> Attack.d4Hit(opponent, player);
            case 13, 12 -> Attack.regularHit(opponent, player);
            case 11, 10 -> Attack.disadvantagedHit(opponent, player);
            default -> printInflictedDamage(0);

        }
    }

    @Override
    public  int getHealthFormula() {
        return (getLevel() + 20) * 2;
    }

    @Override
    public String baseClassToString() {
        return "COVERT OPERATIVE";
    }

    public abstract void crackLock();

}
