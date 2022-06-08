package characters.npc_classes.npc_subclasses.captain_subclasses;

import characters.GameCharacter;
import characters.npc_classes.NPC;

public abstract class Officer extends NPC {
    public Officer() {
        this.setLevel((int) (Math.random() * 3) + 10);
        this.setHealth((this.getLevel() + 10));
        this.setName("Officer");

    }

    @Override
    public int takeDamage(GameCharacter c) {
        return super.takeDamage(c);
    }


}
