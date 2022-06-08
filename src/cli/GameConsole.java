package cli;

import characters.player_characters.player_classes.commandos.BlackOpSoldier;
import characters.player_characters.player_classes.commandos.DemolitionExpert;
import characters.player_characters.player_classes.commandos.HeavyGunner;
import characters.player_characters.player_classes.metahumans.Biodroid;
import characters.player_characters.player_classes.metahumans.MKUltraAsset;
import characters.player_characters.player_classes.metahumans.Replicant;
import characters.player_characters.player_classes.operatives.ComputerEngineer;
import characters.player_characters.player_classes.operatives.IntelligenceOperative;
import characters.player_characters.player_classes.operatives.Sniper;
import main.auxilliary_tools.Narrator;
import main.gameplay.GameLevels;

import java.util.Scanner;

public class GameConsole {
    public GameConsole() {

    }

    public static void run() {
        Scanner mainScanner = new Scanner(System.in);

        while (true) {
            printTitleScreen();
            String selection = mainScanner.next();
            switch (selection) {
                case "p" -> start();
                case "c" -> printCredits();
                case "e" -> System.exit(0);
                default -> invalidChoice();
            }
        }
    }


    private static void start() {
        GameLevels game = new GameLevels();
        game.intro();
        game.partOne();
        game.partTwo();
        game.partThree();
        game.partFour();
    }


    public static void moveForward() {
        Scanner ok = new Scanner(System.in);
        System.out.println("\nPress (Enter) to continue");
        String selection = ok.nextLine();
        while (!selection.equals("")) {
            System.out.println("Press (Enter) to continue");
            selection = ok.nextLine();
        }
        System.out.println();
    }

    public static void invalidChoice() {
        System.out.println("Invalid choice");
    }

