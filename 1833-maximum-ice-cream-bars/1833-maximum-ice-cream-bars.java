class Solution {
    public int maxIceCream(int[] costs, int coins) {
        
        Arrays.sort(costs);
        
        if(costs[0] > coins) return 0;
        
        int i = 0, ans = 0, sum  = 0;
        while(i < costs.length && sum <= coins) {
            sum += costs[i];
            ans++;
            i++;
        }
        
        if(sum > coins) {
            ans--;
        }
        
        return ans;
    }
}