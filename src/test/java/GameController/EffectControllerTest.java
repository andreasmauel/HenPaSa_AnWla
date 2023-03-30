package GameController;

import Characters.AbstractCharacter;
import Characters.Player;
import Characters.Races.Dwarf;
import Characters.ViewDirection;
import Characters.classes.Thief;
import equipment.armor.ChainMail;
import org.junit.jupiter.api.Test;
import util.Attribute;
import util.Effect;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class EffectControllerTest {


    EffectController effectController = new EffectController(new Player("Dave", 10, 10, 10, 10, 10, new Dwarf(), 10, 10, new ChainMail(), true, ViewDirection.NORTH, new Thief()));

    private void createEffects() {

        effectController.effects.put(Effect.SLEEP, 3);
        effectController.effects.put(Effect.DAMAGE, 1);
    }

    @Test
    void addEffect() {

        effectController.addEffect(Effect.HIDE, 2);
        assertEquals(1, effectController.getEffects().size());

    }

    @Test
    void getEffects() {
        effectController.getEffects();
        assertEquals(0, effectController.getEffects().size());
    }

}