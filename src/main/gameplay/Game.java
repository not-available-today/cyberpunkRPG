package main.gameplay;

import characters.GameCharacter;
import characters.npc_classes.Boss;
import characters.npc_classes.NPC;
import characters.npc_classes.npc_subclasses.captain_subclasses.STARCorpManagement;
import characters.npc_classes.npc_subclasses.captain_subclasses.Sicario;
import characters.npc_classes.npc_subclasses.captain_subclasses.YakuzaLieutenant;
import characters.npc_classes.npc_subclasses.soldier_subclasses.NarcoFootSoldier;
import characters.npc_classes.npc_subclasses.soldier_subclasses.STARCorpOfficeDrone;
import characters.npc_classes.npc_subclasses.soldier_subclasses.YakuzaSoldier;
import characters.player_characters.PlayerCharacter;
import characters.player_characters.player_classes.commandos.BlackOpSoldier;
import characters.player_characters.player_classes.commandos.DemolitionExpert;
import characters.player_characters.player_classes.commandos.HeavyGunner;
import characters.player_characters.player_classes.metahumans.Biodroid;
import characters.player_characters.player_classes.metahumans.MKUltraAsset;
import characters.player_characters.player_classes.metahumans.Replicant;
import characters.player_characters.player_classes.operatives.ComputerEngineer;
import characters.player_characters.player_classes.operatives.IntelligenceOperative;
import characters.player_characters.player_classes.operatives.Sniper;
import cli.GameConsole;
import main.auxilliary_tools.Dice;
import main.auxilliary_tools.Narrator;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Game {
    private PlayerCharacter mainCharacter;
    private int difficultyLevel;
    private ArrayList<NPC> enemies;

    public enum affiliation {CORPORATE, PARAMILITARY, REVOLUTIONARY, OUTLAW, INDEPENDENT}

    public Game() {
        //populateEnemiesArray();
    }


    //region getters/setters
    public PlayerCharacter getMainCharacter() {
        return this.mainCharacter;
    }

    public void setMainCharacter(PlayerCharacter mainCharacter) {
        this.mainCharacter = mainCharacter;
    }

    public void setEnemies(ArrayList<NPC> enemies) {
        this.enemies = new ArrayList<>(enemies);
    }

    public ArrayList<NPC> getEnemies() {
        return this.enemies;
    }

    public int getDifficultyLevel() {
        return this.difficultyLevel;
    }
    //endregion

    //region enemyGeneration
    private NPC generateRandomEnemy() {
        NPC[] enemyTypes = new NPC[]{new YakuzaSoldier(), new YakuzaLieutenant(),
                new NarcoFootSoldier(), new Sicario(), new STARCorpOfficeDrone(), new STARCorpManagement()};
        return enemyTypes[Dice.d6(1) - 1];
    }

    public final void populateEnemiesArray() {
        int numberOfEnemies = (Dice.d12(2)) * getDifficultyLevel();
        setEnemies(new ArrayList<>(numberOfEnemies));
        for (int i = 0; i < numberOfEnemies; i++) {
            getEnemies().add(generateRandomEnemy());
        }
        //getEnemies().add(new Boss());
        System.out.println("Enemies count for level " + getEnemies().size());
    }
    //endregion


    //region examiners
    private void examineCommandos() {
        GameConsole.printCommandos();
        Scanner sc = new Scanner(System.in);
        String choice = "";
        while (!choice.equalsIgnoreCase("c") && !choice.equalsIgnoreCase("b")) {
            System.out.println("""
                    Would you like to choose from these or continue browsing?
                    (c) choose from COMMANDOS
                    (b) browse""");
            choice = sc.nextLine();
            switch (choice) {
                case "c" -> selectCommandoSubclass();
                case "b" -> selectMainCharacter();
                default -> GameConsole.invalidChoice();
            }
        }

    }

    private void examineCovertOperatives() {
        GameConsole.printCovertOperatives();
        Scanner sc = new Scanner(System.in);
        String choice = "";
        while (!choice.equalsIgnoreCase("c") && !choice.equalsIgnoreCase("b")) {
            System.out.println("""
                    Would you like to choose from these or continue browsing?
                    (c) choose from  COVERT OPERATIVES
                    (b) browse""");
            choice = sc.nextLine();
            switch (choice) {
                case "c" -> selectCovertOperativeSubclass();
                case "b" -> selectMainCharacter();
                default -> GameConsole.invalidChoice();
            }
        }

    }

    private void examineMetahumans() {
        GameConsole.printMetahumans();
        Scanner sc = new Scanner(System.in);
        String choice = "";
        while (!choice.equalsIgnoreCase("c") && !choice.equalsIgnoreCase("b")) {
            System.out.println("""
                    Would you like to choose from these or continue browsing?
                    (c) choose from  METAHUMANS
                    (b) browse""");
            choice = sc.nextLine();
            switch (choice) {
                case "c" -> selectMetahumanSubclass();
                case "b" -> selectMainCharacter();
                default -> GameConsole.invalidChoice();
            }
        }
    }

    //endregion

    //region selectors

    public void selectMainCharacter() {
        Scanner sc = new Scanner(System.in);
        while (getMainCharacter() == null) {
            GameConsole.printMainCharacterMenu();
            String choice = sc.nextLine();
            switch (choice.toUpperCase()) {
                case "C" -> examineCommandos();
                case "O" -> examineCovertOperatives();
                case "M" -> examineMetahumans();
                default -> GameConsole.invalidChoice();
            }

        }
    }

    public void selectCommandoSubclass() {
        Scanner sc = new Scanner(System.in);
        printCommandoSubclassSelection();
        String choice = sc.nextLine();
        switch (choice.toUpperCase()) {
            case "B" -> setMainCharacter(new BlackOpSoldier());
            case "D" -> setMainCharacter(new DemolitionExpert());
            case "H" -> setMainCharacter(new HeavyGunner());
            default -> selectCommandoSubclass();
        }
    }

    public void selectCovertOperativeSubclass() {
        printCovertOperativeSubclassSelection();
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        switch (choice.toUpperCase()) {
            case "S" -> setMainCharacter(new Sniper());
            case "I" -> setMainCharacter(new IntelligenceOperative());
            case "C" -> setMainCharacter(new ComputerEngineer());
            default -> selectCovertOperativeSubclass();
        }
    }

    public void selectMetahumanSubclass() {
        Scanner sc = new Scanner(System.in);
        printMetahumanSubclassSelection();
        String choice = sc.nextLine();
        switch (choice) {
            case "B" -> setMainCharacter(new Biodroid());
            case "M" -> setMainCharacter(new MKUltraAsset());
            case "R" -> setMainCharacter(new Replicant());
            default  -> selectCommandoSubclass();
        }
    }

    public void selectDifficultyLevel() {
        Scanner sc = new Scanner(System.in);
        String selection;
        while (this.difficultyLevel == 0) {
            GameConsole.printDifficultyMenu();
            selection = sc.nextLine();
            switch (selection) {
                case "e" -> this.difficultyLevel = 1;
                case "m" -> this.difficultyLevel = 2;
                case "h" -> this.difficultyLevel = 3;
                default -> GameConsole.invalidChoice();
            }
        }
        System.out.println("You've chosen the " + this.difficultyToString() + " way.");
    }

    public static void attemptSelection(PlayerCharacter player, NPC opponent) {
        GameConsole.printActionMenu();
        try {
            selectBattleAction(player, opponent);
        } catch (NoSuchElementException e) {
            System.out.println();
            GameConsole.invalidChoice();
            System.out.println();
            attemptSelection(player, opponent);
        }
    }

    public static void attemptSelection(Boss boss, PlayerCharacter player) {
        int selection = (int) ((Math.random() * 3) + 1);
        switch (selection) {
            case 1 -> boss.attack(boss, player);
            case 2 -> boss.useSpecialAbility(boss, player);
            case 3 -> boss.heal();
            default -> System.out.println("I WILL END YOUR LIFE\n");

        }
    }

    private static void selectBattleAction(PlayerCharacter player, NPC opponent) {
        int selection = 0;
        Scanner actionScanner = new Scanner(System.in);
        while (selection < 1 || selection > 5) {
            selection = actionScanner.nextInt();
            switch (selection) {
                case 1 -> player.attack(opponent, player);
                case 2 -> player.useSpecialAbility(opponent, player);
                case 3 -> player.heal();
                case 5 -> player.printPlayerStats();
                default -> GameConsole.invalidChoice();
            }
        }
    }

    //endregion

    public boolean solvePuzzle() {
        Scanner sc = new Scanner(System.in);
        Narrator.printPuzzle();
        String answer;
        boolean isCorrect = false;
        for (int i = 3; i > 0; i--) {
            System.out.println("Tell me your answer");
            answer = sc.nextLine();
            if (answer.equalsIgnoreCase("man")) {
                isCorrect = true;
                break;
            } else {
                System.out.println("You have " + i + " attempts left.");
            }
        }
        return isCorrect;
    }

    private void preBattle(NPC enemy) {
        enemy.printImage();
        GameConsole.moveForward();
        enemy.printPlayerStats();
        GameConsole.moveForward();
    }

    public void battle() {
        PlayerCharacter player = getMainCharacter();
        NPC enemy = getEnemies().get(0);
        preBattle(enemy);
        battleLoop(player, enemy);
    }

    private void battleLoop(PlayerCharacter player, NPC enemy) {
        while (true) {
            playerTurn(player, enemy);
            if (enemyHealthCheck(player, enemy)) {
                break;
            }
            enemyTurn(player, enemy);
            playerHealthCheck(player, enemy);
        }
    }

    private void playerHealthCheck(PlayerCharacter player, NPC enemy) {
        if (isBattleOver(enemy, player)) {
            announceResult(determineVictor(player, enemy));
        }
    }

    private boolean enemyHealthCheck(PlayerCharacter player, NPC enemy) {
        if (isBattleOver(enemy, player)) {
            announceResult(determineVictor(player, enemy));
            return true;
        }
        return false;
    }


    private void playerTurn(PlayerCharacter player, NPC enemy) {
        attemptSelection(player, enemy);
        printDamageReport(enemy);
        System.out.println();
    }

    private void enemyTurn(PlayerCharacter player, NPC enemy) {
        enemy.attack(enemy, player);
        printDamageReport(player);
        System.out.println();
    }

    private boolean isBattleOver(NPC n, PlayerCharacter p) {
        return n.getHealth() <= 0 || p.getHealth() <= 0;
    }

    private boolean isBattleOver(Boss b, PlayerCharacter p) {
        return b.getHealth() <= 0 || p.getHealth() <= 0;
    }

    public void bossBattle(Boss boss, PlayerCharacter player) {
        while (true) {
            attemptSelection(player, boss);
            printDamageReport(boss);
            if (isBattleOver(boss, player)) {
                announceResult(determineVictor(player, boss));
                GameConsole.moveForward();
                break;
            }
            attemptSelection(boss, player);
            printDamageReport(player);
            if (isBattleOver(boss, player)) {
                announceResult(determineVictor(player, boss));
                break;
            }
        }
    }

    public boolean isGameOver() {
        return this.getEnemies().size() == 0 || this.getMainCharacter().getHealth() == 0;
    }

    private GameCharacter determineVictor(GameCharacter p, GameCharacter o) {
        if (o.getHealth() <= 0) {
            getEnemies().remove(0);
            return p;
        } else
            return o;

    }

    public static void printDamageReport(GameCharacter g) {
        if (g.getHealth() < 0) {
            g.setHealth(0);
        }
        System.out.println(g.getName() + " has " + g.getHealth() + " Health Points left.");
    }

    public static void announceResult(GameCharacter g) {
        if (g instanceof PlayerCharacter) {
            System.out.println("You win!");
            GameConsole.moveForward();
        } else if (g instanceof NPC) {
            System.out.println("You are dead.");
            System.exit(0);
        }
    }

    public String difficultyToString() {
        switch (this.getDifficultyLevel()) {
            case 1 -> {
                return "Easy";
            }
            case 2 -> {
                return "Medium";
            }
            case 3 -> {
                return "Hard";
            }
            default -> {
                return "Invalid";
            }
        }
    }

    private void printCommandoSubclassSelection() {
        System.out.println("Choose your specialization:");
        System.out.println("(B)     BlackOps Soldier");
        System.out.println("(D)     Demolitions Expert");
        System.out.println("(H)     Heavy Gunner");

    }

    private void printCovertOperativeSubclassSelection() {
        System.out.println("Choose your specialization:");
        System.out.println("(I)     Intelligence Officer");
        System.out.println("(S)     Sniper");
        System.out.println("(C)     ComputerEngineer");
    }

    private void printMetahumanSubclassSelection() {
        System.out.println("Choose your augmentation:");
        System.out.println("(B)     Biodroid");
        System.out.println("(M)     MK-Ultra Asset");
        System.out.println("(R)     Replicant");
    }
}
