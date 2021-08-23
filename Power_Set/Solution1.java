/* 
	Solution 1 
	
	This problem is a good candidate for the Base Case and Build approach.

	Base Case: n = 0
		empty set: {}

		 Case: n = 1
		there are two subsets {a_1} : {}, {a_1}        //Note: "a_1" is read as "a subscript 1"

		 Case: n = 2
		there are four subsets {a_1, a_2} : {}, {a_1}, {a_2}, {a_1, a_2}.

		 For case n = 3, you can simply clone the subsets in P(2) and add a_3 to them:
		P(2)		= {}, {a_1}, {a_2}, {a_1, a_2}
		P(2) + a_3	= {a_3}, {a_1, a_3}, {a_2, a_3}, {a_1, a_2, a_3}
		When merged together, the lines above make P(3).

	Note: This is the best we can do for time / space complexity. There are slight optimizations if
	we implement this iteratively. An alternate solution exists where you generate all binary numbers
	to represent the set.
*/


/* 
	Time Complexity: O(n2^n)
	Space Complexity: O(n2^n)
*/

ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index){
	ArrayList<ArrayList<Integer>> allsubsets;
	if(set.size() == index){ // Base case - add empty set
		allsubsets = new ArrayList<ArrayList<Integer>>();
		allsubsets.add(new ArrayList<Integer>()); // Empty set
	} else {
		allsubsets = getSubsets(set, index + 1);
		int item = set.get(index);
		ArrayList<ArrayList<Integer>> moresubsets =
			new ArrayList<ArrayList<Integer>>();
		for(ArrayList<Integer> subset : allsubsets){
			ArrayList<Integer> newsubset = new ArrayList<Integer>();
			newsubset.addAll(subset);
			newsubset.add(item);
			moresubsets.add(newsubset);
		}
		allsubsets.addAll(moresubsets);
	}
	return allsubsets;
}