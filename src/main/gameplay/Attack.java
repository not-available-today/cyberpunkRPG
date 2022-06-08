package main.gameplay;

import characters.npc_classes.NPC;
import characters.player_characters.PlayerCharacter;
import main.auxilliary_tools.Dice;

public abstract class Attack {
    //region PossibleHits

    public static void disadvantagedHit(NPC opponent, PlayerCharacter player, int roll) {
        opponent.setHealth((opponent.getHealth()+opponent.getArmorClass()) - (player.dealDamage(roll) - Dice.d4(1)));
        player.printInflictedDamage((player.dealDamage(roll) - Dice.d4(1)));
    }

    public static void regularHit(NPC opponent, PlayerCharacter player, int roll) {
        opponent.setHealth((opponent.getHealth()+opponent.getArmorClass()) - (player.dealDamage(roll)));
        player.printInflictedDamage(player.dealDamage(roll));
    }

    public static void goodHit(NPC opponent, PlayerCharacter player, int roll) {
        opponent.setHealth((opponent.getHealth()+opponent.getArmorClass()) - (player.dealDamage(roll) + Dice.d4(1)));
        player.printInflictedDamage((player.dealDamage(roll) + Dice.d4(1)));
    }

    public static void greatHit(NPC opponent, PlayerCharacter player, int roll) {
        opponent.setHealth((opponent.getHealth()+opponent.getArmorClass()) - (player.dealDamage(roll) + Dice.d6(1)));
        player.printInflictedDamage((player.dealDamage(roll) + Dice.d6(1)));
    }

    public static void tremendousHit(NPC opponent, PlayerCharacter player, int roll) {
        opponent.setHealth((opponent.getHealth()+opponent.getArmorClass()) - (player.dealDamage(roll) + Dice.d8(1)));
        player.printInflictedDamage((player.dealDamage(roll) + Dice.d8(1)));
    }

    public static void fantasticHit(NPC opponent, PlayerCharacter player, int roll) {
        opponent.setHealth((opponent.getHealth()+opponent.getArmorClass()) - player.dealDamage(roll) + Dice.d10(1));
        player.printInflictedDamage(player.dealDamage(roll) + Dice.d10(1));
    }

    public static void criticalHit(NPC opponent, PlayerCharacter player, int roll) {
        opponent.setHealth((opponent.getHealth()+opponent.getArmorClass()) - (player.dealDamage(roll) + Dice.d12(1)));
        player.printInflictedDamage((player.dealDamage(roll) + Dice.d12(1)));
    }

    public static void specialHit(NPC opponent, PlayerCharacter player) {
        player.setDamageMultiplier(player.getDamageMultiplier() * 2);
        opponent.setHealth( (opponent.getHealth()+opponent.getArmorClass()) - ((player.getEquippedWeapon().getDamage() * player.getDamageMultiplier()) + Dice.d20()));
        player.printInflictedDamage((player.getEquippedWeapon().getDamage() * player.getDamageMultiplier()) + Dice.d20());
        player.setDamageMultiplier(player.getDamageMultiplier() / 2);
    }
    public static void disadvantagedHitOpponent(NPC player, PlayerCharacter opponent, int roll) {
        opponent.setHealth((opponent.getHealth()+opponent.getArmorClass()) - (player.dealDamage(roll) - Dice.d4(1)));
        player.printInflictedDamage(player.dealDamage(-Dice.d4(1)));
    }

    public static void regularHitOpponent(NPC player, PlayerCharacter opponent, int roll) {
        opponent.setHealth((opponent.getHealth()+opponent.getArmorClass())-player.dealDamage(roll));
        player.printInflictedDamage(player.dealDamage(roll));
    }

    public static void d4Hit(NPC player, PlayerCharacter opponent, int roll) {
        opponent.setHealth((opponent.getHealth()+opponent.getArmorClass()) - player.dealDamage(roll) + Dice.d4(1));
        player.printInflictedDamage(player.dealDamage(roll) + Dice.d4(1));
    }

    public static void d6Hit(NPC player, PlayerCharacter opponent, int roll) {
        opponent.setHealth((opponent.getHealth()+opponent.getArmorClass()) - player.dealDamage(roll) + Dice.d6(1));
        player.printInflictedDamage(player.dealDamage(roll) + Dice.d6(1));
    }

    public static void d8Hit(NPC player, PlayerCharacter opponent, int roll) {
        opponent.setHealth((opponent.getHealth()+opponent.getArmorClass()) - player.dealDamage(roll) + Dice.d8(1));
        player.printInflictedDamage(player.dealDamage(roll)+Dice.d8(1));
    }

    public static void d10Hit(NPC player, PlayerCharacter opponent, int roll) {
        opponent.setHealth((opponent.getHealth()+opponent.getArmorClass()) - player.dealDamage(roll) + Dice.d10(1));
        player.printInflictedDamage(player.dealDamage(roll)+Dice.d8(1));
    }

    public static void criticalHitOpponent(NPC player, PlayerCharacter opponent, int roll) {
        opponent.setHealth((opponent.getHealth()+opponent.getArmorClass()) - player.dealDamage(roll) + Dice.d20());
        player.printInflictedDamage(player.dealDamage(roll));
    }

    public static void d12Hit(NPC player, PlayerCharacter opponent, int roll) {
        opponent.setHealth((opponent.getHealth()+opponent.getArmorClass()) - player.dealDamage(roll) + Dice.d12(1));
        player.printInflictedDamage(player.dealDamage(roll)+Dice.d12(1));
    }


}