package characters.player_characters.player_classes.operatives;


import characters.npc_classes.NPC;
import characters.player_characters.PlayerCharacter;
import inventory.Inventory;
import inventory.weapons.ballistic.Glock17;
import inventory.weapons.ballistic.M82A1SniperRile;
import main.auxilliary_tools.Dice;
import main.auxilliary_tools.Narrator;

public class Sniper extends Operative {

    public Sniper() {
        setMoveCounter(0);
        startStatSelection();
        chooseAffiliation();
        setDamageMultiplier(8);
        selectPlayerColor();
        setPrimaryWeapon(new M82A1SniperRile());
        setSecondaryWeapon(new Glock17());
        setRucksack(new Inventory(this));
    }

    @Override
    public int[] rollStats() {
        int[] stats = new int[4];
        stats[0] = Dice.d12(4) + 4;
        stats[1] = Dice.d10(5) + 49;
        stats[2] = Dice.d6(1);
        stats[3] = Dice.d6(Dice.d4(1));
        return stats;
    }

    @Override
    public int dealDamage() {
        return Dice.d8(4) + getPrimaryWeapon().getDamage();
    }

    @Override
    public void useSpecialAbility(NPC opponent, PlayerCharacter activePlayer) {

    }

    @Override
    public String regularAttackToString() {
        return null;
    }

    @Override
    public String specialMoveToString() {
        return null;
    }

    @Override
    public void printDamageCapability() {
    }


    public static void printClassDescription() {
        System.out.println(Narrator.CYAN + "SNIPER" + Narrator.ANSI_RESET
                +
                "\nTop marksman in the world. One shot, one kill." +
                "\nWeapons:M82A1 Sniper Rifle/Glock 17" +
                "\nInitial Damage Range: 12-120 " +
                "\nInitial Health Range: 50-66");

    }

    @Override
    public void printImage() {
        System.out.println(
                """
                                                              ____    _     __     _    ____
                                                             |####`--|#|---|##|---|#|--'##|#|
                           _                                 |____,--|#|---|##|---|#|--.__|_|
                         _|#)_____________________________________,--'EEEEEEEEEEEEEE'_=-.
                        ((_____((_________________________,--------[JW](___(____(____(_==)        _________
                                                       .--|##,----o  o  o  o  o  o  o__|/`---,-,-'=========`=+==.
                                                       |##|_Y__,__.-._,__,  __,-.___/ J \\ .----.#############|##|
                                                       |##|              `-.|#|##|#|`===l##\\   _\\############|##|
                                                      =======-===l          |_|__|_|     \\##`-"__,=======.###|##|
                                                                                          \\__,"          '======'
                        """);
    }


    @Override
    public void crackLock() {

    }
}
