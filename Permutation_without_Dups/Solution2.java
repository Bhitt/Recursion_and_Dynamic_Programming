/* 
	Solution 2
	
	Building from permutations of all n-1 character substrings
*/


/* 
	Time Complexity: 
	Space Complexity: 
*/

ArrayList<String> getPerms(String remainder){
	int len = remainder.length();
	ArrayList<String> result = new ArrayList<String>();

	/* base case */
	if(len == 0){
		result.add(""); // be sure to return an empty string
		return result;
	}

	for(int i=0; i < len; i++){
		/* remove char i and find permutations of remaining characters */
		String before = remainder.substring(0, i);
		String after = remainder.substring(i + 1, len);
		ArrayList<String> partials = getPerms(before + after);

		/* prepend char i to each permutation */
		for(String s : partials){
			result.add(remainder.charAt(i) + s);
		}
	}

	return result;
}