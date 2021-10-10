class Solution {
	public String[] findRestaurant(String[] list1, String[] list2) {

		if (list2.length < list1.length) {
			return findRestaurant(list2, list1);
		}


		HashMap<String, Integer> firstRestaurant = new HashMap<>();

		for (int i = 0; i < list1.length; i ++) {

			firstRestaurant.put(list1[i], i);

		}

		ArrayList<String> topRestaurants = new ArrayList<>();

		int leastSum = Integer.MAX_VALUE;

		for (int i = 0; i < list2.length; i ++) {

			String restaurant = list2[i];

			if (firstRestaurant.containsKey(restaurant)) {

				int sum = firstRestaurant.get(restaurant) + i;

				if (sum < leastSum) {

					leastSum = sum;

					topRestaurants.clear();
					topRestaurants.add(restaurant);


				} else if (sum == leastSum) {
					topRestaurants.add(restaurant);

				}

			}

		}



		String[] result = new String[topRestaurants.size()];

		for (int i = 0; i < topRestaurants.size(); i ++) {
			result[i] = topRestaurants.get(i);
		}

		return result;

	}




}