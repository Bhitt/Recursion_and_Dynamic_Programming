/* 
    Solution 1 
    
    Use a recursive depth first search to build up the longest length string.
*/


/* 
    Time Complexity: O(2^N) 
    Space Complexity: O(N)
*/

public class Solution {
    public int MaxLength(IList<string> arr) {
        /* Use a depth first search recursion through arr
           building from an initial empty string */
        return dfs(arr, 0, "");
    }
    
    int dfs(IList<string> arr, int pos, String prefix){
        // Avoid duplicate characters with a set
        HashSet<char> hs = new HashSet<char>();
        foreach(char c in prefix.ToCharArray()){
            hs.Add(c);
        }
        if(prefix.Length != hs.Count){
            return 0;
        }
        
        /* Recurse through possible next options and find
            max length */
        int max = prefix.Length;
        for(int i = pos; i < arr.Count; i++){
            max = Math.Max(max, dfs(arr, i+1, prefix + arr[i]));
        }
        
        return max;
    }
}

/*
    LEETCODE RESULTS

    Runtime: 144 ms, faster than 71.30% of C# online submissions
    Memory Usage: 28.3 MB, less than 40.08% of C# online submissions
*/