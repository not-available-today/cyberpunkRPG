package characters.npc_classes.npc_subclasses.boss_subclasses;

import characters.npc_classes.NPC;
import characters.player_characters.*;
import inventory.power_ups.MedPack;

public abstract class Boss extends NPC {

    private MedPack medPack;

    @Override
    public void attack(NPC opponent, PlayerCharacter player) {
    }

    public MedPack getMedPack() {
        return medPack;
    }

    public void setMedPack(MedPack medPack) {
        this.medPack = medPack;
    }


    public void heal() {
        if (getMeds().getQuantity() > 0) {
            getMeds().setQuantity(getMeds().getQuantity()-1);
            setHealth(getHealth() + getMeds().getStrength());
            calculateHealthToAdd();
        }
    }

    @Override
    public void calculateHealthToAdd() {
        super.calculateHealthToAdd();
    }

    public void useSpecialAbility(NPC opponent, PlayerCharacter player) {
    }
}
