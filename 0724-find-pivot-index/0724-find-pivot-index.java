class Solution {

    public int pivotIndex(int[] nums) {
        // [0] o/p 0
        if (nums.length == 1) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;

        int sum = 0;
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum == 0) {
            return left;
        } else {
            int index = 0;
            int leftSum = 0;
            int rightSum = sum;
            while (index < right) {
                // System.out.println("index:" + index);
                // System.out.println("leftsum:" + leftSum + ", rightSum:" + rightSum);
                leftSum += nums[index];
                rightSum -= nums[index + 1];

                if (leftSum == rightSum) {
                    return index + 1;
                }

                index++;
            }
        }
        return -1;
    }
}
/* // wrong
        int leftSum = nums[left];
        int rightSum = nums[right];
        
        //[4,3,-7,5]
        // [2,2,1,-5,9]
        while (left < right) {
            System.out.println("left:" + left + ", right:" + right);
            System.out.println("leftsum:" + leftSum + ", rightSum:" + rightSum);
            
            if (leftSum == rightSum) {
                if ((left + 1) == (right - 1)) {
                    return left + 1;
                }
                else if(left+1 == right) {
                    System.out.println("++++++++++++1");
                    return -1;
                }
            }

            if (leftSum > rightSum) {
                right--;
                rightSum += nums[right];
            } else if (leftSum < rightSum) {
                left++;
                leftSum += nums[left];
            }
        }
        
        
        System.out.println("left:" + left + ", right:" + right);
        System.out.println("leftsum:" + leftSum + ", rightSum:" + rightSum);

        if (left == 0 && rightSum == 0) {
            return left;
        } else if (right == nums.length - 1 && leftSum == 0) {
            return right;
        }

        System.out.println("nothing works");
        return -1;
    }
}
*/
