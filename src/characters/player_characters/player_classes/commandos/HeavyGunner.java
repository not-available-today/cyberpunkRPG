package characters.player_characters.player_classes.commandos;

import characters.npc_classes.NPC;
import characters.player_characters.PlayerCharacter;
import inventory.Inventory;
import inventory.weapons.ballistic.M249SAW;
import inventory.weapons.explosives.PlasmaGrenade;
import main.auxilliary_tools.Dice;
import main.auxilliary_tools.Narrator;


public class HeavyGunner extends Commando {

    public HeavyGunner() {
        setMoveCounter(0);
        startStatSelection();
        chooseAffiliation();
        setDamageMultiplier(2);
        selectPlayerColor();
        setPrimaryWeapon(new M249SAW());
        setSecondaryWeapon(new PlasmaGrenade());
        setRucksack(new Inventory(this));
    }

    @Override
    public int dealDamage() {
       return Dice.d8(getDamageMultiplier())+getPrimaryWeapon().getDamage();
    }

    @Override
    public int[] rollStats() {
        int[] stats = new int[4];
        stats[0] = Dice.d6(3) + 45;
        stats[1] = Dice.d10(3) + 69;
        stats[2] = Dice.d4(1);
        stats[3] = Dice.d6(1);
        return stats;
    }

    @Override
    public void useSpecialAbility(NPC opponent, PlayerCharacter activePlayer) {

    }

    @Override
    public String regularAttackToString() {
        return "Suppressing Fire!";
    }

    @Override
    public String specialMoveToString() {
        return "Bullet Storm!";
    }

    @Override
    public void printDamageCapability() {
        System.out.println("Hit Die: " + getDamageMultiplier() + "d20");

    }

    public static void printClassDescription() {
        System.out.println(Narrator.RED + "HEAVY GUNNER" + Narrator.ANSI_RESET+
                "\nGiant hulk of a person, throws M249 around like a feather.\n" +
                "\nWeapons: M249SAW/PlasmaGrenade" +
                "\nInitial Damage Range: 3-36 " +
                "\nInitial Health Range: 45-63" );
    }

    @Override
    public void printImage() {
        System.out.println("""
                           _________
                         /'        /|
                        /         / |_
                       /         /  //|
                      /_________/  ////|
                     |   _ _    | 8o////|
                     | /'// )_  |   8///|
                     |/ // // ) |   8o///|
                     / // // //,|  /  8//|
                    / // // /// | /   8//|
                   / // // ///__|/    8//|
                  /.(_)// /// |       8///|
                 (_)' `(_)//| |       8////|___________
                (_) /_\\ (_)'| |        8///////////////
                (_) \\"/ (_)'|_|         8/////////////
                 (_)._.(_) d' Hb         8oooooooopb'
                   `(_)'  d'  H`b
                         d'   `b`b
                        d'     H `b
                       d'      `b `b
                      d'           `b
                     d'             `b

                ------------------------------------------------
                """);
    }
}

