package characters.player_characters.player_classes.commandos;

import characters.npc_classes.NPC;
import characters.player_characters.PlayerCharacter;
import inventory.weapons.ballistic.Glock17;
import inventory.weapons.ballistic.M82A1SniperRile;
import main.auxilliary_tools.Dice;
import main.auxilliary_tools.Narrator;

public class BlackOpSoldier extends Commando {

    public BlackOpSoldier() {
        setMoveCounter(0);
        startStatSelection();
        selectAffiliation();
        setDamageMultiplier(3);
        selectPlayerColor();
        initializeMedPack();
        initializeWeapons();
        equipWeapon();
    }
    @Override
    public int[] rollStats() {
        int[] stats = new int[4];
        stats[0] = Dice.d12(2) + 40;
        stats[1] = Dice.d10(6) + 40;
        stats[2] = Dice.d4(1);
        stats[3] = Dice.d4(1);
        return stats;
    }

    @Override
    public void initializeWeapons() {
        M82A1SniperRile sniper = new M82A1SniperRile();
        Glock17 glock = new Glock17();
        setPrimaryWeapon(sniper);
        setSecondaryWeapon(glock);
    }

    @Override
    public void attack(NPC opponent, PlayerCharacter player) {
        super.attack(opponent, player);
    }

    @Override
    public void useSpecialAbility(NPC opponent, PlayerCharacter activePlayer) {

    }

    @Override
    public String regularAttackToString() {
        return "Grazing Shot.";
    }

    @Override
    public String specialMoveToString() {
        return "Wrath of War";
    }

    @Override
    public void printDamageCapability() {
        System.out.println("HitDie: " + getDamageMultiplier() + "d12");
    }


    public static void printClassDescription() {
        System.out.println(Narrator.RED + "BLACK OPS INFANTRYMAN:" + Narrator.ANSI_RESET +
                           "\nClassic special forces commando. Quick, and brutal.\n" +
                           "\nWeapons: M-4 Carbine/Glock-17" +
                           "\nInitial Damage Range: 3-36 " +
                           "\nInitial Health Range: 40-64");
    }

    @Override
    public void printImage() {
        System.out.println(


                """
                        8888o.o.o.o.ooooooo00||00oooooooooooooooooooo88o
                          88:8:8:8:8:888888800||0088888888888888888888888:
                          88:8:8:8:8:888888888888888888888888888888888888:
                         Y88:8:8:8:8:8888888888888888888oooooooooooooooP"
                          `"8oooooooooooooooooooooooooo""\"""\"""\\n   .88888888888.`:::      8
                           88888888888Yo   `` *   8
                          .88888888888 `oooooooood8o
                          88888888888'
                         .88888888888
                         88888888888'
                        .88888888888
                        98888888888'
                         ``""YY888P"""


               );
    }

    public static void printWeapon(){
        System.out.println("""
                                               ____________,
                   __                          \\__________||
                   )|      _____________________/o(____)o(__                _
                 _/_|_____/  ,_____________.________________Y_....-----====//
                |==========\\  , , , , , , , \\______________ --(  \\(  \\(  \\((
                            `----------------|________|[ )) ad_\\__)\\  \\\\  \\\\\\
                                              |      |  "" \\.__-'`".\\__)\\__)\\\\
                                              |______|      `""      ```""\"=,))
                """);
    }
}
