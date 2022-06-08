package characters.player_characters.player_classes.metahumans;

import characters.npc_classes.NPC;
import characters.player_characters.PlayerCharacter;
import inventory.weapons.explosives.PlasmaGrenade;
import inventory.weapons.tech.SonicBlast;
import main.auxilliary_tools.Dice;
import main.auxilliary_tools.Narrator;

public class Biodroid extends Metahuman {

    public Biodroid() {
        setMoveCounter(0);
        startStatSelection();
        selectAffiliation();
        setDamageMultiplier(5);
        selectPlayerColor();
        initializeMedPack();
        initializeWeapons();
        equipWeapon();
    }

    @Override
    public int[] rollStats() {
        int[] stats = new int[4];
        stats[0] = Dice.d8(5) + 5;
        stats[1] = Dice.d10(1) + 89;
        stats[2] = Dice.d8(1) + 1;
        stats[3] = Dice.d6(1);
        return stats;
    }

    @Override
    public void initializeWeapons() {
        setPrimaryWeapon(new SonicBlast());
        setSecondaryWeapon(new PlasmaGrenade());
    }

    @Override
    public void attack(NPC opponent, PlayerCharacter player) {
        super.attack(opponent, player);
    }

    @Override
    public String regularAttackToString() {
        return "Devastating blast";
    }

    @Override
    public String specialMoveToString() {
        return "The DEATHGRIP!";
    }

    @Override
    public void printDamageCapability() {

    }


    public static void printClassDescription() {
        System.out.println(Narrator.PURPLE + "BIO DROID:" + Narrator.ANSI_RESET +
                           "\nExperimental mixture of man and machine.\n" +
                           "\nWeapons: Sonic Blast/Plasma Grenade" +
                           "\nInitial Damage Range: 12-120 " +
                           "\nInitial Health Range: 50-66");
    }

    @Override
    public void printImage() {

    }
}
