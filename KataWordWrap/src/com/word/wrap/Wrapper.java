package com.word.wrap;

public class Wrapper {

	public static String wrap(final String inputString, final int columnNumber) {

		if (inputString == null || inputString.length() == 0 || inputString.length() < columnNumber
				|| columnNumber < 1) {
			return inputString;
		}
		return "";
	}
}
