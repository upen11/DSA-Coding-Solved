class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        subsetSum(0, candidates, target, 0, list, new ArrayList<>());
        
        return list;
    }
    
    public void subsetSum(int ind, int[] arr, int target,int sum, List<List<Integer>> list, List<Integer> ds) {
        
        if(sum == target) {
            list.add(new ArrayList<>(ds));
            return;
        }
        
        if(ind == arr.length || sum > target) return;

        
        // for(int i=ind; i<arr.length; i++) {
            
            ds.add(arr[ind]);
            sum += arr[ind];
            subsetSum(ind, arr, target, sum, list, ds);
            ds.remove(ds.size()-1);
            sum -= arr[ind];
            
            subsetSum(ind+1, arr, target, sum, list, ds);
        // }
    }
}