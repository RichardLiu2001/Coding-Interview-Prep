class Solution {

	public String newLabel(String old, int k) {

		if (k == 0) {
			return "";
		}

		if (old.length() < 2) {
			return old;
		}

		int[] freq = new int[26];

		int anchor = 0;

		for (int i = 0; i < old.length(); i ++) {
			
			char c = old.charAt(i);
			freq[c - 'a']++;
			anchor = Math.max(anchor, c - 'a');
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 25; i >= 0; i --) {
			if (freq[i] == 0) {

				if (anchor == i) {
					anchor = i - 1;
				}
				continue;
			}

			if (freq[i] > 0) {
				if (i != anchor) {
					sb.append((char) (i + 'a'));
					freq[i] --;
					i = anchor + 1;
					continue;
				} else if (i == anchor) {
					if (freq[i] > k) {
						for (int j = 0; j < k; j ++) {
							sb.append((char) (i + 'a'));
							freq[i] --;
						}
						continue;
					} else {
						for (int j = 0; j < freq[i]; j ++) {
							sb.append((char) (i + 'a'));
						}
						freq[i] = 0;
						anchor = i - 1;
						continue;
					}
				}
			}


		}

		return sb.toString();

	}



}