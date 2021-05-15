class Solution {

	// solution using additional data structure
	public static boolean isUnique(String s) {
		// only 128 ASCII chars 
		if (s.length() > 128) {
			return false; 
		}
		HashSet<Character> chars = new HashSet<>();
		for (int i = 0; i < s.length(); i ++) {
			char current = s.charAt(i);
			if (chars.contains(current)) {
				return false;
			}	

			chars.add(current);

		}
		return true;
		// actually is constant space because chars size will never exceed 128
	}

	// solution without using additional storage
	public static boolean isUnique(String s) {
		// sort string?
		// compare neighboring values


	}




}