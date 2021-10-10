class Solution {
    public boolean checkIfExist(int[] arr) {
        
        HashSet<Integer> nums = new HashSet<>();

        for (int num : arr) {

            if (nums.contains(num * 2)) {
                return true;
            }

            if (num % 2 == 0 && nums.contains(num / 2)) {
                return true;
            } 

            nums.add(num);
        }

        return false;


    }
}