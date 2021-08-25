/* 
	Solution 1 
	
	We can think about the recursive algorithm as making a choice, at each step, whether to put a
	particular box in the stack. We will also sort our boxes in descending order by height.

	First, we choose whether or not to put box 0 in the stack. Take one recursive path with box 0
	at the bottom and one recursive path without box 0. Return the better of the two options.

	Repeat with box 1, then box 2, and so on.

	We will use memoization to cache the height of the tallest stack with a particular bottom.
*/


/* 
	Time Complexity: 
	Space Complexity: 
*/

int createStack(ArrayList<Box> boxes){
	Collections.sort(boxes, new BoxComparator());
	int[] stackMap = new int[boxes.size()];
	return createStack(boxes, null, 0, stackMap);
}

int createStack(ArrayList<Box> boxes, Box bottom, int offset, int[] stackMap){
	if(offset >= boxes.size()) return 0; // Base case

	/* height with this bottom */
	Box newBottom = boxes.get(offset);
	int heightWithBottom = 0;
	if(bottom == null || newBottom.canBeAbove(bottom)){
		if(stackMap[offset] == 0){
			stackMap[offset] = createStack(boxes, newBottom, offset + 1, stackMap);
			stackMap[offset] += newBottom.height;
		}
		heightWithBottom = stackMap[offset];
	}

	/* without this bottom */
	int heightWithoutBottom = createStack(boxes, bottom, offset + 1, stackMap);

	/* return the better of the two options */
	return Math.max(heightWithBottom, heightWithoutBottom);
}

public class Box {
	public int width;
	public int height;
	public int depth;
	public Box(int w, int h, int d){
		width = w;
		height = h;
		depth = d;
	}

	public boolean canBeUnder(Box b){
		if(width > b.width && height > b.height && depth > b.depth){
			return true;
		}
		return false;
	}

	public boolean canBeAbove(Box b){
		if (b == null) {
			return true;
		}
		if (width < b.width && height < b.height && depth < b.depth) {
			return true;
		}
		return false;	
	}

	public String toString() {
		return "Box(" + width + "," + height + "," + depth + ")";
	}
}

class BoxComparator implements Comparator<Box> {
	@Override
	public int compare(Box x, Box y){
		return y.height - x.height;
	}
}