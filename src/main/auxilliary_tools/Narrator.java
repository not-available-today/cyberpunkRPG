package main.auxilliary_tools;

import cli.GameConsole;

public abstract class Narrator {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String RED = "\033[0;31m";
    public static final String PURPLE = "\033[0;35m";
    public static final String CYAN = "\033[0;36m";
    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";


    private static String playerName;
    private static String playerWeapon;

    public static String getPlayerName() {
        return playerName;
    }

    public static void setPlayerName(String name) {
        Narrator.playerName = name;
    }

    public static String getPlayerWeapon() {
        return playerWeapon;
    }

    public static void setPlayerWeapon(String playerWeapon) {
        Narrator.playerWeapon = playerWeapon;
    }

    public static void printIntro() {
        System.out.println("Drax: Hey you, finally awake. You should probably get out of that filth." +
                           "\nWhat the fuck happened to you? Who the fuck are you?");
        System.out.println("-----Select Name-----");
    }

    public static void printLevelZeroText() {
        System.out.println("\nDrax: Wait... you said " + getPlayerName() +
                           "\nAH shit, it is you. My man! We been lookin all over for yo ass!" +
                           "\n Ah shit they found us." +
                           "\n No time, better square up " + getPlayerWeapon() +
                           "\n...they're coming." +
                           "\nFuck these goons up real quick and I'll holla at ya.'");
    }

    public static void printLevelOneText() {
        System.out.println("Drax: Yeah, you're definitely who you say you are.\n");
        System.out.println(getPlayerName() + " : What the fuck do you want with me?\n");
        GameConsole.moveForward();
        System.out.println("Todd: A while ago, the Yakuza ran up in this neighborhood, and they haven't left since " +
                           "\npredicted that the time would come and he would be possessed by a man with the name \n"
                           + getPlayerName() + ", and then there would be peace. And you came, I knew it. It's not an easy road" +
                           "\n for you stranger, but I'll try to help you in any way I can. Keep your \n"
                           + getPlayerWeapon() + ", and follow this path, it will lead you to Phil Oxlong. " +
                           "\nGood luck");
        System.out.println();
        GameConsole.moveForward();

    }

    public static void printLevelTwoText() {
        System.out.println("Todd: You're quite skilled with that " + getPlayerWeapon() + "." +
                           "\nUp ahead lays the Sphinx. You must answer his riddle correctly to pass. ");
        System.out.println();
        GameConsole.moveForward();
    }

    public static void printLevelThreeText() {
        System.out.println("Todd: Well, now we just have to make it through to the top of the tower. " +
                           "\nTake out the rest of the guards around Oxlong's chambers and we will be one step closer to freedom");
        System.out.println();
        GameConsole.moveForward();

    }

    public static void printLevelFourText() {
        System.out.println("Phil Oxlong: Ah, I see you've managed to make it...I must say I am surprised you did..." +
                           "\nyou aren't particularly exceptional...");
        GameConsole.moveForward();
        System.out.println("Nevertheless, prepare to die!");
        GameConsole.moveForward();

    }

    public static void printVictoryMessage() {
        System.out.println("Todd: Congratulations, " + getPlayerName() + " you have freed Elden Square from the grip of the evil Phil Oxlong." +
                           "\nWe will forever be in your debt. Please always feel welcome here.");
        System.out.println(GREEN + """
                :::   :::  ::::::::  :::    :::      :::       :::  ::::::::  ::::    ::: :::\s
                :+:   :+: :+:    :+: :+:    :+:      :+:       :+: :+:    :+: :+:+:   :+: :+:\s
                 +:+ +:+  +:+    +:+ +:+    +:+      +:+       +:+ +:+    +:+ :+:+:+  +:+ +:+\s
                  +#++:   +#+    +:+ +#+    +:+      +#+  +:+  +#+ +#+    +:+ +#+ +:+ +#+ +#+\s
                   +#+    +#+    +#+ +#+    +#+      +#+ +#+#+ +#+ +#+    +#+ +#+  +#+#+# +#+\s
                   #+#    #+#    #+# #+#    #+#       #+#+# #+#+#  #+#    #+# #+#   #+#+#    \s
                   ###     ########   ########         ###   ###    ########  ###    #### ###\s""" + ANSI_RESET);
        GameConsole.moveForward();
    }

