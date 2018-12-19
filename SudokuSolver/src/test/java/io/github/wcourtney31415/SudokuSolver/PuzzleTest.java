package io.github.wcourtney31415.SudokuSolver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PuzzleTest {
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

	@Test
	public void testIdentityEquals() {
		Puzzle puzzle = new Puzzle(testData);
		Assert.assertTrue(puzzle.equals(puzzle));
	}

	@Test
	public void testSameDataEquals() {
		Puzzle puzzleA = new Puzzle(testData);
		Puzzle puzzleB = new Puzzle(testData);
		Assert.assertTrue(puzzleA.equals(puzzleB));
	}

	@Test
	public void testMutateDataNotEquals() {
		Puzzle puzzleA = new Puzzle(testData);
		testData[0][0] = 8;
		Puzzle puzzleB = new Puzzle(testData);
		Assert.assertFalse(puzzleA.equals(puzzleB));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThrowsExceptionIfRowsTooBig() {
		new Puzzle(new int[19][9]);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThrowsExceptionIfColumnsTooBig() {
		new Puzzle(new int[9][19]);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThrowsExceptionIfColumnsVaryInSize() {
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
		new Puzzle(testData);
	}

}
