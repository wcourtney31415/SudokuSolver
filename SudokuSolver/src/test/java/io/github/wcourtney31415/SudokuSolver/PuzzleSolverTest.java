package io.github.wcourtney31415.SudokuSolver;

import org.junit.Assert;
import org.junit.Test;

public class PuzzleSolverTest {

	@Test
	public void testSolveOne() {
		int[][] testData;
		int[][] expectedData;
		Puzzle unsolvedPuzzle;
		PuzzleSolver puzzleSolver;

		testData = new int[][] {
				{ 7, 9, 8, 5, 2, 3, 4, 1, 0 },
				{ 6, 4, 2, 8, 7, 1, 9, 3, 5 },
				{ 1, 5, 3, 9, 6, 4, 7, 2, 8 },
				{ 8, 1, 4, 7, 3, 6, 5, 9, 2 },
				{ 5, 2, 7, 1, 8, 9, 3, 6, 4 },
				{ 3, 6, 9, 4, 5, 2, 8, 7, 1 },
				{ 9, 3, 5, 2, 1, 8, 6, 4, 7 },
				{ 2, 7, 6, 3, 4, 5, 1, 8, 9 },
				{ 4, 8, 1, 6, 9, 7, 2, 5, 3 }
		};
		expectedData = new int[][] {
				{ 7, 9, 8, 5, 2, 3, 4, 1, 6 },
				{ 6, 4, 2, 8, 7, 1, 9, 3, 5 },
				{ 1, 5, 3, 9, 6, 4, 7, 2, 8 },
				{ 8, 1, 4, 7, 3, 6, 5, 9, 2 },
				{ 5, 2, 7, 1, 8, 9, 3, 6, 4 },
				{ 3, 6, 9, 4, 5, 2, 8, 7, 1 },
				{ 9, 3, 5, 2, 1, 8, 6, 4, 7 },
				{ 2, 7, 6, 3, 4, 5, 1, 8, 9 },
				{ 4, 8, 1, 6, 9, 7, 2, 5, 3 }
		};
		unsolvedPuzzle = new ArrayPuzzle(testData);
		puzzleSolver = new EliminationPuzzleSolver();
		Puzzle actualResult = puzzleSolver.solve(unsolvedPuzzle);
		Puzzle expectedResult = new ArrayPuzzle(expectedData);
		Assert.assertEquals(expectedResult, actualResult);
	}

}
