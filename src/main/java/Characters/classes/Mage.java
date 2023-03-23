package Characters.classes;

import spells.Spell;
import util.Attribute;

import java.sql.Array;
import java.util.ArrayList;

public class Mage extends Clazz{
    private ArrayList<Spell> spells;
    public int BaseLifePoints = 8;

    public Mage(int baseArmorclass, Attribute mainAttribute, Attribute secondMainAttribute, ArrayList<Attribute> savingthrowAttribute) {
        super(8, 10, mainAttribute, secondMainAttribute, savingthrowAttribute);
    }

    public void EnemyDifficultyDetermination(){

    }

    public void castSpell(){

    }

    public void showFuture(){

    }
}
