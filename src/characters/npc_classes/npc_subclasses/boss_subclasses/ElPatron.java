package characters.npc_classes.npc_subclasses.boss_subclasses;

import characters.npc_classes.NPC;
import characters.player_characters.PlayerCharacter;
import main.auxilliary_tools.Dice;
import main.gameplay.Attack;

public class ElPatron extends Boss {

    public ElPatron() {
        initializeMedPack();
        setEquippedWeapon(generateCartelWeapon());
        setName(generateCartelName());
    }

    @Override
    public void initializeWeapons() {

    }

    @Override
    public int[] rollStats() {
        int[] stats = new int[3];
        stats[0] = Dice.d12(2) +60;
        stats[1] = Dice.d10(3) ;
        stats[2] = Dice.d8(2);
        return stats;
    }

    @Override
    public void attack(NPC player, PlayerCharacter opponent) {
        int roll = Dice.d10(1);
        switch (roll) {
            case 10, 9 -> Attack.d12Hit(player, opponent, roll);
            case 8, 7 -> Attack.d10Hit(player, opponent, roll);
            case 5, 4 -> Attack.d8Hit(player, opponent, roll);
            default -> Attack.d6Hit(player, opponent, roll);

        }
    }

    @Override
    public void printDamageCapability() {

    }

    @Override
    public String regularAttackToString() {
        return null;
    }



    public static void printClassDescription() {
        System.out.println("Cartel Boss");
    }

    @Override
    public void useSpecialAbility(NPC opponent, PlayerCharacter player) {
    }
}
