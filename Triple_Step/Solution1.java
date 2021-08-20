/* 
	Solution 1 
	
	Memoization Solution
	If we've seen this value of n before, return the cached value. Each time we compute a fresh value,
	add it to the cache.
	Typically we use a HashMap<Integer, Integer> for a cache. In this case, the keys will be 1 through
	n. It's more compact to use an integer array.

	Note: By the time you reach n = 37, you will have overflowed. It is great to communicate this
	to the interviewer.
*/


/* 
	Time Complexity: O(n)
	Space Complexity: 
*/

int countWays(int n){
	int[] memo = new int[n+1];
	Arrays.fill(memo, -1);
	return countWays(n, memo);
}

int countWays(int n, int[] memo){
	if(n < 0){
		return 0;
	} else if(n == 0){
		return 1;
	} else if(memo[n] > -1){
		return memo[n];
	} else {
		memo[n] = countWays(n - 1, memo) + countWays(n - 2, memo) + countWays(n - 3, memo);
		return memo[n];
	}
}
