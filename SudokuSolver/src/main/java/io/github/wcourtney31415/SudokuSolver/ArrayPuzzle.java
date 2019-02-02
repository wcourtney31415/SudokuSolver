package io.github.wcourtney31415.SudokuSolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayPuzzle implements Puzzle {

	private int[][] data;
	
	public ArrayPuzzle(int[][] data) {
		PuzzleValidator.validateRawGrid(data);
		this.data = getCopyOf2dArray(data);
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


	@Override
	public int read(int x, int y) {
		PuzzleValidator.validateCoordinates(x, y);
		return data[y][x];
	}

	@Override
	public void submitAnswer(int x, int y, int value) {
		PuzzleValidator.validateCoordinates(x, y);
		data[y][x] = value;
	}

	@Override
	public List<Integer> readRow(int y) {
		PuzzleValidator.validateCoordinate(y);
		List<Integer> row = new ArrayList<>();
		for (int i : data[y]) {
			row.add(Integer.valueOf(i));
		}
		return row;
	}

	@Override
	public List<Integer> readColumn(int x) {
		PuzzleValidator.validateCoordinate(x);
		List<Integer> column = new ArrayList<>();
		for (int y = 0; y < PUZZLE_SIZE; y++) {
			int cell = read(x, y);
			column.add(Integer.valueOf(cell));
		}
		return column;
	}

}
