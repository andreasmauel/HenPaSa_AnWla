package GameControllerTest;

import static org.junit.Assert.*;

import GameController.*;
import org.junit.Test;

public class GameControllerDiceTest {

	DiceFour four = new DiceFour();
	DiceEight eight = new DiceEight();
	DiceTen ten = new DiceTen();
	DiceTwenty twenty = new DiceTwenty();

	@Test
	public void testRollDiceNotOutOfNumberFieldDiceFour() {
		int test = four.rollDice();
		assertEquals(1|2|3|4, test);
	}

	@Test
	public void testRollDiceAdvantageDiceFour(){
		for(int i = 0; i < 100; i++) {
			int test = four.rollDiceAdvantage();
			assertEquals(1|2|3|4, test);
		}
	}

	@Test
	public void testRollDiceDisadvantageDiceFour(){
		int test = four.rollDiceDisadvantage();
		assertEquals(1|2|3|4, test);
	}

	@Test
	public void testCorrectSiteNumberDiceFour() {
		assertEquals(DiceSites.FOUR, four.getDiceSites());

	}



	@Test
	public void testRollDiceNotOutOfNumberFieldDiceEight() {
		int test = eight.rollDice();
		assertEquals(1|2|3|4|5|6|7|8, test);
	}

	@Test
	public void testRollDiceAdvantageDiceEight(){
		for(int i = 0; i < 100; i++) {
			int test = eight.rollDiceAdvantage();
			assertEquals(1|2|3|4|5|6|7|8, test);
		}
	}

	@Test
	public void testRollDiceDisadvantageDiceEight(){
		int test = eight.rollDiceDisadvantage();
		assertEquals(1|2|3|4|5|6|7|8, test);
	}

	@Test
	public void testCorrectSiteNumberDiceEight() {
		assertEquals(DiceSites.EIGHT, eight.getDiceSites());

	}



	@Test
	public void testRollDiceNotOutOfNumberFieldDiceTen() {
		int test = eight.rollDice();
		assertEquals(1|2|3|4|5|6|7|8|9|10, test);
	}

	@Test
	public void testRollDiceAdvantageDiceTen(){
		for(int i = 0; i < 100; i++) {
			int test = eight.rollDiceAdvantage();
			assertEquals(1|2|3|4|5|6|7|8|9|10, test);
		}
	}

	@Test
	public void testRollDiceDisadvantageDiceTen(){
		int test = eight.rollDiceDisadvantage();
		assertEquals(1|2|3|4|5|6|7|8|9|10, test);
	}

	@Test
	public void testCorrectSiteNumberDiceTen() {
		assertEquals(DiceSites.TEN, ten.getDiceSites());

	}



	@Test
	public void testRollDiceNotOutOfNumberFieldDiceTwenty() {
		int test = eight.rollDice();
		assertEquals(1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20, test);
	}

	@Test
	public void testRollDiceAdvantageDiceTwenty(){
		for(int i = 0; i < 100; i++) {
			int test = eight.rollDiceAdvantage();
			assertEquals(1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20, test);
		}
	}

	@Test
	public void testRollDiceDisadvantageDiceTwenty(){
		int test = eight.rollDiceDisadvantage();
		assertEquals(1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20, test);
	}

	@Test
	public void testCorrectSiteNumberDiceTwenty() {
		assertEquals(DiceSites.TWENTY, twenty.getDiceSites());

	}
}
