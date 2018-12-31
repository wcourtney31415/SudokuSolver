package io.github.wcourtney31415.SudokuSolver;

import java.util.Arrays;

public class Puzzle {
	
	
	private static final int GRID_SIZE = 9;
	
	private int[][] data;

	public Puzzle(int[][] grid) {
		performConstructorParameterValidations(grid);
		data = getCopyOf2dArray(grid);
	}

	private void performConstructorParameterValidations(int[][] grid) {
		validateUnderMaxRowLength(grid);
		validateAboveMinRowLength(grid);
		validateUnderMaxColumnLength(grid);
		validateAboveMinColumnLength(grid);
		validateConsistantRowLengths(grid);
	}

	private int[][] getCopyOf2dArray(int[][] grid) {
		int numOfRows = grid.length;
		int[][] myCoppiedArray = new int[numOfRows][];
		for (int row = 0; row < numOfRows; row++) {
			int[] rowContents = grid[row];
			myCoppiedArray[row] = Arrays.copyOf(rowContents, rowContents.length);
		}
		return myCoppiedArray;
	}

	private void validateConsistantRowLengths(int[][] grid) {
		int rowLength = grid[0].length;
		for (int i = 0; i < GRID_SIZE; i++) {
			if (rowLength != grid[i].length) {
				throw new IllegalArgumentException("Inconsistant row lengths.");
			}
		}
	}

	private void validateAboveMinColumnLength(int[][] grid) {
		if (grid[0].length < GRID_SIZE) {
			throw new IllegalArgumentException("Not enough row elements.");
		}
	}

	private void validateUnderMaxColumnLength(int[][] grid) {
		if (grid[0].length > GRID_SIZE) {
			throw new IllegalArgumentException("Too many column elements.");
		}
	}

	private void validateAboveMinRowLength(int[][] grid) {
		if (grid.length < GRID_SIZE) {
			throw new IllegalArgumentException("Not enough row elements.");
		}
	}

	private void validateUnderMaxRowLength(int[][] grid) {
		if (grid.length > GRID_SIZE) {
			throw new IllegalArgumentException("Too many row elements.");
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Puzzle) {
			Puzzle other = (Puzzle) obj;
			return Arrays.deepEquals(data, other.data);
		}
		return false;
	}
	
	private void validateCoordinateIsPositive(int coordinate) {
		if (coordinate < 0) {
			throw new IllegalArgumentException("Coordinate value must be positive.");
		}
	}
	
	private void validateCoordinateIsInScope(int coordinate) {
		if (coordinate > GRID_SIZE - 1) {
			throw new IllegalArgumentException("Coordinate value is outside the bounds of the puzzle.");
		}
	}
	
	private void validateCoordinates(int x, int y) {
		validateCoordinateIsPositive(x);
		validateCoordinateIsPositive(y);
		validateCoordinateIsInScope(x);
		validateCoordinateIsInScope(y);
	}
	
	/**
	 * Origin starts at (0, 0) 
	 */
	public int read(int x, int y) {
		validateCoordinates(x, y);
		return data[y][x];
	}

	public void submitAnswer(int x, int y, int value) {
		validateCoordinates(x, y);
		data[y][x] = value;
	}

}
