package characters.npc_classes;

import characters.GameCharacter;
import characters.player_characters.PlayerCharacter;
import main.auxilliary_tools.Dice;

public abstract class Officer extends NPC {
    public Officer() {
        this.setLevel((int) (Math.random() * 3) + 10);
        this.setHealth((this.getLevel() + 10));
        this.setName("Officer");

    }

    @Override
    public void attack(NPC player, PlayerCharacter opponent) {
        int roll = Dice.d8(1) + 1;
        switch(roll){
            case 8,7,6 -> d10Hit(player,opponent);
            case 5,4,3 -> d8Hit(player,opponent);
            default -> printInflictedDamage(0);

        }
    }

    public String toString() {
        return "Officer";
    }

    @Override
    public int takeDamage(GameCharacter c) {
        return super.takeDamage(c);
    }
}
