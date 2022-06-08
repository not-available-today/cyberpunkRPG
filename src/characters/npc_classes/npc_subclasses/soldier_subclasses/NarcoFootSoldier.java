package characters.npc_classes.npc_subclasses.soldier_subclasses;

import characters.npc_classes.NPC;
import characters.player_characters.PlayerCharacter;
import main.auxilliary_tools.Dice;
import main.gameplay.Attack;

public class NarcoFootSoldier extends Soldier {
    public NarcoFootSoldier() {
        setStats(rollStats());
        initializeMedPack();
        setEquippedWeapon(generateCartelWeapon());
        setName(generateCartelName());
    }

    @Override
    public void initializeWeapons() {

    }

    @Override
    public void attack(NPC player, PlayerCharacter opponent) {
        int roll = Dice.d10(1);
        switch (roll) {
            case 10, 9 -> Attack.d8Hit(player, opponent, roll);
            case 8, 7 -> Attack.d6Hit(player, opponent, roll);
            case 5, 4 -> Attack.d4Hit(player, opponent, roll);
            default -> Attack.disadvantagedHitOpponent(player, opponent, roll);

        }
    }



    public static void printClassDescription() {
        System.out.println("Cartel Foot Soldier");
    }

    @Override
    public void printImage() {
        System.out.println("""
                              +-'~`---------------------------------/\\--
                            ||""\"""\"""\"""\"""\"""\"""\"""\"""\"""\""" \\\\\\\\\\/~)
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
                                                                   _\\_\\__====~~~

                           
                """);

    }
}
