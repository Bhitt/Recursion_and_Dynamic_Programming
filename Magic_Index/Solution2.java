/* 
	Solution 2
	
	ELEMENTS ARE NOT DISTINCT

	Compare midIndex and midValue for equality first. Then, if they are not equal, we recursively
	search the left and right sides as follows.
	- Left side  : search indices start through Math.min(midIndex - 1, midValue).
	- Right side : search indices Math.max(midIndex + 1, midValue) through end.

*/


/* 
	Time Complexity: 
	Space Complexity: 
*/

int magicFast(int[] array){
	return magicFast(array, 0, array.length - 1);
}

int magicFast(int[] array, int start, int end){
	if(end < start) return -1;

	int midIndex = (start + end) / 2;
	int midValue = array[midIndex];
	if(midValue == midIndex){
		return midIndex;
	}

	/* search left */
	int leftIndex = Math.min(midIndex - 1, midValue);
	int left = magicFast(array, start, leftIndex);
	if(left >= 0){
		return left;
	}

	/* search right */
	int rightIndex = Math.max(midIndex + 1, midValue);
	int right = magicFast(array, rightIndex, end);

	return right;
}