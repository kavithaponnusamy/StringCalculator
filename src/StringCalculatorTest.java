import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
	
	@Test
	void emptyString() {
		String number="";
		String actual=StringCalculator.add(number);
		assertEquals("0",actual);
		
	}
	@Test
	void unknownAmountOfNumbers() {
		String number="1,4,5,5,7";
		String actual=StringCalculator.add(number);
		assertEquals("22",actual);
	}
	@Test
	void newlineSeparator() {
		String number="1\n2,3";
		String actual=StringCalculator.add(number);
		assertEquals("6",actual);
	}
	@Test
	void differentDelimiter() {
		String number="//;\n1;2";
		String actual=StringCalculator.add(number);
		assertEquals("3",actual);
	}
	@Test
	void negativesNumbers() {
		String number="1,2,-3,-4";
		String actual=StringCalculator.add(number);
		assertEquals("Negatives not allowed: -3,-4",actual);
	}
	@Test
	void greaterthan1000() {
		String number="1,1002,3,4";
		String actual=StringCalculator.add(number);
		assertEquals("8",actual);
	}
	@Test
	void delimiterAnyLength() {
		String number="//***\n1***2***3";
		String actual=StringCalculator.add(number);
		assertEquals("6",actual);
	}
	@Test
	void multipleDelimiters() {
		String number="//*%\n1*2%3";
		String actual=StringCalculator.add(number);
		assertEquals("6",actual);
	}
	@Test
	void missingNumberInLastPosition() {
		String number="1,2,3,4,5,";
		String actual=StringCalculator.add(number);
		assertEquals("Number expected but EOF found.",actual);
	}
	

}
