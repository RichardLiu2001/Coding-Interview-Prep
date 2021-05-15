class Solution {
	public String[] reorderLogFiles(String[] logs) {

		Comparator<String> logComparator = new Comparator<>() {

			@Override
			public int compare(String log1, String log2) {

				String[] split1 = log1.split(" ", 2);
				String[] split2 = log2.split(" ", 2);

				boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
				boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

    			// both are letter-logs
				if (!isDigit1 && !isDigit2) {
    				// compare the content
					int compare = split1[1].compareTo(split2[1]);

					if (compare != 0) {
						return compare;
					}

					return split1[0].compareTo(split2[0]);
				}

    			// first is a letter log, second is a digit-log
				if(!isDigit1 && isDigit2) {
    				//letter log comes first
					return -1;
				} else if (isDigit1 && !isDigit2) {
					return 1;
				} else {
    				// both digit logs
    				// maintain original order (Arrays.sort is a stable sort)
					return 0;
				}
			}

		};

		Arrays.sort(logs, logComparator);
		return logs;

	}

}
