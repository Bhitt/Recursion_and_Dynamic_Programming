/* 
	Solution 1 
	
	Recursively build the string of the next term (with the previous term) until you reach n.
*/


/* 
	Time Complexity: O(n) 
	Space Complexity: O()
*/

public class Solution {
    public string CountAndSay(int n) {
        // Base case
        List<int> nums = new List<int>();
        nums.Add(1);
        if(n == 1) return "1";
        
        return helper(n--, nums);
    }
    
    string helper(int n, List<int> nums){
        int howMany = 0;
        int whatNum = 0;
        List<int> nextNums = new List<int>();
        for(int i = 0; i < nums.Count; i++){
            whatNum = nums[i];
            howMany = 0;
            while(i < nums.Count && nums[i] == whatNum){
                howMany++;
                i++;
            }
            nextNums.Add(howMany);
            nextNums.Add(whatNum);
            i--;
        }
        n--;
        if(n == 1) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < nextNums.Count; i++){
                sb.Append(nextNums[i]);
            }
            return sb.ToString();
        } else {
            return helper(n, nextNums);
        }
    }
}

/*
	LEET CODE RESULTS

	Runtime: 80 ms, faster than 93.48% of C# online submissions for Count and Say.
	Memory Usage: 24.4 MB, less than 81.80% of C# online submissions for Count and Say.
*/