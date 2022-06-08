package characters.npc_classes.npc_subclasses.soldier_subclasses;

import characters.npc_classes.NPC;
import characters.player_characters.PlayerCharacter;
import main.auxilliary_tools.Dice;
import main.gameplay.Attack;

public class YakuzaSoldier extends Soldier {
    public YakuzaSoldier() {
        setStats(rollStats());
        initializeMedPack();
        setEquippedWeapon(generateYakuzaWeapon());
        setName(generateYakuzaName());
    }


    @Override
    public void initializeWeapons() {

    }

    @Override
    public void attack(NPC player, PlayerCharacter opponent) {
        int roll = Dice.d8(1) + 1;
        switch(roll){
            case 8,7  -> Attack.d6Hit(player, opponent,roll);
            case 6,5 -> Attack.d4Hit(player, opponent,roll);
            case 4,3 -> Attack.regularHitOpponent(player,opponent,roll);
            default -> Attack.disadvantagedHitOpponent(player, opponent,roll);

        }
    }


    public static void printClassDescription() {
        System.out.println("Yakuza Footsoldier");
    }
}
