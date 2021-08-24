/* 
	Solution 1 
	
	Although we can't beat a worst case time, we should be able to design an algorithm to beat this
	in many cases. Ideally, we would like to only create the unique permutations, rather than creating
	all permutations and then ruling out the duplicates.

	Start by computing the count of each letter. This hash table representation is the string we can
	generate permutations from.
*/


/* 
	Time Complexity: 
	Space Complexity: 
*/

ArrayList<String> printPerms(String s){
	ArrayList<String> result = new ArrayList<String>();
	HashMap<Character, Integer> map = buildFreqTable(s);
	printPerms(map, "", s.length(), result);
	return result;
}

HashMap<Character, Integer> buildFreqTable(String s){
	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	for(char c : s.toCharArray()){
		if(!map.containsKey(c)){
			map.put(c, 0);
		}
		map.put(c, map.get(c) + 1);
	}
	return map;
}

void printPerms(HashMap<Character, Integer> map, String prefix, int remaining, ArrayList<String> result){
	/* Base case. Permutation has been completed */
	if(remaining == 0){
		result.add(prefix);
		return;
	}

	/* try remaining letters for next char, and generate remaining permutations */
	for(Character c : map.keySet()){
		int count = map.get(c);
		if(count > 0){
			map.put(c, count - 1);
			printPerms(map, prefix + c, remaining - 1, result);
			map.put(c, count);
		}
	}
}