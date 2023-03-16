package ArtifactTest;

import Artifact.*;
import Characters.AbstractCharacter;
import Characters.Monster;
import Characters.Races.Dwarf;
import Characters.ViewDirection;
import GameController.dices.DiceFour;
import equipment.armor.LeatherArmor;
import org.junit.Test;
import util.Effect;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArtifactTests {

	private ArrayList<Effect> effect;
	AbstractCharacter testMonster = new Monster("test", 5, 6, 7, 2, 3,
			new Dwarf(), 20, 2, 4, new LeatherArmor(), true, ViewDirection.NORTH, effect);

	Amulet amulet = new Amulet();
	Cloak cloak = new Cloak();
	HealingPotion healingPotion = new HealingPotion(5);
	InvisiblePotion invisiblePotion = new InvisiblePotion(5);
	KeyChest keyChest = new KeyChest(5);
	KeyDoor keyDoor = new KeyDoor(5);
	PoisonPotion poisonPotion = new PoisonPotion(5);
	Ring ring = new Ring();
	DiceFour dice = new DiceFour();

	@Test
	public void testAmulett() {
		assertEquals(6, amulet.use(testMonster));
	}

	@Test
	public void testCloak(){
		cloak.use(testMonster);
		assertEquals(false, testMonster.isVisible());
	}

	@Test
	public void testHealingPotion(){
		int healtini = testMonster.getLifepoints();
		assertEquals(testMonster.getLifepoints() > healtini, healingPotion.use(testMonster, dice));
	}

	@Test
	public void testInvisiblePotion(){
		invisiblePotion.use(testMonster);
		assertEquals(false, testMonster.isVisible());
	}

	@Test
	public void testKeyChest(){
		assertEquals(4, keyChest.use());
	}

	@Test
	public void testKeyDoor(){
		assertEquals(4, keyDoor.use());
	}

	@Test
	public void testPoisonPotion(){
		poisonPotion.use(testMonster);
		assertEquals(14, testMonster.getLifepoints());
	}

	@Test
	public void testRing(){
		assertTrue(true);
	}
}
