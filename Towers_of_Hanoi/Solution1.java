/* 
	Solution 1 
	
	Recursive Algorithm explanation:

	Base case is when n <= 0.

	move top n - 1 disks from origin to buffer, using destination as a buffer

	move top from origin to destination
	
	move top n - 1 disks from buffer to destination, using origin as a buffer
*/


/* 
	Time Complexity: O(2^n)
	Space Complexity: 
*/

void main(String[] args){
	int n = 3;
	Tower[] towers = new Tower[n];
	for(int i=0; i<3; i++){
		towers[i] = new Tower(i);
	}
}


class Tower {
	private Stack<Integer> disks;
	private int index;
	public Tower(int i){
		disks = new Stack<Integer>();
		index = i;
	}

	public int index(){ return index;}

	public void add(int d){
		if(!disks.isEmpty() && disks.peek() <= d){
			System.out.println("Error placing disk " + d);
		} else {
			disks.push(d);
		}
	}

	public void moveTopTo(Tower t){
		int top = disks.pop();
		t.add(top);
	}

	/* RECURSIVE SOLUTION */
	public void moveDisks(int n, Tower destination, Tower buffer){
		if(n > 0){
			moveDisks(n - 1, buffer, destination);
			moveTopTo(destination);
			buffer.moveDisks(n - 1, destination, this);
		}
	}
}