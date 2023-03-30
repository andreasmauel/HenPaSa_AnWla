package GameController;

import Characters.AbstractCharacter;
import util.Effect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EffectController {

    AbstractCharacter character;
    Map<Effect, Integer> effects;
    Boolean isSleepActive = false;

    public EffectController(AbstractCharacter character) {
        this.setCharacter(character);
        this.effects = new HashMap<>();
    }

    public AbstractCharacter getCharacter() {
        return character;
    }

    public void setCharacter(AbstractCharacter character) {
        this.character = character;
    }

    public void setEffects(Map<Effect, Integer> effects) {
        this.effects = effects;
    }

    public void triggerEffects() {
        for (Effect effect : getListOfMap(this.effects)) {
            switch(effect) {
                case DAMAGE -> this.character.setHealDamage(2, Effect.DAMAGE);
                case HEAL -> this.character.setHealDamage(2, Effect.HEAL);
                case SLEEP -> this.isSleepActive = true;
                case ARMOR -> this.character.setArmorClass(this.character.getArmorClass() + 2);
            }
        }
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

    public List<Effect> activeEffects() {
        Map<Effect, Integer> effectsCopy = new HashMap<Effect, Integer>(this.effects);
        decreaseDuration();
        return getListOfMap(effectsCopy);
    }

    public Map<Effect, Integer> getEffects() {
        return effects;
    }

    private void decreaseDuration() {
        for (Map.Entry<Effect, Integer> entry : this.effects.entrySet()) {
            Integer duration = entry.getValue();
            duration--;
            if (duration == 0) {
                switch (entry.getKey()) {
                    case ARMOR -> this.character.setArmorClass(this.character.getArmorClass() - 2);
                    case SLEEP -> this.isSleepActive = false;
                }
                this.effects.remove(entry.getKey());
            } else {
                entry.setValue(duration);
            }
        }
    }

    private List<Effect> getListOfMap(Map<Effect, Integer> effectsCopy) {
        List<Effect> activeEffects = new ArrayList<>();
        for (Map.Entry<Effect, Integer> entry : effectsCopy.entrySet()) {
            activeEffects.add(entry.getKey());
        }
        return activeEffects;
    }
}
