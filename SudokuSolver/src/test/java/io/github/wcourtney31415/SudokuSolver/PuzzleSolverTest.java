package io.github.wcourtney31415.SudokuSolver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PuzzleSolverTest {
	private int[][] testData;
	private ArrayPuzzle puzzle;
	private PuzzleSolver puzzleSolver;

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
		puzzle = new ArrayPuzzle(testData);
		puzzleSolver = new PuzzleSolver(puzzle);
	}

	@Test
	public void testIdentityEquals() {
		Assert.assertTrue(puzzleSolver.equals(puzzleSolver));
	}
	
	@Test
	public void testNotEqualToNull() {
		Assert.assertFalse(puzzleSolver.equals(null));
	}
	
}
