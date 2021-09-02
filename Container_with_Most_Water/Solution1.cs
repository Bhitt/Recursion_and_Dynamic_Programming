/* 
	Solution 1 
	
	Approach: Given an array of heights of lines of boundaries of the container, find the maximum 
	water that can be stored in a container. So start with the first and last element and check the 
	amount of water that can be contained and store that container. Now the question arises is there 
	any better boundaries or lines that can contain maximum water. So there is a clever way to find 
	that. Initially, there are two indices the first and last index pointing to the first and the 
	last element (which acts as boundaries of the container), if the value of first index is less 
	than the value of last index increase the first index else decrease the last index. As the 
	decrease in width is constant, by following the above process the optimal answer can be reached.

	Algorithm: 
		1: Keep two index, first = 0 and last = n-1 and a value max_area that stores the maximum 
			area.
		2: Run a loop until first is less than the last.
		3: Update the max_area with maximum of max_area and 
			min(array[first] , array[last])*(last-first)
		4: If the value at array[first] is greater the array[last] then update last as last – 1 
			else update first as first + 1
		5: Print the maximum area.
*/


/* 
	Time Complexity: O(n)
	Space Complexity: O(1)
*/

public class Solution {
    public int MaxArea(int[] height) {
        // Start with the max width
        int l = 0;
        int r = height.Length -1;
        int area = 0;
        
        // Run a loop until first is less than the last.
        while (l < r)
        {
            // Update max area if needed
            area = Math.Max(area,
                        Math.Min(height[l], height[r]) * (r - l));
            
            // If value at left pointer is less than the right, increment left
            if (height[l] < height[r])
                l += 1;
            // Otherwise, decrement left
            else
                r -= 1;
        }
        return area;
    }
}

/*
	LEETCODE RESULTS

	Runtime: 362 ms, faster than 12.95% of C# online submissions for Container With Most Water.
	Memory Usage: 44.3 MB, less than 62.53% of C# online submissions for Container With Most Water.
*/