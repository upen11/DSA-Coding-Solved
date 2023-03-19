class WordDictionary {
    Set<String> set = null;
    boolean isSingleChar;

    public WordDictionary() {
        this.set = new HashSet<>();
        this.isSingleChar = false;
    }

    public void addWord(String word) {
        set.add(word);

        if (word.length() == 1) isSingleChar = true;
    }

    public boolean search(String word) {
        if (word.contains(".")) {
            if (
                word.equals(".")
            ) { // edge case that slows us down
                return isSingleChar;
            }
            char[] arr = word.toCharArray();
            for (String i : set) { 
                if (i.length() == arr.length) {
                    StringBuilder curr = new StringBuilder();
                    for (int j = 0; j < arr.length; j++) {
                        if (arr[j] == '.') {
                            curr.append('.');
                        } else {
                            curr.append(i.charAt(j));
                        }
                    }
                    if (curr.toString().equals(word)) {
                        return true;
                    }
                }
            }
        }
        return set.contains(word);
    }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
