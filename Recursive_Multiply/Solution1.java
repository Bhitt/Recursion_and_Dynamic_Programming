/* 
	Solution 1 
	
	On even numbers, we just divide smaller by 2 and double the result of the recursive call (through
	addition). On odd numbers, we do the same, but then we also add bigger to this result.
*/


/* 
	Time Complexity: O(log s), where s is the smaller of the two numbers
	Space Complexity: 
*/

int minProduct(int a, int b){
	int bigger = a < b ? b : a;
	int smaller = a < b ? a : b;
	return minProductHelper(smaller, bigger);
}

int minProductHelper(int smaller, int bigger){
	if(smaller == 0) return 0;
	else if(smaller == 1) return bigger;

	int s = smaller >> 1 // Divide by 2
	int halfProd = minProductHelper(s, bigger);

	if(smaller % 2 == 0){
		return halfProd + halfProd;
	} else {
		return halfProd + halfProd + bigger;
	}
}