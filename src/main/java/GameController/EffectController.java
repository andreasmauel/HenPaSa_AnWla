package GameController;

import Characters.AbstractCharacter;
import util.Effect;

import java.util.HashMap;
import java.util.Map;

public class EffectController {

    AbstractCharacter character;

    Map<Effect, Integer> effects;

    public EffectController(AbstractCharacter character) {
        this.effects = new HashMap<>();
        this.character = character;
    }

    public String triggerEffect(Effect effect, int stat) {

//        switch(effect) {
//            case DAMAGE -> this.character.setLife(this.character.getLife - stat );
//            case HEAL -> this.character.setLife(this.character.getLife + stat);
//            case SLEEP -> this.character.skipRounds(stat);
//            case ARMOR -> this.character.setCurrentArmorClass(this.character.getCurrentArmorClass() + stat);
//        }
        return null;
    }

    public void addEffect(Effect effect, int duration) {
        if (this.effects.get(effect) == null) {
            this.effects.put(effect, duration);
        } else {
            int x = this.effects.get(effect);
            x += duration;
            this.effects.replace(effect, x);
        }
    }

    public Map<Effect, Integer> activateEffects() {

        Map<Effect, Integer> effectsCopy = new HashMap<Effect, Integer>(this.effects);
        decreaseDuration();
        return effectsCopy;
    }

    public Map<Effect, Integer> getEffects() {
        return effects;
    }

    private void decreaseDuration() {
        for (Map.Entry<Effect, Integer> entry : this.effects.entrySet()) {
            Integer duration = entry.getValue();
            duration--;
            if (duration == 0) {
                this.effects.remove(entry.getKey());
            } else {
                entry.setValue(duration);
            }
        }
    }
}
