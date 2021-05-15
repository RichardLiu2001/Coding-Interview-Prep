class Solution {

	public static int getEarliestTime(int numOfBuildings, int[] buildingOpenTimes, int[] offLoadTimes) {

		Arrays.sort(buildingOpenTimes);

		Arrays.sort(offLoadTimes);

		reverse(offLoadTimes);

		int j = 0;
		int count = 0;
		int time = 0;
		int max = 0;

		for (int i = 0; i < buildingOpenTimes.length; i ++) {

			while (j < offLoadTimes.length && count < 4) {
				time = (buildingOpenTimes[i] + offLoadTimes[j]);
				max = Math.max(max, time);
				count ++;
				j ++;
			}

			count = 0;
		}

		return max;

	}

	public static void reverse(int[] a) {
		for (int i = 0; i < a.length / 2; i ++) {
			int flip = a.length - 1 - i;
			int temp = a[i];
			
			a[i] = a[flip];
			a[flip] = temp;
		}
	}

}