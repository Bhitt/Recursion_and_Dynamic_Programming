/* 
	Solution 1 
	
	We know that each row, column, and diagonal must be used exactly once.

	Observe that since each row can only have one queen, we don't need to store our board as a full
	8x8 matrix. We only need a single array where column[r] = c indicates that row r has a queen at
	column c.
*/


/* 
	Time Complexity: 
	Space Complexity: 
*/

int GRID_SIZE = 8;

void placeQueens(int row, Integer[] columns, ArrayList<Integer>[] results){
	if (row == GRID_SIZE) { // found placement
		results.add(columns.clone());
	} else {
		for( int col = 0; col < GRID_SIZE; col++){
			if(checkValid(columns, row, col)){
				columns[row] = col; // Place queen
				placeQueens(row + 1, columns, results);
			}
		}
	}
}

/* 	Check if (row1, column1) is a valid spot for a queen by checking if there is a queen in the same
	column or diagonal. We don't need to check it for queens in the same row because the calling
	placeQueens only attempts to place one queen at a time. We know this row is empty */
boolean checkValid(Integer[] columns, int row1, int column1){
	for(int row2 = 0; row2 < row1; row2++){
		int column2 = columns[row2];
		/* check if (row2, column2) invalidates (row1, column1) as a queen spot */

		/* check if rows have a queen in the same column */
		if(column1 == column2){
			return false;
		}

		/* check diagonals: if the distance between the columns equals the distance between the rows,
		then they're in the same diagonal */
		int columnDistance = Math.abs(column2 - column1);

		/* row1 > row2, so no need for abs */
		int rowDistance = row1 - row2;
		if(columnDistance == rowDistance){
			return false;
		}
	}
	return true;
}