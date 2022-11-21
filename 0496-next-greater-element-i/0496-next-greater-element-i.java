class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            stack1.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            while (!stack1.isEmpty()) {
                int n = stack1.pop();

                if (nums1[i] != n) {
                    stack2.push(n);
                } else if (nums1[i] == n) {
                    stack2.push(n);
                    boolean flag = false;
                    while (!stack1.isEmpty()) {
                        int v = stack1.pop();
                        if (v > n) {
                            stack2.push(v);
                            nums1[i] = v;
                            flag = true;
                            break;
                        } else {
                            stack2.push(v);
                        }
                    }

                    if (flag == false && stack1.isEmpty()) {
                        nums1[i] = -1;
                    }
                }
            }

            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }

        return nums1;
    }
}
