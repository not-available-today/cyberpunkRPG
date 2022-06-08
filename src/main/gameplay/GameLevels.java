package main.gameplay;

import characters.npc_classes.npc_subclasses.boss_subclasses.Boss;
import cli.GameConsole;
import main.auxilliary_tools.Narrator;

import java.util.Scanner;

public class GameLevels {

    public Game getGame() {
        return this.game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    private Game game;


    public void intro() {
        Scanner sc = new Scanner(System.in);
        setGame(new Game());
        getGame().selectDifficultyLevel();
        System.out.println();
        getGame().selectMainCharacter();
        System.out.println();

        getGame().populateLevelOneEnemiesArray();
        Narrator.printIntro();
        Narrator.setPlayerName(sc.next());
        Narrator.setPlayerWeapon(getGame().getMainCharacter().getEquippedWeapon().getName());
        getGame().getMainCharacter().setName(Narrator.getPlayerName());

    }

    public void partOne() {

        Narrator.printLevelZeroText();
        GameConsole.moveForward();
        getGame().getMainCharacter().printImage();
        GameConsole.moveForward();
        getGame().getMainCharacter().printPlayerInformation();
        GameConsole.moveForward();
        getGame().battle();
        getGame().getMainCharacter().levelUp();
        System.out.println();
        Narrator.printLevelOneText();
        System.out.println();
        getGame().battle();
        getGame().getMainCharacter().levelUp();
        System.out.println();
        getGame().oneBossBattleLoop(getGame());
        getGame().bossBattle((Boss) getGame().getOpponents().get(0), getGame().getMainCharacter());
    }

    public void partTwo() {
        getGame().populateLevelTwoEnemies();
        Narrator.printLevelTwoText();
        if (!getGame().solvePuzzle()) {
            //Boss sphinx = new Boss(100, 20, 50, 0, "Sphinx");
            Narrator.puzzleFailed();
            //game.bossBattle(sphinx, player);
        } else {
            Narrator.puzzleSolved();
            //player.setSpecialCounter(player.getSpecialCounter() + 1);
            System.out.println("You gained a special attack!");
        }
        getGame().oneBossBattleLoop(getGame());
    }

    public void partThree() {
        getGame().populateLevelThreeEnemies();
        Narrator.printLevelThreeText();
        System.out.println();
        getGame().twoBossBattleLoop(getGame());

    }

    public void partFour() {
        getGame().getOpponents().get(0).printImage();
        Narrator.printLevelFourText();
        getGame().bossBattle((Boss) getGame().getOpponents().get(0), getGame().getMainCharacter());
        Narrator.printVictoryMessage();
    }


}
