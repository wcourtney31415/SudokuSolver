package io.github.wcourtney31415.SudokuSolver;

import org.junit.Assert;
import org.junit.Test;

public class PuzzleTest {
	static int[][] testData = {
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
}
