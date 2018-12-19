package io.github.wcourtney31415.SudokuSolver;

import java.util.Arrays;

public class Puzzle {

	private static final int MAX_ROW_LENGTH = 9;
	private static final int MIN_ROW_LENGTH = 9;
	private static final int MAX_COLUMN_LENGTH = 9;
	private static final int MIN_COLUMN_LENGTH = 9;

	private int[][] data;

	public Puzzle(int[][] grid) {

		validateUnderMaxRowLength(grid);
		validateAboveMinRowLength(grid);
		validateUnderMaxColumnLength(grid);
		validateAboveMinColumnLength(grid);
		

		int rowLength = grid[0].length;
		for (int i = 0; i < MAX_ROW_LENGTH; i++) {
			if (rowLength != grid[i].length) {
				throw new IllegalArgumentException("Inconsistant row lengths.");
			}
		}

		data = new int[grid.length][];
		for (int i = 0; i < grid.length; i++) {
			int[] innerArray = grid[i];
			data[i] = Arrays.copyOf(innerArray, innerArray.length);
		}
	}

	private void validateAboveMinColumnLength(int[][] grid) {
		if (grid[0].length < MIN_COLUMN_LENGTH) {
			throw new IllegalArgumentException("Not enough row elements.");
		}		
	}

	private void validateUnderMaxColumnLength(int[][] grid) {
		if (grid[0].length > MAX_COLUMN_LENGTH) {
			throw new IllegalArgumentException("Too many column elements.");
		}
	}

	private void validateAboveMinRowLength(int[][] grid) {
		if (grid.length < MIN_ROW_LENGTH) {
			throw new IllegalArgumentException("Not enough row elements.");
		}
	}

	private void validateUnderMaxRowLength(int[][] grid) {
		if (grid.length > MAX_ROW_LENGTH) {
			throw new IllegalArgumentException("Too many row elements.");
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
