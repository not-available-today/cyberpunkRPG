package characters.player_characters.player_classes.commandos;

import characters.npc_classes.NPC;
import characters.player_characters.PlayerCharacter;
import inventory.weapons.explosives.C4;
import inventory.weapons.explosives.FragGrenade;
import main.auxilliary_tools.Dice;
import main.auxilliary_tools.Narrator;

public class DemolitionExpert extends Commando {

    public DemolitionExpert() {
        setMoveCounter(0);
        startStatSelection();
        affiliationSelection();
        setDamageMultiplier(3);
        selectPlayerColor();
        initializeMedPack();
        initializeWeapons();
        equipWeapon();

    }

    @Override
    public int[] rollStats() {
        int[] stats = new int[4];
        stats[0] = Dice.d8(2) + 50;
        stats[1] = Dice.d10(3) + 69;
        stats[2] = Dice.d4(1);
        stats[3] = Dice.d4(1);
        return stats;
    }

    @Override
    public void attack(NPC opponent, PlayerCharacter player) {
        super.attack(opponent, player);
    }

    @Override
    public void useSpecialAbility(NPC opponent, PlayerCharacter activePlayer) {
    }

    @Override
    public void initializeWeapons() {
        setPrimaryWeapon(new C4());
        setSecondaryWeapon(new FragGrenade());
    }

    @Override
    public String regularAttackToString() {
        return "Microexplosives";
    }

    @Override
    public String specialMoveToString() {
        return "Carpet Bomb!";
    }

    @Override
    public void printDamageCapability() {
        System.out.println(dealDamage(Dice.d20() / 4));

    }

    public static void printClassDescription() {
        System.out.println(Narrator.RED + "DEMOLITIONS EXPERT:" + Narrator.ANSI_RESET +
                           "\nLoves to watch things explode." +
                           "\nWeapons: C4/FragGrenade" +
                           "\nInitial Damage Range: 12-120 " +
                           "\nInitial Health Range: 50-66");

    }

    @Override
    public void printImage() {
    }
}
