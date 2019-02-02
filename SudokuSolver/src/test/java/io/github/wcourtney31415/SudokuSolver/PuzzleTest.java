package io.github.wcourtney31415.SudokuSolver;

import java.util.List;

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
		puzzle = new ArrayPuzzle(testData);
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
		ArrayPuzzle otherPuzzle = new ArrayPuzzle(testData);
		Assert.assertTrue(puzzle.equals(otherPuzzle));
	}

	@Test
	public void testMutateDataNotEquals() {
		testData[0][0] = 8;
		ArrayPuzzle otherPuzzle = new ArrayPuzzle(testData);
		Assert.assertFalse(puzzle.equals(otherPuzzle));
	}

	@Test
	public void testHashCodeIdentityEquals() {
		Assert.assertEquals(puzzle.hashCode(), puzzle.hashCode());
	}

	@Test
	public void testHashCodeSameDataEquals() {
		ArrayPuzzle otherPuzzle = new ArrayPuzzle(testData);
		Assert.assertEquals(puzzle.hashCode(), otherPuzzle.hashCode());
	}

	@Test
	public void testHashCodeMutateDataNotEquals() {
		testData[0][0] = 8;
		ArrayPuzzle otherPuzzle = new ArrayPuzzle(testData);
		Assert.assertNotEquals(puzzle.hashCode(), otherPuzzle.hashCode());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValidationBeingRan() {
		new ArrayPuzzle(new int[19][9]);
	}

	@Test
	public void testSubmitAnswer() {
		int x = 3, y = 2;
		int read = puzzle.read(x, y);
		puzzle.submitAnswer(x, y, 4);
		Assert.assertNotEquals(read, puzzle.read(x, y));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThrowsExceptionIfSubmitAnswerMethodXIsNegative() {
		puzzle.submitAnswer(-1, 4, 5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThrowsExceptionIfSubmitAnswerMethodYIsNegative() {
		puzzle.submitAnswer(4, -1, 5);
	}

	@Test
	public void testReadElement() {
		int read = puzzle.read(4, 2);
		Assert.assertEquals(read, 6);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThrowsExceptionIfReadMethodXIsNegative() {
		puzzle.read(-1, 4);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThrowsExceptionIfReadMethodYIsNegative() {
		puzzle.read(4, -1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThrowsExceptionIfXIsLargerThanPuzzleWidth() {
		puzzle.read(9, 4);
	}

	@Test
	public void testReadRowNotNull() {
		List<Integer> list = puzzle.readRow(0);
		Assert.assertNotNull(list);
	}

	@Test
	public void testReadRowIsProperSize() {
		List<Integer> row = puzzle.readRow(2);
		Assert.assertEquals(Puzzle.PUZZLE_SIZE, row.size());
	}

	@Test
	public void testReadColumnNotNull() {
		List<Integer> list = puzzle.readColumn(1);
		Assert.assertNotNull(list);
	}

	@Test
	public void testReadColumnIsProperSize() {
		List<Integer> column = puzzle.readColumn(2);
		Assert.assertEquals(Puzzle.PUZZLE_SIZE, column.size());
	}

}
