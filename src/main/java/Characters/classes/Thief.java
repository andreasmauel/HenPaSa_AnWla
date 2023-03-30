package Characters.classes;

import util.Attribute;

import java.util.ArrayList;

public class Thief extends Clazz{
    private boolean isSneaking;

    public Thief() {
        super("Thief",8, 10, Attribute.DEXTERITY, Attribute.INTELLIGENCE, new ArrayList<Attribute>() {{
            add(Attribute.DEXTERITY);
            add(Attribute.INTELLIGENCE);
        }});
        this.isSneaking = false;
    }

    public void steal(){

    }

    public void sneak(){

    }
    public void lockPicking(){

    }
}
