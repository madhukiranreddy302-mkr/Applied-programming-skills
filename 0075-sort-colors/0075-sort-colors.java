class Solution {
    // madhukiranreddy302-mkr 
    public void sortColors(int[] nums) {
        int zeroPointer = 0;
        int twoPointer = nums.length - 1;
        int i = 0;

        while (i <= twoPointer) {
            if (nums[i] == 0) {
                swap(nums, i, zeroPointer);
                i++;
                zeroPointer++;
            }
            else if (nums[i] == 2) {
                swap(nums, i, twoPointer);
                twoPointer--;
            }
            else { 
                i++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
