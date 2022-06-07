package characters.npc_classes.npc_subclasses.boss_subclasses;

import characters.npc_classes.Boss;
import characters.npc_classes.NPC;
import characters.player_characters.PlayerCharacter;
import main.auxilliary_tools.Dice;

public class ElPatron extends Boss {
    public ElPatron(int health, int attackPoints, int level, int specialCounter, String name) {

    }

    @Override
    public int dealDamage() {
        return 0;
    }

    @Override
    public void printDamageCapability() {

    }

    @Override
    public String regularAttackToString() {
        return null;
    }


    public void printClassDescription() {

    }

    @Override
    public int[] rollStats() {
        int[] stats = new int[3];
        stats[0] = Dice.d12(8) + 1;
        stats[1] = Dice.d10(6) + 40;
        stats[2] = Dice.d4(1);
        return stats;
    }

    @Override
    public void useSpecialAbility(NPC opponent, PlayerCharacter player) {
    }
}
