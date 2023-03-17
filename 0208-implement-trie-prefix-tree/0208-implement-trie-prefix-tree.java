class Trie {
    private Set<String> set = null;

    public Trie() {
        set = new HashSet<String>();
    }

    public void insert(String word) {
        set.add(word);
    }

    public boolean search(String word) {
        return set.contains(word);
    }

    public boolean startsWith(String prefix) {
        boolean flag = false;
        int plen = prefix.length();
        for (String s : set) {
            if(s.length() >= plen && s.substring(0, plen).equals(prefix)) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
