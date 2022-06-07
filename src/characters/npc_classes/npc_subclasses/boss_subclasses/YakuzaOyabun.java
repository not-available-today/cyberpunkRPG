package characters.npc_classes.npc_subclasses.boss_subclasses;

import characters.npc_classes.Boss;
import characters.npc_classes.NPC;
import characters.player_characters.PlayerCharacter;

public class YakuzaOyabun extends Boss {

    public YakuzaOyabun(int health, int attackPoints, int level, int specialCounter, String name) {

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
        return new int[0];
    }

    public void useSpecialAbility(NPC opponent, PlayerCharacter player) {
    }
}
