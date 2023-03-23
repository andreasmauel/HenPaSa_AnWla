package equipment.armor;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmorTest {

    NoArmor noArmor = new NoArmor();
    LeatherArmor leatherArmor = new LeatherArmor();
    ChainMail chainMail = new ChainMail();
    Shield shield = new Shield();
    ScaleArmor scaleArmor = new ScaleArmor();


    @Test
    public void testArmorClassNoArmor() {
      assertEquals(0, noArmor.getArmorClass());
    }

    @Test
    public void testArmorClassChainArmor() {
        assertEquals(6, chainMail.getArmorClass());
    }

    @Test
    public void testArmorClassLeatherArmor() {
        assertEquals(1, leatherArmor.getArmorClass());
    }

    @Test
    public void testArmorClassShield() {
        assertEquals(2, shield.getArmorClass());
    }

    @Test
    public void testArmorClassScaleArmor() {
        assertEquals(4, scaleArmor.getArmorClass());
    }

}