    public static void printPuzzle() {
        System.out.println();
        System.out.println(YELLOW + "\t\t------THE MYSTERY OF THE SPHINX-------" + ANSI_RESET);
        System.out.println(YELLOW + """
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⡶⠿⢝⡕⡦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠖⢉⣫⢢⡍⢩⢝⣾⣠⣇⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡠⢢⡞⠙⢧⣾⡿⣿⣾⣷⣿⠹⣿⣽⠏⢹⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣼⣇⠀⠱⡄⠘⣧⡂⣿⣿⡿⣿⣸⢯⡝⠀⡎⢹⡖⢦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⢰⣩⣙⣆⠘⡇⠀⣹⡀⣿⠹⣿⠏⠨⢿⠋⣼⡇⢠⠁⡞⠀⣠⣗⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⢀⣾⣿⣿⣿⣧⢸⠀⢹⣷⣿⡆⢹⣉⡹⣎⢠⡏⣧⣼⣰⡅⣠⣿⣿⠫⣢⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⣧⣻⣿⣿⣿⣿⠻⠀⠀⠉⠉⠁⠘⠛⠛⠁⠀⠀⠈⠛⠛⢸⣿⢿⣡⣴⣿⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⡴⠛⠿⣿⣿⣿⣇⣀⣤⡤⠶⠶⠶⠶⠶⠶⠶⠶⠤⢤⣤⣄⣈⣿⣿⡿⠿⠷⢦⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠠⣤⣤⣀⣿⣿⣿⢾⡟⣁⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣙⢿⡟⢹⣿⣇⣀⣀⣈⡆⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⣠⠁⣾⣿⣿⣟⣻⣼⠚⣕⠾⠿⢟⡶⣤⢀⡆⣴⣖⡿⠿⢟⡳⣧⣾⣽⣿⣿⣿⡅⢣⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⢰⣁⣀⠀⠀⠀⣿⢟⡾⠉⠙⠂⠀⠒⠘⠄⠉⠉⠰⠓⠤⠔⠚⠉⣿⣟⣷⠉⠉⠉⠉⠉⠱⠀⠀⠀⠀⠀
                ⠀⠀⠀⣸⠉⣿⣿⣿⣿⣿⡿⣽⡅⠀⠀⠀⠀⠀⢈⠀⠀⠀⠀⠀⠀⠀⢈⣾⣟⣷⣶⣶⣶⣶⡶⠺⡀⠀⠀⠀⠀
                ⠀⠀⡔⠛⠛⠛⠛⠛⠛⢿⣿⣮⣿⠢⠀⠀⠀⢤⠊⡀⠀⢶⠄⠀⠀⠀⢹⣭⣾⡿⠿⠿⠟⠛⠛⠒⠳⡀⠀⠀⠀
                ⠀⠀⡦⠤⠶⠶⠶⠶⠶⢾⣿⣿⣿⣧⠁⠀⠀⠀⣉⣳⣊⣀⠀⠀⠀⢠⣿⣿⣿⣤⠤⠤⠤⡤⡤⢶⣤⡇⠀⠀⠀
                ⢀⣰⡥⠶⠦⠤⠶⠦⠦⠼⢿⣿⣿⣿⣷⣄⠆⠙⠭⠭⠭⠝⠉⢘⣴⣿⣿⣿⣡⣀⣀⣀⣀⣠⣤⣤⣤⠧⡀⠀⠀
                ⠸⣶⣴⣤⡤⢤⠶⣶⣾⣿⣿⣿⣿⣿⣿⣿⣷⣄⠀⠀⠀⢠⠔⠁⣿⣿⣿⣿⣄⣀⣀⣠⣤⣄⣀⣤⣴⣶⡇⠀⠀
                ⢠⣿⣿⣄⠀⠒⠀⠀⠚⠚⠛⠛⠋⠻⣿⣿⣿⣿⡿⣳⡻⣿⡀⢀⣿⠟⠛⠛⠒⠒⠒⠒⠒⠒⠒⣻⣿⣭⠀⠀⠀
                ⢸⢋⠉⢿⣿⣍⣉⣉⣉⣉⣉⣿⣿⠀⠹⣿⣿⣿⡯⣺⡪⣿⡇⣼⡇⠀⣿⣋⣉⣉⣉⣁⢐⣲⣾⡿⠟⢻⠀⠀⠀
                ⢸⣿⣣⣴⠿⣿⣄⣀⠀⠀⣀⣀⣀⠀⢸⢝⢿⣿⣟⣼⣪⣿⡿⣫⡇⠀⣀⣀⣀⣀⣀⣀⣰⣿⣯⡀⣶⣾⠀⠀⠀
                ⠸⠛⢻⠓⠾⠛⣿⡤⠤⠤⠤⠺⠛⠀⢰⢝⢷⣽⣿⣼⡿⣟⣿⡿⢓⠰⠿⠧⠤⠤⠄⣼⡿⢷⠾⢿⠿⢿⠀⠀⠀
                ⠀⣩⣉⣏⣉⣉⣹⣧⠤⠤⠤⢤⣴⠀⢠⡳⡝⣮⣿⣡⣿⣗⠥⣪⠀⢠⣤⡤⠤⠄⢠⣿⠄⢨⠤⢾⠂⢸⠀⠀⠀
                ⠀⡦⠤⡧⠠⡆⠺⣿⡖⠒⠒⠚⠛⠀⠸⡳⢝⣦⣻⣿⣿⣟⣸⢻⠀⠘⠛⠒⠒⠤⡿⢎⣉⡄⢐⠸⠒⠈⠀⠀⠀
                ⠀⡗⢉⡇⣉⣏⣙⣯⣿⡶⠶⣶⣶⠀⢘⢯⣦⣙⣏⣿⣏⣸⣡⣾⠀⢰⡦⢤⡤⣼⣏⡗⣒⡏⠀⡇⠉⡇⠀⠀⠀
                ⠀⢱⣒⢲⡒⢢⠲⣗⢼⣟⠉⠉⠉⠀⢸⣮⡵⣆⣹⣉⣇⣸⡯⢼⠀⠈⠓⠒⢲⣟⣵⡩⢥⠠⢤⠭⢽⠀⠀⠀⠀
                ⠀⠈⡤⠬⡬⢝⣝⡾⣄⢿⣟⣛⣿⠀⢸⢮⡿⢄⣇⣸⣀⣿⠤⢿⠀⢰⡶⢶⣾⣩⠧⢒⣟⠬⡭⠅⡎⠀⠀⠀⠀
                ⠀⠀⢩⠩⢹⣕⠾⣯⡪⢻⢿⣿⣥⣤⣼⠇⣱⡸⣤⣇⣸⣈⣀⣿⣤⣬⣭⡿⡿⡓⣵⡧⣒⠝⠥⡒⠀⠀⠀⠀⠀
                ⠀⠀⠀⠻⡕⡹⢪⣔⡹⢳⢧⢿⣿⡿⡻⡆⣃⢿⢸⣆⡇⡄⣼⢤⡿⣿⢿⡯⢱⠺⢕⡨⢎⢌⠕⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠈⠒⢏⡜⡹⢳⢧⠧⡧⠧⢧⠐⢠⢸⢈⣇⡇⡇⡸⣼⢧⠮⡼⡅⡳⡛⡝⢎⠦⠃⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠈⠑⠃⠬⠼⠼⠼⠼⠼⠼⠼⠬⠇⠇⠧⠧⠤⠼⠤⠧⠧⠐⠚⠈⠀⢀⡝⢠⣶⠀⡶⢆⠄⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠘⠿⢛⣴⣿⠿⠷⠄""" + ANSI_RESET);
        GameConsole.moveForward();
        System.out.println("Sphinx: Hello, human. To continue down your path you must answer my riddle. " +
                           "\nI will give you three chances to answer correctly, if you fail, I will dine upon your corpse...");
        GameConsole.moveForward();
        System.out.println("What walks on four legs in the morning, two legs in the day, " +
                           "\nand three legs in the evening?");

    }

    public static void puzzleSolved() {
        System.out.println("Todd: WOW, you solved it!" +
                           "\nLet's get going before the Sphinx changes his mind");
        GameConsole.moveForward();

    }

    public static void puzzleFailed() {
        System.out.println("Todd: I hope you're ready for the fight of your life...");
    }
}
