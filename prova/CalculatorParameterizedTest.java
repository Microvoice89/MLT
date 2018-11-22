package prova;


import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import prova.Calculator.Operator;



@RunWith(value = Parameterized.class)
public class CalculatorParameterizedTest {

	private double expected;
	private double a;
	private double b;
	private Operator operator;
	private static Calculator c;

	@BeforeClass
	public static void before() {
		c = new Calculator();
	}

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { 1, 2, Operator.ADD, 3 }, { 2, 4 , Operator.MULTIPLY, 8}});
	}

	public CalculatorParameterizedTest(double a, double b, Operator operator, double expected) {
		this.a = a;
		this.b = b;
		this.operator = operator;
		this.expected = expected;
	}

	@Test
	public void testOperator() {
		String failureMessage = "Failure when performing "+operator+" operation";
		assertEquals(failureMessage,c.performOperation(a, b, operator), expected, 0.0001);
	}

}
