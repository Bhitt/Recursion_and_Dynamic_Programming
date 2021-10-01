/* 
	Solution 1 
	
	Loop through linearly using previous entries to build the next entries.
	If i is a power of 2, the entry is 1.
	Otherwise, the entry should be equal to the previous power of 2 + the entry at the remainder
	after subtracting the previous power of 2.

	For example: entry at i = 12
							= entry at 8 (previous power of 2) + entry at 4 (12 - previous power of 2)
							= 		1000	+	 0100		(1 bit + 1 bit)
							=		1100					(2 bits)
*/


/* 
	Time Complexity: O(n) 
	Space Complexity: O(n)
*/

public class Solution {
    public int[] CountBits(int n) {
        // n = 0
        if(n == 0){
            return new int[1]{0};
        }
        
        // Base cases
        int[] result = new int[n+1];
        result[0] = 0;
        result[1] = 1;
        
        // Powers of two
        int power2 = 2;
        
        for(int i = 2; i < result.Length; i++){
            // Powers of two are always 1 bit
            if(i == power2){
                result[i] = 1;
                power2 *= 2; // next power of 2
            } else {
                result[i] = result[power2/2] + result[i - power2/2];
            }
        }
        return result;
        
    }
}

/*
	LEET CODE RESULTS

	Runtime: 208 ms, faster than 92.91% of C# online submissions for Counting Bits.
	Memory Usage: 30 MB, less than 33.64% of C# online submissions for Counting Bits.
*/