package characters.npc_classes;

import characters.player_characters.PlayerCharacter;
import main.auxilliary_tools.Dice;

public abstract class Soldier extends NPC {
    public Soldier() {
        setStats(rollStats());
        setName("Soldier");
    }

    @Override
    public int dealDamage() {
        return Dice.d6(1) + (getLevel() * 2);
    }

    @Override
    public int[] rollStats() {
        int[] stats = new int[3];
        stats[0] = Dice.d4(2);
        stats[1] = Dice.d10(1) + 90;
        stats[2] = Dice.d4(1);
        return stats;
    }

    @Override
    public void attack(NPC player, PlayerCharacter opponent) {
        int roll = Dice.d8(1)+1;
        switch(roll){
            case 8,7,6 -> d6Hit(player,opponent);
            case 5,4,3 -> d4Hit(player,opponent);
            default -> printInflictedDamage(0);

        }
    }

    @Override
    public void printDamageCapability() {
        System.out.println("1d6 + " + getLevel() * 2);
    }

    @Override
    public String regularAttackToString() {
        return null;
    }


    public void printClassDescription() {

    }

    @Override
    public void printImage() {
    }
}
