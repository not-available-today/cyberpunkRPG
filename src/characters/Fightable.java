package characters;

import characters.npc_classes.NPC;
import characters.player_characters.PlayerCharacter;

public interface Fightable {

        void attack(NPC opponent, PlayerCharacter activePlayer);

        int takeDamage(GameCharacter c);

        void block(GameCharacter c);

        int dealDamage();

}
