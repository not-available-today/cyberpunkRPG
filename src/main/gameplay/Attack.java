package main.gameplay;

import characters.GameCharacter;
import characters.npc_classes.NPC;
import characters.player_characters.PlayerCharacter;
import main.auxilliary_tools.Dice;

public class Attack {
   //region PossibleHits

    public static void disadvantagedHit(NPC opponent, PlayerCharacter player) {
        int damageTaken = opponent.getHealth() - (player.dealDamage() - Dice.d6(1));
        opponent.setHealth(damageTaken);
        player.printInflictedDamage(damageTaken);
    }

    public static void regularHit(NPC opponent, PlayerCharacter player) {
        int damageTaken = opponent.getHealth() - (player.dealDamage());
        opponent.setHealth(damageTaken);
        player.printInflictedDamage(damageTaken);
    }

    public static void d4Hit(NPC opponent, PlayerCharacter player) {
        int damageTaken = opponent.getHealth() - (player.dealDamage() + Dice.d4(1));
        opponent.setHealth(damageTaken);
        player.printInflictedDamage(damageTaken);
    }

    public static void d6Hit(NPC opponent, PlayerCharacter player) {
        int damageTaken = opponent.getHealth() - (player.dealDamage() + Dice.d6(1));
        opponent.setHealth(damageTaken);
        player.printInflictedDamage(damageTaken);
    }

    public static void d8Hit(NPC opponent, PlayerCharacter player) {
        int damageTaken = opponent.getHealth() - (player.dealDamage() + Dice.d8(1));
        opponent.setHealth(damageTaken);
        player.printInflictedDamage(damageTaken);
    }

    public static void d10Hit(NPC opponent, PlayerCharacter player) {
        int damageTaken = opponent.getHealth() - player.dealDamage() + Dice.d10(1);
        opponent.setHealth(damageTaken);
        player.printInflictedDamage(damageTaken);
    }

    public static void criticalHit(NPC opponent, PlayerCharacter player) {
        int damageTaken = opponent.getHealth() - (player.dealDamage() + Dice.d12(1));
        opponent.setHealth(damageTaken);
        player.printInflictedDamage(damageTaken);
    }

    public static void specialHit(NPC opponent, PlayerCharacter player) {
        player.setDamageMultiplier(player.getDamageMultiplier() * 2);
        int damageTaken = opponent.getHealth() - (player.dealDamage() + Dice.d20());
        opponent.setHealth(damageTaken);
        player.printInflictedDamage(damageTaken);
        player.setDamageMultiplier(player.getDamageMultiplier() / 2);
    }

    private static void depleteWeapon(GameCharacter player){
        String s = player.getPrimaryWeapon().toString();
        switch(s){
            case "Ballistic" ->{player.getPrimaryWeapon();}


        }    }
}