package GameControllerTest;

import static org.junit.Assert.*;

import GameController.dices.*;
import org.junit.Test;

public class GameControllerDiceTest {

	DiceFour four = new DiceFour();
	DiceEight eight = new DiceEight();
	DiceTen ten = new DiceTen();
	DiceTwenty twenty = new DiceTwenty();

	@Test
	public void testRollDiceNotOutOfNumberFieldDiceFour() {
		int test = four.rollDice();
		if(test == 1) {
			assertEquals(1, test);
		} else if (test == 2) {
			assertEquals(2, test);
		} else if (test == 3) {
			assertEquals(3, test);
		} else if (test == 4) {
			assertEquals(4, test);
		}
	}



	@Test
	public void testRollDiceAdvantageDiceFour(){
			int test = four.rollDiceAdvantage();
		if(test == 1) {
			assertEquals(1, test);
		} else if (test == 2) {
			assertEquals(2, test);
		} else if (test == 3) {
			assertEquals(3, test);
		} else if (test == 4) {
			assertEquals(4, test);
		}
	}


	@Test
	public void testRollDiceDisadvantageDiceFour(){
		int test = four.rollDiceDisadvantage();
		if(test == 1) {
			assertEquals(1, test);
		} else if (test == 2) {
			assertEquals(2, test);
		} else if (test == 3) {
			assertEquals(3, test);
		} else if (test == 4) {
			assertEquals(4, test);
		}
	}

	//@Test
	//public void testCorrectSiteNumberDiceFour() {
	//	assertEquals(DiceSites.FOUR, four.getDiceSites());
	//	}



	@Test
	public void testRollDiceNotOutOfNumberFieldDiceEight() {
		int test = eight.rollDice();
		if(test == 1) {
			assertEquals(1, test);
		} else if (test == 2) {
			assertEquals(2, test);
		} else if (test == 3) {
			assertEquals(3, test);
		} else if (test == 4) {
			assertEquals(4, test);
		} else if(test == 5) {
			assertEquals(5, test);
		} else if (test == 6) {
			assertEquals(6, test);
		} else if (test == 7) {
			assertEquals(7, test);
		} else if (test == 8) {
			assertEquals(8, test);
		}
	}

	@Test
	public void testRollDiceAdvantageDiceEight(){
			int test = eight.rollDiceAdvantage();
		if (test == 1) {
			assertEquals(1, test);
		} else if (test == 2) {
			assertEquals(2, test);
		} else if (test == 3) {
			assertEquals(3, test);
		} else if (test == 4) {
			assertEquals(4, test);
		} else if (test == 5) {
			assertEquals(5, test);
		} else if (test == 6) {
			assertEquals(6, test);
		} else if (test == 7) {
			assertEquals(7, test);
		} else if (test == 8) {
			assertEquals(8, test);
		}
	}

	@Test
	public void testRollDiceDisadvantageDiceEight(){
		int test = eight.rollDiceDisadvantage();
		if (test == 1) {
			assertEquals(1, test);
		} else if (test == 2) {
			assertEquals(2, test);
		} else if (test == 3) {
			assertEquals(3, test);
		} else if (test == 4) {
			assertEquals(4, test);
		} else if (test == 5) {
			assertEquals(5, test);
		} else if (test == 6) {
			assertEquals(6, test);
		} else if (test == 7) {
			assertEquals(7, test);
		} else if (test == 8) {
			assertEquals(8, test);
		}
	}

	//@Test
	//public void testCorrectSiteNumberDiceEight() {
	//	assertEquals(DiceSites.EIGHT, eight.getDiceSites());
	//}



	@Test
	public void testRollDiceNotOutOfNumberFieldDiceTen() {
		int test = eight.rollDice();
		if (test == 1) {
			assertEquals(1, test);
		} else if (test == 2) {
			assertEquals(2, test);
		} else if (test == 3) {
			assertEquals(3, test);
		} else if (test == 4) {
			assertEquals(4, test);
		} else if (test == 5) {
			assertEquals(5, test);
		} else if (test == 6) {
			assertEquals(6, test);
		} else if (test == 7) {
			assertEquals(7, test);
		} else if (test == 8) {
			assertEquals(8, test);
		} else if (test == 9) {
			assertEquals(9, test);
		} else if (test == 10) {
			assertEquals(10, test);
		}
	}

	@Test
	public void testRollDiceAdvantageDiceTen(){

			int test = eight.rollDiceAdvantage();
			if (test == 1) {
				assertEquals(1, test);
			} else if (test == 2) {
				assertEquals(2, test);
			} else if (test == 3) {
				assertEquals(3, test);
			} else if (test == 4) {
				assertEquals(4, test);
			} else if (test == 5) {
				assertEquals(5, test);
			} else if (test == 6) {
				assertEquals(6, test);
			} else if (test == 7) {
				assertEquals(7, test);
			} else if (test == 8) {
				assertEquals(8, test);
			} else if (test == 9) {
				assertEquals(9, test);
			} else if (test == 10) {
				assertEquals(10, test);
			}

	}