    public static void printTitleScreen() {
        System.out.println(Narrator.PURPLE +
                           "\n01000011 01011001 01000010 01000101 01010010 01010000 01010101 01001110 01001011 00110010 00110000 00110100 00110100 00110000 00110100 00110100 " +
                           "\n01000011 01011001 01000010 01000101 01010010 01010000 01010101 " + Narrator.ANSI_RESET + Narrator.CYAN + "01001110 01001011 00110010 00110000 00110100 00110100 00110000 00110100 00110100 " +
                           "\n01000011 01011001 01000010 01000101 01010010 01010000 01010101 01001110 01001011 00110010 00110000 00110100 00110100 00110000 00110100 00110100 " +
                           "\n01000011 01011001 01000010 01000101 01010010 01010000 01010101 " + Narrator.ANSI_RESET + Narrator.RED + "01001110 01001011 00110010 00110000 00110100 00110100 00110000 00110100 00110100 \n" +

                           "\s\s\s ,o888888o.  `8.`8888.      ,8' 8 888888888o   8 8888888888   8 888888888o.   8 888888888o   8 8888      88 b.             8 8 8888     ,88' \n" +
                           "   8888     `88. `8.`8888.    ,8'  8 8888    `88. 8 8888         8 8888    `88.  8 8888    `88. 8 8888      88 888o.          8 8 8888    ,88'  \n" +
                           ",8 8888       `8. `8.`8888.  ,8'   8 88" + Narrator.ANSI_RESET + Narrator.CYAN + "88     `88 8 8888         8 8888     `88  8 8888     `88 8 8888      88 Y88888o.       8 8 8888   ,88'   \n" +
                           "88 8888            `8.`8888.,8'    8 8888     ,88 8 8888         8 8888     ,88  8 8888     ,88 8 8888      88 .`Y8888" + Narrator.ANSI_RESET + Narrator.YELLOW + "88o.    8 8 8888  ,88'    \n" +
                           "88 8888             `8.`88888'     8 8888.   ,88' 8 888888888888 8 8888.   ,88'  8 8888.   ,88' 8 8888      88 8o. `Y888888o. 8 8 8888 ,88'     \n" +
                           "88 8888              `8. 88" + Narrator.ANSI_RESET + Narrator.PURPLE + "88      8 8888888888   8 8888         8 888888888P'   8 888888888P'  8 8888      88 8`Y8o. `Y88888o8 8 8888 88'      \n" +
                           "88 8888               `8 8888      8 8888    `88. 8 8888         8 8888`8b       8 8888         8 8888      88 8   `Y8o. `Y8888 8 888888<       \n" +
                           "`8 8888       .8'      8 8888      8 8888      88 8 8888         8 8888 `8b.     8 88" + Narrator.ANSI_RESET + Narrator.RED + "88         ` 8888     ,8P 8      `Y8o. `Y8 8 8888 `Y8.     \n" +
                           "   8888     ,88'       8 8888      8 8888    ,88' 8 8888         8 8888   `8b.   8 8888           8888   ,d8P  8         `Y8o.` 8 8888   `Y8.   \n" +
                           "    `8888888P'         8 8888      8 888888888P   8 888888888888 8 8888     `88. 8 8888            `Y88888P'   8            `Yo 8 8888     `Y8. " +
                           "\n01000011 01011001 01000010 01000101 01010010 01010000 01010101 01001110 01001011 00110010 00110000 00110100 00110100 00110000 00110100 00110100" +
                           "\n01000011 01011001" + Narrator.ANSI_RESET + Narrator.CYAN + " 01000010 01000101 01010010 01010000 01010101 01001110 01001011 00110010 00110000 00110100 00110100 00110000 00110100 00110100" +
                           "\n01000011 01011001 01000010 01000101 01010010 01010000 01010101 01001110 01001011 00110010 00110000 00110100 00110100 00110000 00110100 00110100" +
                           "\n01000011 01011001 01000010 01000101 01010010 01010000 01010101 01001110 01001011" + Narrator.ANSI_RESET + Narrator.RED + " 00110010 00110000 00110100 00110100 00110000 00110100 00110100" +
                           "\n01000011 01011001 01000010 01000101 01010010 01010000 01010101 01001110 01001011 00110010 00110000 00110100 00110100 00110000 00110100 00110100" +
                           "\n01000011 01011001" + Narrator.ANSI_RESET + Narrator.PURPLE + " 01000010 01000101 01010010 01010000 01010101 01001110 01001011 00110010 00110000 00110100 00110100 00110000 00110100 00110100" +
                           "\n01000011 01011001 01000010 01000101 01010010 01010000 01010101 01001110 01001011" + Narrator.ANSI_RESET + Narrator.YELLOW + " 00110010 00110000 00110100 00110100 00110000 00110100 00110100" +
                           "\n01000011 01011001 01000010 01000101 01010010 01010000 01010101 01001110 01001011 00110010 00110000 00110100 00110100 00110000 00110100 00110100" + Narrator.ANSI_RESET + "\n" +
                           "\n");
        printSubtitle();
        printMainMenu();
    }

    private static void printPattern() {
        System.out.println(Narrator.PURPLE +
                           " /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\ \\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/_" + Narrator.YELLOW + "_\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/_\n" +
                           "/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__\n" +
                           "\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\" + Narrator.RED + "__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\n" +
                           " \\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_\\ \\__/ /\\__/\\ \\__/ /\\__/\\ " + Narrator.CYAN + "\\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\_/\n" +
                           " /\\__/\\" + Narrator.PURPLE + " \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\ \\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/_\n" +
                           "/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__\n" +
                           "\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\n" +
                           " \\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\" + Narrator.YELLOW + "/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\_/\n" +
                           " /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\ \\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/_\n" +
                           "/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/ /\\__/\\" + Narrator.CYAN + " \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__\n" +
                           "\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\n" +
                           " \\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\_/\n" +
                           " /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\ \\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/_\n" +
                           "/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\" + Narrator.YELLOW + " \\__/ /\\__/\\ \\__/ /\\__/\\ \\__\n" +
                           "\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\n" +
                           " \\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/" + Narrator.RED + "_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\_/\n" +
                           " /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\ \\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/_\n" +
                           "/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/ " + Narrator.CYAN + " \\_\\/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__\n" +
                           "\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\n" +
                           " \\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\_/\n" +
                           " /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\__/ /\\__/\\ \\_ \\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/  \\_\\/__\\/_/");
    }

