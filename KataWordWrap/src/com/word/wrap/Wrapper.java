package com.word.wrap;

/**
 * Wrapper is written to break a line by replacing the last space in a line with
 * a new line
 * 
 * @author Aakanksha M.
 *
 */
public class Wrapper {

	private static final String SPACE = " ";
	private static final String NEW_LINE = "\n";

	/**
	 * <code>wrap</code> is the only public static method in the class Wrapper which
	 * correctly breaks the line such that every segment is less than the
	 * columnNumber.
	 * <li>If there is a space, then identify the last space, break the line before
	 * the space and continue calling the same method with remaining line starting
	 * from the character after the space</li>
	 * <li>If there is a space at the column index, then append only the characters
	 * till the index of the space and continue calling the same method with
	 * remaining line starting from the character after the space`</li>
	 * <li>If there is no space, then continue calling the same method with
	 * remaining line starting from the index after the column number.</li>The
	 * function terminates when the input string's length is less than equal to the
	 * column number
	 * 
	 * @param inputString
	 * @param columnNumber
	 * @return String with proper break lines
	 *         <li>Every line contain characters less than or equal to the column
	 *         number provided</li>
	 *         <li>If there exists a space, then the last space is replaced with a
	 *         break line</li>
	 */
	public static String wrap(final String inputString, final int columnNumber) {
		if (inputString == null || inputString.length() == 0 || inputString.length() <= columnNumber) {
			return inputString;
		}

		int columnIndex = columnNumber;

		// If the column number is lesser than 1, then set the column number as 1
		if (columnNumber < 1) {
			columnIndex = 1;
		}

		int nextStringIndex = columnIndex;
		int subStringIndex = columnIndex;

		// Find the index of the last space
		int indexOfSpace = inputString.substring(0, columnIndex).lastIndexOf(SPACE);

		if (inputString.charAt(columnIndex) == ' ') {
			nextStringIndex = nextStringIndex + 1;
		} else if (indexOfSpace != -1) {
			subStringIndex = indexOfSpace;
			nextStringIndex = indexOfSpace + 1;
		}

		// add newline at the correct place and make recursive call with remaining
		// string
		return inputString.substring(0, subStringIndex) + NEW_LINE
				+ wrap(inputString.substring(nextStringIndex), columnIndex);

	}
}
