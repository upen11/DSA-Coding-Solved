class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> list = new ArrayList<>();
        // To skip the Duplicate Elements, we will sort arr[] and use a While Loop to skip all the Duplicate Elements
        Arrays.sort(candidates);
        
        helperFun(0, candidates, 0, target, list, new ArrayList<>());
        
        return list;
    }
    
    public void helperFun(int i, int[] candidates, int sum, int target, List<List<Integer>> list, List<Integer> subset) {
        
        if(sum == target) {
            list.add(new ArrayList<>(subset));
            return;
        }
        
        // If at any moment, sum becomes greater than target, we don't need to proceed further
        if(sum > target) return;
        
        if(i == candidates.length) return;
        
        // Include the i-th Element into our Subset & Sum
        subset.add(candidates[i]);
        sum += candidates[i];
        
        // Ask recursion to do rest of the task
        helperFun(i+1, candidates, sum, target, list, subset);
        
        // Backtrack and undo the change we have done
        subset.remove(subset.size()-1);
        sum -= candidates[i]; 
        
        // Use the While Loop to skip all the duplicate occurrences of i-th Element
        while(i+1 < candidates.length && candidates[i] == candidates[i+1]) {
            i++;
        }
        
          // Don't pick the i-th Element and ask recursion to do rest of the task
        helperFun(i+1, candidates, sum, target, list, subset);
    }
}