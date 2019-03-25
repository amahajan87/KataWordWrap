package com.word.wrap;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class WrapperTest {
	@Test
	public void testEmptyString() {
		assertEquals("", Wrapper.wrap("", 10));
	}

	@Test
	public void testNullString() {
		assertEquals(null, Wrapper.wrap(null, 10));
	}

	@Test
	public void testStringWithLengthLessThanColumn() {
		assertEquals("Win It", Wrapper.wrap("Win It", 10));
	}

	@Test
	public void testStringWhenColumnLessThan1() {
		assertEquals("W\ni\nn\nI\nt", Wrapper.wrap("Win It", 0));
	}

	@Test
	public void testInputWithOneWord() {
		assertEquals("word\nword\nword\nword", Wrapper.wrap("wordwordwordword", 4));
	}

	@Test
	public void testInputWithTwoWords() {
		assertEquals("wordwor\ndword\nwordwor\ndword", Wrapper.wrap("wordwordword wordwordword", 7));
	}

	@Test
	public void testInputWithNWords() {
		assertEquals("wordwor\ndword\nwordwor\ndword\nwordwor\ndword",
				Wrapper.wrap("wordwordword wordwordword wordwordword", 7));
	}

	@Test
	public void testInputWithSpecialCharacters() {
		assertEquals("wordwor\ndword\nwordwor\n?dw!ord", Wrapper.wrap("wordwordword wordwor?dw!ord", 7));
	}
	
	@Test
	public void testInputWithSpaceAtColumnNumberIndex() {
		assertEquals("word\nword\nword\nword\nword\nword", Wrapper.wrap("wordword wordword wordword", 4));
	}


}
