class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if ((i == 0) || (i > 0 && nums[i - 1] != nums[i])) {
                int left = i + 1;
                int right = nums.length - 1;
                int sum = 0 - nums[i];

                while (left < right) {
                    if (nums[left] + nums[right] == sum) {
                        ans.add(Arrays.asList(nums[i], nums[left], nums[right]));

                        // duplicates check
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right - 1] == nums[right]) right--;

                        left++;
                        right--;
                    } else if (nums[left] + nums[right] > sum) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }

        return ans;
    }
    /*  // TLE
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    boolean flag = false;
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        Collections.sort(list);
                        for (int l = 0; l < ans.size(); l++) {
                            if (ans.get(l).equals(list)) {
                                flag = true;
                                break;
                            }
                        }

                        if (flag == false) {
                            ans.add(list);
                        }
                    }
                }
            }
        }

        return ans;
    }
    */
}
