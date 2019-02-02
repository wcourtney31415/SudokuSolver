package io.github.wcourtney31415.SudokuSolver;

public class PuzzleValidator {
	// Begin: Constructor Parameter Validation
	private static void validateConsistantRowLengths(int[][] data) {
		int rowLength = data[0].length;
		for (int i = 0; i < Puzzle.PUZZLE_SIZE; i++) {
			if (rowLength != data[i].length) {
				throw new IllegalArgumentException("Inconsistant row lengths.");
			}
		}
	}

	private static void validateAboveMinColumnLength(int[][] data) {
		if (data[0].length < Puzzle.PUZZLE_SIZE) {
			throw new IllegalArgumentException("Not enough row elements.");
		}
	}

	private static void validateUnderMaxColumnLength(int[][] data) {
		if (data[0].length > Puzzle.PUZZLE_SIZE) {
			throw new IllegalArgumentException("Too many column elements.");
		}
	}

	private static void validateAboveMinRowLength(int[][] data) {
		if (data.length < Puzzle.PUZZLE_SIZE) {
			throw new IllegalArgumentException("Not enough row elements.");
		}
	}

	private static void validateUnderMaxRowLength(int[][] data) {
		if (data.length > Puzzle.PUZZLE_SIZE) {
			throw new IllegalArgumentException("Too many row elements.");
		}
	}

	public static void validateRawGrid(int[][] data) {
		validateUnderMaxRowLength(data);
		validateAboveMinRowLength(data);
		validateUnderMaxColumnLength(data);
		validateAboveMinColumnLength(data);
		validateConsistantRowLengths(data);
	}
	// End: Constructor Parameter Validation

	// Begin: Validate Coordinates

	private static void validateCoordinateIsInScope(int coordinate) {
		if (coordinate > Puzzle.PUZZLE_SIZE - 1 || coordinate < 0) {
			throw new IllegalArgumentException("Coordinate value is outside the bounds of the puzzle.");
		}
	}

	public static void validateCoordinate(int c) {
		validateCoordinateIsInScope(c);
	}

	public static void validateCoordinates(int... c) {
		for (int i : c) {
			validateCoordinate(i);
		}
	}

	// End: Validate Coordinates

}
