class Solution {

    public int firstMissingPositive(int[] nums) {
        if (nums.length == 1 && nums[0] < 0) return 1; // if only one element(-ve) is there then return 1

        Arrays.sort(nums);

        if (nums[0] > 1) return 1; // if the array start from bigger num then missing num is 1

        // [-1,-2,-60,40,43]
        // [-1, 1000]
        // [1, 1000]
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i - 1] <= 0 && nums[i] > 0) { // if the previous num is -ve and current is +ve
                if (nums[i] != 1) return 1; // if the first +ve num is not 1
                
                if(nums[i] == nums[i+1]) continue;
                
                if (nums[i] + 1 != nums[i + 1]) return nums[i] + 1; // if it is 1st then
                // if the next element is not equal to next supposed num then return supposed num
            }
        }

        for (int j = 0; j < nums.length - 1; j++) {
            if(nums[j] == nums[j+1]) continue;
            
            if (nums[j] <= 0 && nums[j + 1] > 0) { // if the current num is -ve and next is +ve,  [-1, 1000]
                if (nums[j + 1] != 1) return 1; // if the first +ve num is not 1
            } else if (nums[j] >= 0 && nums[j] + 1 != nums[j + 1]) return nums[j] + 1;
            // else if all are positive and the next element is not equal to next supposed num then return supposed num
        }

        return nums[nums.length - 1] + 1 <= 0 ? 1 : nums[nums.length - 1] + 1; //if none of above condition satifies that means the missing num is greater, again we make sure that the missing num is not negative or 0, what if all num are -ve
    }
}
