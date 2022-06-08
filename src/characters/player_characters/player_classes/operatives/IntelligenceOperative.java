package characters.player_characters.player_classes.operatives;

import characters.npc_classes.NPC;
import characters.player_characters.PlayerCharacter;
import inventory.weapons.ballistic.WaltherPPK;
import inventory.weapons.melee.HuntingKnife;
import main.auxilliary_tools.Dice;
import main.auxilliary_tools.Narrator;
import main.gameplay.Attack;


public class IntelligenceOperative extends Operative {

    public IntelligenceOperative() {
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
        stats[0] = Dice.d8(2) + 35;
        stats[1] = Dice.d10(6) + 40;
        stats[2] = Dice.d4(1);
        stats[3] = Dice.d6(1);
        return stats;
    }


    @Override
    public void initializeWeapons() {
        setPrimaryWeapon(new WaltherPPK());
        setSecondaryWeapon(new HuntingKnife());
    }

    @Override
    public void attack(NPC opponent, PlayerCharacter player) {
        super.attack(opponent, player);
    }

    @Override
    public void useSpecialAbility(NPC opponent, PlayerCharacter player) {
        if (getMoveCounter() % 21 == 0) {
            Attack.specialHit(opponent, player);
            setMoveCounter(0);
        } else {
            System.out.println("Critical Hit Failed");

        }
    }

    @Override
    public void crackLock() {

    }

    @Override
    public String regularAttackToString() {
        return null;
    }

    @Override
    public String specialMoveToString() {
        return "The Lethal Goodbye";
    }

    @Override
    public void printDamageCapability() {
    }

    public static void printClassDescription() {
        System.out.println(Narrator.CYAN + "INTELLIGENCE OPERATIVE" + Narrator.ANSI_RESET +
                           "\nA man of many faces and names. " +
                           "\nDeadly effective, kills without hesitation.\n" +
                           "\nWeapons: Suppressed Walther PPK/Hunting Knife" +
                           "\nInitial Damage Range: 16-36 " +
                           "\nInitial Health Range: 35-51");
    }

    @Override
    public void printImage() {
        System.out.println("""
                 +-'~`---------------------------------/\\--
                ||""\"""\"""\"""\"""\"""\"""\"""\"""\"""\""" \\\\\\\\/~)
                ||                                  \\\\\\\\\\\\  \\/_
                 |~~~~~~~~-________________-_________________\\ ~--_
                 !---------|_________       ------~~~~~(--   )--~~
                                     \\ /~~~~\\~~\\   )--- \\_ /(
                                      ||     |  | \\   ()   \\\\
                                      \\\\____/_ / ()\\        \\\\
                                       `~~~~~~~~~-. \\        \\\\
                                                   \\ \\  <($)> \\\\
                                                    \\ \\        \\\\
                                                     \\ \\        \\\\
                                                      \\ \\        \\\\
                                                       \\ \\  ()    \\|
                                                       _\\_\\__====~~~\040
                """);
    }
}

