package characters.npc_classes;

import characters.GameCharacter;
import characters.player_characters.PlayerCharacter;
import main.auxilliary_tools.Dice;

public abstract class NPC extends GameCharacter {


    public NPC() {
    }

    @Override
    public void block(GameCharacter c) {
        System.out.println("Blocked the hit");

    }


    @Override
    public void printImage() {
    }

    public void printPlayerStats() {
        System.out.println("Enemy stats:");
        System.out.println(getName());
        System.out.println("Level: " + getLevel());
        System.out.println("Health: " + getHealth());
        System.out.println("Damage: " + dealDamage());

    }

    public final void setStats(int[] stats) {
        setHealth(stats[0]);
        setMaxHealth(stats[0]);
        setArmorClass(stats[1]);
        setLevel(stats[2]);

    }




    protected void disadvantagedHit(NPC player, PlayerCharacter opponent) {
        int damageTaken = opponent.getHealth() - (player.dealDamage() - Dice.d4(1));
        opponent.setHealth(damageTaken);
        printInflictedDamage(damageTaken);
    }

    protected void regularHit(NPC player, PlayerCharacter opponent) {
        int damageTaken = opponent.getHealth() - player.dealDamage();
        opponent.setHealth(damageTaken);
        printInflictedDamage(damageTaken);
    }

    protected void d4Hit(NPC player, PlayerCharacter opponent) {
        int damageTaken = opponent.getHealth() - player.dealDamage() + Dice.d4(1);
        opponent.setHealth(damageTaken);
        printInflictedDamage(damageTaken);
    }

    protected void d6Hit(NPC player, PlayerCharacter opponent) {
        int damageTaken = opponent.getHealth() - player.dealDamage() + Dice.d6(1);
        opponent.setHealth(damageTaken);
        printInflictedDamage(damageTaken);
    }

    protected void d8Hit(NPC player, PlayerCharacter opponent) {
        int damageTaken = opponent.getHealth() - player.dealDamage() + Dice.d8(1);
        opponent.setHealth(damageTaken);
        printInflictedDamage(damageTaken);
    }

    protected void d10Hit(NPC player, PlayerCharacter opponent){
        int damageTaken = opponent.getHealth() - player.dealDamage() + Dice.d10(1);
        opponent.setHealth(damageTaken);
        printInflictedDamage(damageTaken);
    }

    protected void criticalHit(NPC player, PlayerCharacter opponent) {
        int damageTaken = opponent.getHealth() - player.dealDamage() + Dice.d20();
        opponent.setHealth(damageTaken);
        printInflictedDamage(damageTaken);
    }

    protected  void d12Hit(NPC player, PlayerCharacter opponent){
        int damageTaken = opponent.getHealth() - player.dealDamage() + Dice.d12(1);
        opponent.setHealth(damageTaken);
        printInflictedDamage(damageTaken);
    }


}
