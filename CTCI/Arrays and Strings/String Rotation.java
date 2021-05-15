public boolean stringRotation(String s1, String s2) {

	if (s1.length() == s2.length() && s1.length() > 0) {
		return s1.isSubstring(s2 + s2);
	}

	return false; 

}
