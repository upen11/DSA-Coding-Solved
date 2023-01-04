class Solution {
    public int minimumRounds(int[] tasks) {
        
        if(tasks.length == 1) return -1;
        Arrays.sort(tasks);
        int ans = 0;
        for(int i=1; i<tasks.length; i++) {
            // System.out.println("i : "+ i);
            int j = i;
            int count = 1;
            while(j < tasks.length && tasks[j-1] == tasks[j]) {
                count++;
                j++;
            }
            i = j;
            // System.out.println("j : "+ j);
            if(count == 1 || j == tasks.length-1) return -1;
            else if (count % 3 == 0) {
                ans += count / 3;
            }
            else {
                ans += count / 3 + 1;
            }
        }
        
        return ans;
    }
}