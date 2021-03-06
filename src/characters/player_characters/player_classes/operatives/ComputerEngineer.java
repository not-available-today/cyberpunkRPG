package characters.player_characters.player_classes.operatives;

import characters.npc_classes.NPC;
import characters.player_characters.PlayerCharacter;
import inventory.weapons.tech.DroneSwarm;
import inventory.weapons.tech.EMPCannon;
import main.auxilliary_tools.Dice;
import main.auxilliary_tools.Narrator;

public class ComputerEngineer extends Operative {

    public ComputerEngineer() {
        setMoveCounter(0);
        startStatSelection();
        selectAffiliation();
        setDamageMultiplier(6);
        selectPlayerColor();
        initializeMedPack();
        initializeWeapons();
        equipWeapon();
    }

    @Override
    public int[] rollStats() {
        int[] stats = new int[4];
        stats[0] = Dice.d10(2) + 30;
        stats[1] = Dice.d10(5) + 49;
        stats[2] = Dice.d6(1);
        stats[3] = Dice.d4(1);
        return stats;
    }


    @Override
    public void initializeWeapons() {
        setPrimaryWeapon(new DroneSwarm());
        setSecondaryWeapon(new EMPCannon());
    }

    @Override
    public void attack(NPC opponent, PlayerCharacter player) {
        super.attack(opponent, player);
    }

    @Override
    public void useSpecialAbility(NPC opponent, PlayerCharacter activePlayer) {

    }

    @Override
    public void crackLock() {

    }

    @Override
    public String regularAttackToString() {
        return "Electro-Magnetic Blast";
    }

    @Override
    public String specialMoveToString() {
        return "Death From Above";
    }

    @Override
    public void printDamageCapability() {

    }

    public static void printClassDescription() {
        System.out.println(Narrator.CYAN + "COMPUTER ENGINEER" + Narrator.ANSI_RESET +
                           "\nWorld renown engineer and robotics expert. " +
                           "\nGrade A strategist.\n" +
                           "\nWeapons: Drone Swarm/EMP Cannon" +
                           "\nInitial Damage Range: 16-36 " +
                           "\nInitial Health Range: 30-50");
    }


    @Override
    public void printImage() {
        System.out.println("""
                                  _____   ___\\n" +
                "      --[=]-                  [88[  O  ]88888]  o\\n" +
                " _______|_|              .-.   .-|-===-|------|b|      .o8\\n" +
                "|         |-------|------| |---| ||o  ||    | |88888888888\\n" +
                "|_________|-------|______| `---' ||___||    o `~~~~~~~8888\\n" +
                "`-------|_|-------|HHHHHHHHHHHHHH|-----|~~~________|_|8888\\n" +
                "       =[_]=                   |++-----+--|  )888  \\\\__8888\\n" +
                "                               ||         `==='88b    `888\\n" +
                "                                               888     `88\\n" +
                "                                               `88b     `8\\n" +
                "                                                d88P      `"+""".indent(16));

    }
}
