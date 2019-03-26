package com.word.wrap;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class WrapperTest {
	@Test
	public void testEmptyInputString() {
		assertEquals("", Wrapper.wrap("", 10));
	}

	@Test
	public void testNullInputString() {
		assertEquals(null, Wrapper.wrap(null, 10));
	}

	@Test
	public void testWithInputStringLengthLessThanColumn() {
		assertEquals("Win It", Wrapper.wrap("Win It", 10));
	}

	@Test
	public void testWhenColumnNumberLessThan1() {
		assertEquals("W\ni\nn\nI\nt", Wrapper.wrap("Win It", 0));
	}

	@Test
	public void testWithOneWordInInputString() {
		assertEquals("word\nword\nword\nword", Wrapper.wrap("wordwordwordword", 4));
	}

	@Test
	public void testWithTwoWordsInInputString() {
		assertEquals("wordwor\ndword\nwordwor\ndword", Wrapper.wrap("wordwordword wordwordword", 7));
	}

	@Test
	public void testWithMultipleWordsInInputString() {
		assertEquals("wordwor\ndword\nwordwor\ndword\nwordwor\ndword\nword\nword",
				Wrapper.wrap("wordwordword wordwordword wordwordword word word", 7));
	}

	@Test
	public void testWithSpecialCharactersInInputString() {
		assertEquals("wordwor\ndword\nwordwor\n?dw!ord", Wrapper.wrap("wordwordword wordwor?dw!ord", 7));
	}

	@Test
	public void testWithSpaceAtColumnNumberIndexInInputString() {
		assertEquals("word\nword\nword\nword\nword\nword", Wrapper.wrap("wordword wordword wordword", 4));
	}

}
