package io.github.wcourtney31415.SudokuSolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayPuzzle implements Puzzle {

	private int[][] data;

	public ArrayPuzzle(int[][] data) {
		performConstructorParameterValidations(data);
		this.data = getCopyOf2dArray(data);
	}

	private void performConstructorParameterValidations(int[][] data) {
		validateUnderMaxRowLength(data);
		validateAboveMinRowLength(data);
		validateUnderMaxColumnLength(data);
		validateAboveMinColumnLength(data);
		validateConsistantRowLengths(data);
	}

	private int[][] getCopyOf2dArray(int[][] data) {
		int numOfRows = data.length;
		int[][] arrayCopy = new int[numOfRows][];
		for (int row = 0; row < numOfRows; row++) {
			int[] rowContents = data[row];
			arrayCopy[row] = Arrays.copyOf(rowContents, rowContents.length);
		}
		return arrayCopy;
	}

	private void validateConsistantRowLengths(int[][] data) {
		int rowLength = data[0].length;
		for (int i = 0; i < PUZZLE_SIZE; i++) {
			if (rowLength != data[i].length) {
				throw new IllegalArgumentException("Inconsistant row lengths.");
			}
		}
	}

	private void validateAboveMinColumnLength(int[][] data) {
		if (data[0].length < PUZZLE_SIZE) {
			throw new IllegalArgumentException("Not enough row elements.");
		}
	}

	private void validateUnderMaxColumnLength(int[][] data) {
		if (data[0].length > PUZZLE_SIZE) {
			throw new IllegalArgumentException("Too many column elements.");
		}
	}

	private void validateAboveMinRowLength(int[][] data) {
		if (data.length < PUZZLE_SIZE) {
			throw new IllegalArgumentException("Not enough row elements.");
		}
	}

	private void validateUnderMaxRowLength(int[][] data) {
		if (data.length > PUZZLE_SIZE) {
			throw new IllegalArgumentException("Too many row elements.");
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ArrayPuzzle) {
			ArrayPuzzle other = (ArrayPuzzle) obj;
			return Arrays.deepEquals(data, other.data);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Arrays.deepHashCode(data);
	}

	private void validateCoordinateIsPositive(int coordinate) {
		if (coordinate < 0) {
			throw new IllegalArgumentException("Coordinate value must be positive.");
		}
	}

	private void validateCoordinateIsInScope(int coordinate) {
		if (coordinate > PUZZLE_SIZE - 1) {
			throw new IllegalArgumentException("Coordinate value is outside the bounds of the puzzle.");
		}
	}

	private void validateCoordinates(int x, int y) {
		validateCoordinateIsPositive(x);
		validateCoordinateIsPositive(y);
		validateCoordinateIsInScope(x);
		validateCoordinateIsInScope(y);
	}

	@Override
	public int read(int x, int y) {
		validateCoordinates(x, y);
		return data[y][x];
	}

	@Override
	public void submitAnswer(int x, int y, int value) {
		validateCoordinates(x, y);
		data[y][x] = value;
	}

	@Override
	public List<Integer> readRow(int y) {
		validateCoordinateIsPositive(y);
		validateCoordinateIsInScope(y);
		List<Integer> row = new ArrayList<>();
		for (int i : data[y]) {
			row.add(Integer.valueOf(i));
		}
		return row;
	}
	
	@Override
	public List<Integer> readColumn(int x) {
		validateCoordinateIsPositive(x);
		validateCoordinateIsInScope(x);
		List<Integer> column = new ArrayList<>();
		for (int y = 0; y < PUZZLE_SIZE; y++) {
			int cell = read(x, y);
			column.add(Integer.valueOf(cell));
		}
		return column;
	}

}
