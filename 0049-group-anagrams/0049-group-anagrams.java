class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {}

        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String str = String.valueOf(arr);

            if (map.containsKey(str)) {
                List<String> temp = map.get(str);
                temp.add(s);
                map.put(str, temp);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(str, list);
            }
        }

        for (String m : map.keySet()) {
            List<String> l = map.get(m);
            ans.add(l);
        }

        return ans;
    }
}
