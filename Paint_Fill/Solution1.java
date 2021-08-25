/* 
	Solution 1 
	
	Using code similar to depth-first search for a graph, we search outwards from a pixel to the
	surrounding pixels. We stop once we've fully traversed all the surrounding pixels of this color.

	We could alternatively implement this using breadth-first search.
*/


/* 
	Time Complexity: 
	Space Complexity: 
*/

enum Color { Black, White, Red, Yellow, Green }

boolean PaintFill(Color[][] screen, int r, int c, Color ncolor){
	if(screen[r][c] == ncolor) return false;
	return PaintFill(screen, r, c, screen[r][c], ncolor);
}

boolean PaintFill(Color[][] screen, int r, int c, Color ocolor, Color ncolor){
	if(r < 0 || r >= screen.length || c < 0 || c >= screen[0].length){
		return false;
	}

	if(screen[r][c] == ocolor){
		screen[r][c] = ncolor;
		PaintFill(screen, r - 1, c, ocolor, ncolor); // up
		PaintFill(screen, r + 1, c, ocolor, ncolor); // down
		PaintFill(screen, r, c - 1, ocolor, ncolor); // left
		PaintFill(screen, r, c + 1, ocolor, ncolor); // right
	}
	return true;
}