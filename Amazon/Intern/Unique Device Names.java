class Solution {

	public static List<String> uniqueDeviceNames(String[] names) {

		HashMap<String, Integer> counts = new HashMap<>();

		ArrayList<String> result = new ArrayList<>();

		for (String name : names) {

			int occurrences = counts.getOrDefault(name, 0);

			if (occurrences == 0) {
				result.add(name);
			} else {
				result.add(name + occurrences);
			}

			counts.put(name, occurrences + 1);

		}

		return result;

}