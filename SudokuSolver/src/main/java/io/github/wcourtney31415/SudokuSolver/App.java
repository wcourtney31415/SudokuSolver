package io.github.wcourtney31415.SudokuSolver;

import java.util.List;
import java.util.ArrayList;

public class App {
	
	static int[][] puzzle = {
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
	
	public static void main(String[] args) {

		

		int columnIndex = 0;
		while (columnIndex < 9) {

			int rowIndex = 0;
			while (rowIndex < 9) {

				rowIndex++;
			}

			columnIndex++;
		}
		
		
		
	}
	
	public static List<Integer> getImpossibilitiesFromRow(int row) {
		List<Integer> retArray = new ArrayList<Integer>();
 		for (int i = 0; i < 9; i++) {
 			int element = puzzle[row][i];
			if (!retArray.contains(element)) {
				retArray.add(element);
			}
		}
		return retArray;
	}

}
