package prova;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import prova.Calculator.Operator;

public class CalculatorTest {

	static Calculator calculator;
	static int testNumber;
	
	@BeforeClass
	static public void beforeAllTheOthers() {
		System.out.println("Questo metodo è invocato prima di tutti gli altri");
		calculator = new Calculator();
		testNumber = 0;
	}

	@After
	public void addResult() {
		testNumber++;
		System.out.println("Questo metodo viene richiamato dopo l'esecuzione del numero di test:" + testNumber);
	}

	@Before
	public void resetResult() {
		System.out.println("il suo metodo è invocato prima dell'esecuzione del numero di test: " + (testNumber + 1));
	}

	@AfterClass
	static public void printAllResults() {
		System.out.println("Questo metodo viene invocato dopo l'esecuzione di TUTTI i test\r\n" + 	"");
	}

	@Test
	public void testSum() {		
		System.out.println("test somma");
		assertEquals("Somma Fallita", 3.0, calculator.performOperation(1, 2, Operator.ADD), 0.001);
	}

	@Test
	public void testSubtraction() {	

		System.out.println("Sottrazione");
		assertEquals("Subtraction failure", -1.0, calculator.performOperation(1, 2, Operator.SUBTRACT), 0.001);
	}

	@Test
	public void testMultiplication() {

		System.out.println("test moltiplicazione");
		assertEquals("Multiplication failure", 2.0, calculator.performOperation(1, 2, Operator.MULTIPLY), 0.001);
	}

	@Test
	public void testDivision() {	

		System.out.println("testing division");
		assertEquals("Division failure",0.5, calculator.performOperation(1, 2, Operator.DIVIDE), 0.001);		
	}

	@Test(timeout = 100)
	public void testTimer() {

		System.out.println("timer");
		try {
			Thread.sleep(90);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Ignore("Testing @Ignore annotation")
	public void testSkipMe() {
	}

	@Test(expected = RuntimeException.class)
	public void testException() {
		System.out.println("exception");
		throw new RuntimeException();
	}




}


