class Solution {

    public long distinctNames(String[] ideas) {
        HashMap<Character, Set<String>> hm = new HashMap<>();

        for (String s : ideas) {
            char ch = s.charAt(0);

            String suffix = s.substring(1, s.length());

            if (!hm.containsKey(ch)) {
                hm.put(ch, new HashSet<>());
            }

            hm.get(ch).add(suffix);
        }

        // System.out.println(hm);

        Set<Character> key = hm.keySet();

        List<Character> list = new ArrayList<>(key);

        long res = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                Set<String> l1 = hm.get(list.get(i));
                Set<String> l2 = hm.get(list.get(j));

                Object[] arr = l1.toArray();
                long dup = 0;
                for (int k = 0; k < l1.size(); k++) {
                    if (l2.contains(arr[k])) {
                        dup++;
                    }
                }

                long s2 = (l2.size() - dup);
                long s1 = (l1.size() - dup);

                res += 2 * (s1) * (s2);
            }
        }

        return res;
    }
    // TLE
    /*
    public long distinctNames(String[] ideas) {
        
        List<String> str = Arrays.asList(ideas);
        
        List<String> concatName = new ArrayList<>();
        
        for(int i=0; i<str.size(); i++) {
            String s1 = str.get(i);
            StringBuilder sb1 = new StringBuilder(s1);
            
            for(int j=i+1; j<str.size(); j++) {
                String s2 = str.get(j);
                
                if(s1.charAt(0) == s2.charAt(0)) continue;
                
                StringBuilder sb2 = new StringBuilder(s2);
                
                sb1.setCharAt(0, s2.charAt(0));
                
                sb2.setCharAt(0, s1.charAt(0));
                
                String newS1 = sb1.toString();
                
                String newS2 = sb2.toString();
                
                // System.out.println("newS1 : "+ newS1);
                // System.out.println("newS2 : "+ newS2);
                
                
                if(!str.contains(newS1) && !(str.contains(newS2))) {
                    concatName.add(newS1+" "+newS2);
                    concatName.add(newS2+" "+newS1);
                }
                
                // System.out.println(concatName);
            }
        }
        
        return (long)concatName.size();
    }
    */
}
