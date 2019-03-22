package com.word.wrap;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class WrapperTest {

	String inputString;
	int columnNumber;

	public WrapperTest(String inputString, int columnNumber) {
		this.inputString = inputString;
		this.columnNumber = columnNumber;
	}

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[] { null, 10 }, new Object[] { "", 10 }, new Object[] { " ", 10 },
				new Object[] { "word word", 10 });
	}

	@Test
	@Parameters(name = "data")
	public void testBasicStringConditionsReturningInputString() {
		assertEquals(Wrapper.wrap(inputString, columnNumber), inputString);
	}

}
