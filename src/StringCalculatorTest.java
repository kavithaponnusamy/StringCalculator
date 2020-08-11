import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
	
	@Test
	void returnZero() {
		String number="";
		String actual=StringCalculator.add(number);
		assertEquals("0",actual);
		
	}
	@Test
	void unknownNumberOfArguments() {
		String number="1,4,5.5,7";
		String actual=StringCalculator.add(number);
		assertEquals("17.5",actual);
	}
	@Test
	void newlineSeparator() {
		String number="1\n4,5.5,7";
		String actual=StringCalculator.add(number);
		assertEquals("6",actual);
	}
	

}
