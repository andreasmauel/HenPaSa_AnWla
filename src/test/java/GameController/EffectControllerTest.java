package GameController;

import Characters.Player;
import Characters.Races.Dwarf;
import Characters.ViewDirection;
import Characters.classes.Thief;
import equipment.armor.ChainMail;
import equipment.weapon.Rapier;
import org.junit.jupiter.api.Test;
import util.Effect;

import static org.junit.jupiter.api.Assertions.*;

class EffectControllerTest {


    EffectController effectController = new EffectController(new Player(1, "Dave", 10, 10, 10, 10, 10, new Dwarf(), 10, 10, new ChainMail(), true, ViewDirection.NORTH, new Thief(), new Rapier()));

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