    public static void printSubtitle() {
        System.out.println(Narrator.YELLOW +
                           "\t\t\t                dP                    dP                 oo                                                       \n" +
                           "\t\t\t                88                    88                                                                          \n" +
                           "\t\t\t88d888b..d88" + Narrator.RED + "88b.88.d8888b.    88d888b.88.d8888b.dP    dP dP88d888b..d8888b.   .d8888b. .d8888b.88d8b.d8b..d8888b. \n" +
                           "\t\t\t88'  `8888'  `888888ooood8    88'  `888888'  `88" + Narrator.PURPLE + "88    88 8888'  `8888'  `88   88'  `88 88'  `8888'`88'`8888ooood8 \n" +
                           "\t\t\t88      88.  .888" + Narrator.CYAN + "888.  ...    88.  .888888.  .8888.  .88 8888    8888.  .88   88.  .88 88.  .8888  88  8888.  ... \n" +
                           "\t\t\tdP      `88888P'dP`88888P'    88Y888P'dP`88888P8`8888P88 dPdP    dP`8888P88   `888" + Narrator.RED + "8P88 `88888P8dP  dP  dP`88888P' \n" +
                           "\t\t\tooooooooooooooooooooooooooooo~88~oooooooooooooooo~~~~.88~ooooooooooo~~~~.88~ooo~~~~.88~ooooooooooooooooooooooooooo\n" +
                           "\t\t\t                              dP                 d8888P             d8888P     d8888P                             " + Narrator.ANSI_RESET);
    }


    public static void printMainMenu() {
        System.out.println(Narrator.CYAN + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\s(p) Play"
                           + "\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\s(c) Credits"
                           + "\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\s(e) Exit" + Narrator.ANSI_RESET);

    }

    public static void printDifficultyMenu() {
        System.out.println();
        System.out.println("Select difficulty level");
        System.out.println(Narrator.CYAN + "(E) Easy" + Narrator.ANSI_RESET);
        System.out.println(Narrator.PURPLE + "(M) Medium" + Narrator.ANSI_RESET);
        System.out.println(Narrator.RED + "(H) Hard" + Narrator.ANSI_RESET);
        System.out.println();
    }

    public static void printMainCharacterMenu() {
        System.out.println(Narrator.CYAN + "CHOOSE A BASE CLASS: " + Narrator.ANSI_RESET +
                           "\n(C) COMMANDOS" +
                           "\n(O) COVERT OPERATIVES" +
                           "\n(M) METAHUMANS\n" + Narrator.CYAN +
                           "\nPress one of the following buttons to learn" +
                           "\nmore about the base classes, You can return " +
                           "\nto this menu if you change your mind." + Narrator.ANSI_RESET);
        System.out.println();

    }

    public static void printCommandos() {
        System.out.println(Narrator.RED + "THE COMMANDOS:" + Narrator.ANSI_RESET);
        System.out.println();
        BlackOpSoldier.printClassDescription();
        moveForward();
        HeavyGunner.printClassDescription();
        moveForward();
        DemolitionExpert.printClassDescription();
        moveForward();
    }

    public static void printCovertOperatives() {
        System.out.println(Narrator.CYAN + "THE COVERT OPERATIVES:" + Narrator.ANSI_RESET);
        System.out.println();
        ComputerEngineer.printClassDescription();
        moveForward();
        IntelligenceOperative.printClassDescription();
        moveForward();
        Sniper.printClassDescription();
        moveForward();
    }

    public static void printMetahumans() {
        System.out.println(Narrator.PURPLE + "THE METAHUMANS:" + Narrator.ANSI_RESET);
        System.out.println();
        Biodroid.printClassDescription();
        moveForward();
        MKUltraAsset.printClassDescription();
        moveForward();
        Replicant.printClassDescription();
        moveForward();
    }

    public static void printActionMenu() {
        System.out.println("---Action Menu---");
        System.out.println("Press (1) to attack");
        System.out.println("Press (2) to attempt special ability");
        System.out.println("Press (3) to heal");
        System.out.println("Press (4) to block");
        System.out.println("Press (5) to view stats");
    }

    public static void printCredits() {
        System.out.println("made by " + Narrator.RED + "not_available_today" + Narrator.ANSI_RESET);
    }
}
