package io.github.wcourtney31415.SudokuSolver;

import org.junit.Before;
import org.junit.Test;

public class PuzzleValidatorTest {

	private int[][] testData;

	@Before
	public void setup() {
		testData = new int[][] {
				{ 7, 0, 0, 5, 0, 3, 0, 0, 0 },
				{ 0, 0, 2, 0, 7, 0, 9, 0, 0 },
				{ 0, 0, 0, 0, 6, 4, 7, 0, 0 },
				{ 8, 0, 4, 0, 0, 6, 5, 0, 2 },
				{ 5, 0, 0, 0, 0, 0, 0, 0, 4 },
				{ 3, 0, 9, 4, 0, 0, 8, 0, 1 },
				{ 0, 0, 5, 2, 1, 0, 0, 0, 0 },
				{ 0, 0, 6, 0, 4, 0, 1, 0, 0 },
				{ 0, 0, 0, 6, 0, 7, 0, 0, 3 }
		};
	}

	// Begin: Constructor Parameter Validation
	@Test(expected = IllegalArgumentException.class)
	public void testThrowsExceptionIfRowsTooBig() {
		PuzzleValidator.validateRawGrid(new int[19][9]);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThrowsExceptionIfRowsTooSmall() {
		PuzzleValidator.validateRawGrid(new int[3][9]);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThrowsExceptionIfColumnsTooBig() {
		PuzzleValidator.validateRawGrid(new int[9][19]);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThrowsExceptionIfColumnsTooSmall() {
		PuzzleValidator.validateRawGrid(new int[9][3]);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThrowsExceptionIfRowsVaryInSize() {
		testData = new int[][] {
				{ 7, 0, 0, 5, 0, 3, 0, 0, 0 },
				{ 0, 0, 2, 0, 0, 9, 0, 0 },
				{ 0, 0, 0, 0, 6, 4, 7, 0, 0 },
				{ 8, 0, 4, 0, 0, 6, 5, 0, 2 },
				{ 5, 0, 0, 0, 0, 0, 0, 0, 4 },
				{ 3, 0, 9, 0, 8, 0, 1 },
				{ 0, 0, 5, 2, 1, 0, 0, 0, 0 },
				{ 0, 0, 6, 0, 4, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 3 }
		};
		PuzzleValidator.validateRawGrid(testData);
	}
	// End: Constructor Parameter Validation
	
	// Begin: Coordinate Pair Validation
	
	// End: Coordinate Pair Validation
	
	
}
