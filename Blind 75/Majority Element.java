class Solution {
    public int majorityElement(int[] nums) {
        
        HashMap<Integer, Integer> freqs = new HashMap<>();

        for (int num : nums) {

            int currentFreq = freqs.getOrDefault(num, 0);

            if (currentFreq + 1 > nums.length / 2) {
                return num;
            }

            freqs.put(num, currentFreq + 1);
        }

        return -1;

    }
}