package terning;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DiceTest {

	Dice terning; // vi deklarer et globalt terning objekt

	@Before
	public void setUp() throws Exception {
		terning = new Dice(); // vi instansiere objektet terning af klassen dice.

	}

	@After
	public void tearDown() throws Exception {

		terning = null; // vi sætter terning lig med null efter hver test af metoderne.

	}

	/*
	 * vi bruger switch statement og for loop til at teste det givne scenarie.
	 */
	@Test
	public void testRoll() {
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		int count5 = 0;
		int count6 = 0;
		int unknown = 0;

		for (int i = 0; i < 60000; i++) {
			int result = terning.roll();
			switch (result) {
			case 1:
				count1++;
				break;
			case 2:
				count2++;
				break;
			case 3:
				count3++;
				break;
			case 4:
				count4++;
				break;
			case 5:
				count5++;
				break;
			case 6:
				count6++;
				break;
			default:
				unknown++;
			}

		}

		System.out.println("1: " + count1);
		System.out.println("2: " + count2);
		System.out.println("3: " + count3);
		System.out.println("4: " + count4);
		System.out.println("5: " + count5);
		System.out.println("6: " + count6);
		System.out.println("unknown: " + unknown);

		/*
		 * Expected er den variabel som vi forventer. dvs. hver side af terningen skal fremkomme 10000 gange
		 * variant er vores afvigelsesvariabel, hvor vi forventer at der er en afvigelse på 400 +/-
		 */
		int expected = 10000;
		int variant = 400;

		/*
		 * vi har opstillet syv tests for at finde ud af om [1-6] fremkommer i det forventede interval
		 * og om der kommer nogle output, som vi ikke forventer. Vi forventede at terningen vil give os en værdi, 
		 * som er indenfor intervallet og det gør den også. Men det er klart, at der kommer en fejl fordi variansen 
		 * overskrider stort. Der er et for stort spring ved 1 og 6 da de kun fremkommer halvt så meget som de andre
		 * værdier. Værdierne fremkommer heller ikke 10000 gange. 
		 */
		assertEquals(expected, count1, variant);
		assertEquals(expected, count2, variant);
		assertEquals(expected, count3, variant);
		assertEquals(expected, count4, variant);
		assertEquals(expected, count5, variant);
		assertEquals(expected, count6, variant);
		assertEquals(0,unknown);
	}
	
	/*
	 * Da rollMultiple() metoden bruger roll() metoden testes den ikke
	 */
	@Test
	public void testRollMultiple() {

	}

}
