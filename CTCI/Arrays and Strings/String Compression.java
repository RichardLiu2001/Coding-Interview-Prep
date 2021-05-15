
public static String stringCompression(String s) {

	StringBuilder sb = new StringBuilder(); 
	int consecutive = 0;

	for (int i = 0; i < s.length(); i ++) {
		consecutive ++;
		char current = s.charAt(i);
		if (i == s.length() - 1 || current != s.charAt(i + 1)) {
			sb.append("" + current + consecutive);
			consecutive = 0;
		}
	}

	String result = sb.toString();

	return result.length() < s.length() ? result : s;

}