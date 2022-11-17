class Solution {
    
    public static void subsets(int[] arr, int ind, int sum, int target, List<List<Integer>> subset, ArrayList<Integer> list) {
        
        if(sum == target) {
            subset.add(new ArrayList<>(list));
            return;
        }
        else if(ind >= arr.length || sum > target) {
            return;
        }
        else {
            for(int i=ind; i<arr.length; i++) {
                
                sum += arr[i];
                list.add(arr[i]);
                subsets(arr, i, sum, target, subset, list);
                sum -= arr[i];
                list.remove(list.size() - 1);
            }
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        Arrays.sort(candidates);
        
        List<List<Integer>> subset = new ArrayList<>();
        
        subsets(candidates, 0, 0, target, subset, new ArrayList<>());
        
        return subset;
    }
}