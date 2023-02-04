if (s1Freq.get(key) - s2Freq.getOrDefault(key, -1) != 0) return false;
​
-1 because we have '-' in between too so it will increase the number, so it will never be zero.