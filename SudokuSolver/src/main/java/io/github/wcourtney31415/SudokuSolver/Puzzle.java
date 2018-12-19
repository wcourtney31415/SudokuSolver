package io.github.wcourtney31415.SudokuSolver;

import java.util.Arrays;

public class Puzzle {

	private static final int MAX_ROW_LENGTH = 9;
	private static final int MAX_COLUMN_LENGTH = 9;
	
	private int[][] data;

	public Puzzle(int[][] testData) {
		if (testData.length > MAX_ROW_LENGTH) {
			throw new IllegalArgumentException("Row length too long.");
		}
		
		
		
		
		if (testData[0].length > MAX_COLUMN_LENGTH) {
			throw new IllegalArgumentException("Column length too big.");
		}
		
		
		
		
		int rowLength = testData[0].length;
		for(int i = 0; i < MAX_ROW_LENGTH; i++) {
			if (rowLength != testData[i].length) {
				throw new IllegalArgumentException("Inconsistant row lengths.");
			}
		}
		
		
		
		
		data = new int[testData.length][];
		for (int i = 0; i < testData.length; i++) {
			int[] innerArray = testData[i];
			data[i] = Arrays.copyOf(innerArray, innerArray.length);
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj.getClass().equals(getClass())) {
			Puzzle other = (Puzzle) obj;
			return Arrays.deepEquals(data, other.data);
		}
		return false;
	}

}
