package io.github.wcourtney31415.SudokuSolver;

public class Puzzle {

	int[][] data;

	public Puzzle(int[][] testData) {
		data = testData;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj.getClass().equals(getClass())) {
			Puzzle other = (Puzzle) obj;
			return data.equals(other.data);
		}
		return false;
	}

}
