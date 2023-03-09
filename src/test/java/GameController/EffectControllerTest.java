package GameController;

import Characters.AbstractCharacter;
import Characters.Player;
import org.junit.jupiter.api.Test;
import util.Effect;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class EffectControllerTest {


    EffectController effectController = new EffectController();

    private void createEffects() {

        effectController.effects.put(Effect.SLEEP, 3);
        effectController.effects.put(Effect.DAMAGE, 1);
    }

    @Test
    void addEffect() {

        effectController.addEffect(Effect.HIDE, 2);
        assertEquals(3, effectController.getEffects().size());

    }

    @Test
    void getEffects() {
        effectController.getEffects();
        assertEquals(1, effectController.getEffects());
    }

}