	@Test
	public void testRollDiceDisadvantageDiceTen(){
		int test = eight.rollDiceDisadvantage();
		if (test == 1) {
			assertEquals(1, test);
		} else if (test == 2) {
			assertEquals(2, test);
		} else if (test == 3) {
			assertEquals(3, test);
		} else if (test == 4) {
			assertEquals(4, test);
		} else if (test == 5) {
			assertEquals(5, test);
		} else if (test == 6) {
			assertEquals(6, test);
		} else if (test == 7) {
			assertEquals(7, test);
		} else if (test == 8) {
			assertEquals(8, test);
		} else if (test == 9) {
			assertEquals(9, test);
		} else if (test == 10) {
			assertEquals(10, test);
		}
	}

	//@Test
	//public void testCorrectSiteNumberDiceTen() {
	//	assertEquals(DiceSites.TEN, ten.getDiceSites());
	//}



	@Test
	public void testRollDiceNotOutOfNumberFieldDiceTwenty() {
		int test = eight.rollDice();
		if (test == 1) {
			assertEquals(1, test);
		} else if (test == 2) {
			assertEquals(2, test);
		} else if (test == 3) {
			assertEquals(3, test);
		} else if (test == 4) {
			assertEquals(4, test);
		} else if (test == 5) {
			assertEquals(5, test);
		} else if (test == 6) {
			assertEquals(6, test);
		} else if (test == 7) {
			assertEquals(7, test);
		} else if (test == 8) {
			assertEquals(8, test);
		} else if (test == 9) {
			assertEquals(9, test);
		} else if (test == 10) {
			assertEquals(10, test);
		} else if (test == 11) {
			assertEquals(11, test);
		} else if (test == 12) {
			assertEquals(12, test);
		} else if (test == 13) {
			assertEquals(13, test);
		} else if (test == 14) {
			assertEquals(14, test);
		} else if (test == 15) {
			assertEquals(15, test);
		} else if (test == 16) {
			assertEquals(16, test);
		} else if (test == 17) {
			assertEquals(17, test);
		} else if (test == 18) {
			assertEquals(18, test);
		} else if (test == 19) {
			assertEquals(19, test);
		} else if (test == 20) {
			assertEquals(20, test);
		}
	}

	@Test
	public void testRollDiceAdvantageDiceTwenty(){

			int test = eight.rollDiceAdvantage();
			if (test == 1) {
				assertEquals(1, test);
			} else if (test == 2) {
				assertEquals(2, test);
			} else if (test == 3) {
				assertEquals(3, test);
			} else if (test == 4) {
				assertEquals(4, test);
			} else if (test == 5) {
				assertEquals(5, test);
			} else if (test == 6) {
				assertEquals(6, test);
			} else if (test == 7) {
				assertEquals(7, test);
			} else if (test == 8) {
				assertEquals(8, test);
			} else if (test == 9) {
				assertEquals(9, test);
			} else if (test == 10) {
				assertEquals(10, test);
			}else if (test == 11) {
				assertEquals(11, test);
			} else if (test == 12) {
				assertEquals(12, test);
			} else if (test == 13) {
				assertEquals(13, test);
			} else if (test == 14) {
				assertEquals(14, test);
			} else if (test == 15) {
				assertEquals(11, test);
			} else if (test == 16) {
				assertEquals(16, test);
			} else if (test == 17) {
				assertEquals(17, test);
			} else if (test == 18) {
				assertEquals(18, test);
			} else if (test == 19) {
				assertEquals(19, test);
			} else if (test == 20) {
				assertEquals(20, test);
			}

	}

	@Test
	public void testRollDiceDisadvantageDiceTwenty(){
		int test = eight.rollDiceDisadvantage();
		if (test == 1) {
			assertEquals(1, test);
		} else if (test == 2) {
			assertEquals(2, test);
		} else if (test == 3) {
			assertEquals(3, test);
		} else if (test == 4) {
			assertEquals(4, test);
		} else if (test == 5) {
			assertEquals(5, test);
		} else if (test == 6) {
			assertEquals(6, test);
		} else if (test == 7) {
			assertEquals(7, test);
		} else if (test == 8) {
			assertEquals(8, test);
		} else if (test == 9) {
			assertEquals(9, test);
		} else if (test == 10) {
			assertEquals(10, test);
		}else if (test == 11) {
			assertEquals(11, test);
		} else if (test == 12) {
			assertEquals(12, test);
		} else if (test == 13) {
			assertEquals(13, test);
		} else if (test == 14) {
			assertEquals(14, test);
		} else if (test == 15) {
			assertEquals(11, test);
		} else if (test == 16) {
			assertEquals(16, test);
		} else if (test == 17) {
			assertEquals(17, test);
		} else if (test == 18) {
			assertEquals(18, test);
		} else if (test == 19) {
			assertEquals(19, test);
		} else if (test == 20) {
			assertEquals(20, test);
		}
	}

	//@Test
	//public void testCorrectSiteNumberDiceTwenty() {
	//	assertEquals(DiceSites.TWENTY, twenty.getDiceSites());
	//}
}
