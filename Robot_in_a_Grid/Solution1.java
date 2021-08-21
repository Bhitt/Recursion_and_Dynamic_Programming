/* 
	Solution 1 
	
	To find a path from the origin, we work backwards from the end. Starting from the last cell, we 
	try to find a path to each of its adjacent cells. Continue recursively from here and cache results
	to avoid duplicate work.
*/


/* 
	Time Complexity: O(rc), where r is row length and c is column length
	Space Complexity: 
*/

ArrayList<Point> getPath(boolean[][] maze){
	if(maze == null || maze.length == 0) return null;
	ArrayList<Point> path = new ArrayList<Point>();
	HashSet<Point> failedPoints = new HashSet<Point>();
	if(getPath(maze, maze.length - 1, maze[0].length - 1, path, failedPoints)){
		return path;
	}
	return null;
}

boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path, HashSet<Point> failedPoints){
	/* If out of bounds or not available, return */
	if(col < 0 || row < 0 || !maze[row][col]){
		return false;
	}

	Point p = new Point(row, col);

	/* If we've already visited this cell, return */
	if(failedPoints.contains(p)){
		return false;
	}

	boolean isAtOrigin = (row == 0) && (col == 0);

	/* if there's a path from start to my current location, add my location */
	if(isAtOrigin || getPath(maze, row, col - 1, path, failedPoints) || 
		  getPath(maze, row - 1, col, path, failedPoints)){
		path.add(p);
		return true;
	}

	failedPoints.add(p); // cache result
	return false;
}