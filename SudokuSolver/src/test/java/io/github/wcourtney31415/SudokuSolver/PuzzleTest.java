package io.github.wcourtney31415.SudokuSolver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PuzzleTest {
	private int[][] testData;
	private Puzzle puzzle;

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
		puzzle = new Puzzle(testData);
	}

	@Test
	public void testIdentityEquals() {
		Assert.assertTrue(puzzle.equals(puzzle));
	}
	
	@Test
	public void testNotEqualToNull() {
		Assert.assertFalse(puzzle.equals(null));
	}
	
	@Test
	public void testSameDataEquals() {
		Puzzle otherPuzzle = new Puzzle(testData);
		Assert.assertTrue(puzzle.equals(otherPuzzle));
	}

	@Test
	public void testMutateDataNotEquals() {
		testData[0][0] = 8;
		Puzzle otherPuzzle = new Puzzle(testData);
		Assert.assertFalse(puzzle.equals(otherPuzzle));
	}
	
	@Test
	public void testHashCodeIdentityEquals() {
		Assert.assertEquals(puzzle.hashCode(), puzzle.hashCode());
	}
	
	@Test
	public void testHashCodeSameDataEquals() {
		Puzzle otherPuzzle = new Puzzle(testData);
		Assert.assertEquals(puzzle.hashCode(), otherPuzzle.hashCode());
	}
	
	@Test
	public void testHashCodeMutateDataNotEquals() {
		testData[0][0] = 8;
		Puzzle otherPuzzle = new Puzzle(testData);
		Assert.assertNotEquals(puzzle.hashCode(), otherPuzzle.hashCode());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testThrowsExceptionIfRowsTooBig() {
		new Puzzle(new int[19][9]);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThrowsExceptionIfRowsTooSmall() {
		new Puzzle(new int[3][9]);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThrowsExceptionIfColumnsTooBig() {
		new Puzzle(new int[9][19]);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThrowsExceptionIfColumnsTooSmall() {
		new Puzzle(new int[9][3]);
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
		new Puzzle(testData);
	}

	@Test
	public void testReadElement() {
		int read = puzzle.read(4, 2);
		Assert.assertEquals(read, 6);
	}

	@Test
	public void testSubmitAnswer() {
		int x = 3, y = 2;
		int read = puzzle.read(x, y);
		puzzle.submitAnswer(x, y, 4);
		Assert.assertNotEquals(read, puzzle.read(x, y));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThrowsExceptionIfReadMethodXIsNegative() {
		puzzle.read(-1, 4);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThrowsExceptionIfSubmitAnswerMethodXIsNegative() {
		puzzle.submitAnswer(-1, 4, 5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThrowsExceptionIfReadMethodYIsNegative() {
		puzzle.read(4, -1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThrowsExceptionIfSubmitAnswerMethodYIsNegative() {
		puzzle.submitAnswer(4, -1, 5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThrowsExceptionIfXIsLargerThanPuzzleWidth() {
		puzzle.read(9, 4);
	}
	
}
