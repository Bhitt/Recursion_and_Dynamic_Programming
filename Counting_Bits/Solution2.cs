/* 
	Solution 2 
	
	A more elegant version.

	The entry at i = entry at i/2 + (1 if odd)
*/


/* 
	Time Complexity: O(n) 
	Space Complexity: O(n)
*/

public class Solution {
    public int[] CountBits(int n) {
        var ans = new int[n + 1];
        
        for (int i = 0; i <= n; ++i) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        
        return ans;
    }
}

/*
	LEET CODE RESULTS

	Runtime: 204 ms, faster than 97.48% of C# online submissions for Counting Bits.
	Memory Usage: 29.7 MB, less than 76.66% of C# online submissions for Counting Bits.
*/