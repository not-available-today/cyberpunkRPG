package characters.npc_classes;

import characters.player_characters.*;

public abstract class Boss extends NPC {
    private int specialCounter;
    private int potions;


    public int getSpecialCounter() {
        return specialCounter;
    }

    public void setSpecialCounter(int specialCounter) {
        this.specialCounter = specialCounter;
    }

    public int getPotions() {
        return this.potions;
    }

    public void setPotions(int potions) {
        this.potions = potions;
    }

    @Override
    public void attack(NPC opponent, PlayerCharacter player) {
    }


    public void heal() {
        if (getPotions() > 0) {
            setPotions(getPotions() - 1);
            setHealth(getHealth() + 10);
            calculateHealthToAdd();
        }
    }

    @Override
    public void calculateHealthToAdd() {
        super.calculateHealthToAdd();
    }

    @Override
    public String toString() {
        return this.getName() + "the Dragon King";
    }

    public void useSpecialAbility(NPC opponent, PlayerCharacter player) {
    }

}
