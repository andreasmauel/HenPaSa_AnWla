package Characters.classes;

import spells.Spell;
import util.Attribute;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Mage extends Clazz{
    private ArrayList<Spell> spells;
    public int BaseLifePoints = 8;

    public Mage( Attribute secondMainAttribute) {
        super("Mage",8, 10, Attribute.INTELLIGENCE, secondMainAttribute, new ArrayList<Attribute>() {{
            add(Attribute.INTELLIGENCE);
            add(Attribute.WISDOM);
        }});
        this.spells = new ArrayList<>();
    }

    public void EnemyDifficultyDetermination(){

    }

    public void castSpell(){

    }

    public void showFuture(){

    }

    public void addSpell(Spell spell) {
        this.spells.add(spell);
    }

    public List<Spell> getSpells() {
        return this.spells;
    }
}
