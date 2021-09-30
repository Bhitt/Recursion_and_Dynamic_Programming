/* 
	Solution 1 
	
	Use a boolean array to keep track of chosen parts, and if a partition does not work, backtrack
	and try something else.
*/


/* 
	Time Complexity: O(?) difficult to find exactly but its very large 
	Space Complexity: O(n)
*/

public class Solution {
    public bool CanPartitionKSubsets(int[] nums, int k) {
        // Get the sum of all elements in nums
        int sumOfNums = nums.Sum();
        // Make sure its possible for subsets to equal k
        if(k == 0 || sumOfNums % k != 0){
            return false;
        }
        return CanPartition(0, nums, new bool[nums.Length], k, 0, sumOfNums/k);
    }
    
    bool CanPartition(int start, int[] arr, bool[] used, int k, int currentSum, int targetSum){
        /* Only need to fill k-1 buckets, since that last bucket has to be correct 
            from remainder. IE (Sum=20), First 3 buckets = 15, 5 Remains so correct */
        if(k == 1){ 
            return true;
        }
        /* Finished a bucket */
        if(currentSum == targetSum){
            return CanPartition(0, arr, used, k-1, 0, targetSum); // Reduce k and reset current sum
        }
        /* Try items */
        for(int i = start; i < arr.Length; i++){
            if(!used[i]){
                used[i] = true; // Choose
                if(CanPartition(i+1, arr, used, k, currentSum + arr[i], targetSum)){
                    return true;
                }
                used[i] = false; // Unchoose (Backtracking)
            }
        }
        /* Nothing worked */
        return false;
    }
}

/*
	LEET CODE RESULTS

	Runtime: 100 ms, faster than 59.43% of C# online submissions for Partition to K Equal 
	Sum Subsets.
	Memory Usage: 24.8 MB, less than 45.28% of C# online submissions for Partition to K Equal 
	Sum Subsets.
*/