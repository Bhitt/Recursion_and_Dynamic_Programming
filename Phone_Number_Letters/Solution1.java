/* 
	Solution 1 
	
	Create a map to hold the phone letters at each phone number. For instance, in the map, 2 maps to
	a list containing "a", "b", "c".

	Run through the string of digits, recursively adding to the combinations that are being built.
	For instance: "23"

		2 -> gives a , b , c ..... recursively move forward with those strings

		3 -> gives def

		so

		a adds def , b adds def, and c adds def recursively.

		The resulting strings look like

		ad ae af 	bd be bf 	cd ce cf

		Return the strings that are built up once you reach the end of the digits.
*/


/* 
	Time Complexity: O(4^n)
	Space Complexity:
*/

class Solution {
    public List<String> letterCombinations(String digits) {
        // Result list of strings
        List<String> result = new ArrayList<String>();
        
        // Empty String Case
        if(digits.equals("")) return result;
        
        // create the map for lookup
        HashMapList<Character, String> phoneMap = new HashMapList<Character, String>();
        phoneMap.put('2', "a");
        phoneMap.put('2', "b");
        phoneMap.put('2', "c");
        phoneMap.put('3', "d");
        phoneMap.put('3', "e");
        phoneMap.put('3', "f");
        phoneMap.put('4', "g");
        phoneMap.put('4', "h");
        phoneMap.put('4', "i");
        phoneMap.put('5', "j");
        phoneMap.put('5', "k");
        phoneMap.put('5', "l");
        phoneMap.put('6', "m");
        phoneMap.put('6', "n");
        phoneMap.put('6', "o");
        phoneMap.put('7', "p");
        phoneMap.put('7', "q");
        phoneMap.put('7', "r");
        phoneMap.put('7', "s");
        phoneMap.put('8', "t");
        phoneMap.put('8', "u");
        phoneMap.put('8', "v");
        phoneMap.put('9', "w");
        phoneMap.put('9', "x");
        phoneMap.put('9', "y");
        phoneMap.put('9', "z");
        
        // recursively add each digit combination
        addCombinations(phoneMap, digits, "", 0, result);
        
        return result;
    }
    
    void addCombinations(HashMapList<Character, String> phoneMap, String digits, String combination, int index, List<String> result){
        // Base case, no digit characters left
        if(index >= digits.length()){
            result.add(combination);
            return;
        }
        
        // Otherwise look up the digit to recurse
        ArrayList<String> mapValues = phoneMap.get(digits.charAt(index));
        for(String s : mapValues){
            addCombinations(phoneMap, digits, combination + s, index + 1, result);
        }
    }
}

public class HashMapList<T, E> {
	private HashMap<T, ArrayList<E>> map = new HashMap<T, ArrayList<E>>();

	/* Insert item into list at key */
	public void put(T key, E item){
		if(!map.containsKey(key)){
			map.put(key, new ArrayList<E>());
		}
		map.get(key).add(item);
	}

	/* Insert list of items at key */
	public void put(T key, ArrayList<E> items){
		map.put(key, items);
	}

	/* Get list of items at key */
	public ArrayList<E> get(T key){
		return map.get(key);
	}

	/* Check if hashmaplist contains key */
	public boolean containsKey(T key){
		return map.containsKey(key);
	}

	/* Check if list at key contains value */
	public boolean containsKeyValue(T key, E value){
		ArrayList<E> list = get(key);
		if(list == null) return false;
		return list.contains(value);
	}

	/* Get the list of keys */
	public Set<T> keySet(){
		return map.keySet();
	}

	@Override
	public String toString(){
		return map.toString();
	}
}

/*
	LEET CODE RESULTS

	Runtime: 2 ms, faster than 50.68% of Java online submissions for Letter Combinations of a Phone 
		Number.
	Memory Usage: 39.9 MB, less than 5.10% of Java online submissions for Letter Combinations of a 
		Phone Number.
*/