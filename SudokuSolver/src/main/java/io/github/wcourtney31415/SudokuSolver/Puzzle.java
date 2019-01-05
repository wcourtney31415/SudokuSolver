package io.github.wcourtney31415.SudokuSolver;

import java.util.List;

public interface Puzzle {
	static final int PUZZLE_SIZE = 9;

	/**
	 * Origin starts at (0, 0)
	 */
	int read(int x, int y);

	void submitAnswer(int x, int y, int value);

	List<Integer> readRow(int y);

	List<Integer> readColumn(int x);
}
