In the for loop I have used count(String ans). where ans is the answer of n=1. Thats why for is starting from x = 2 till n.
​
Inside for I am storing answer in ans only to give input ans.
ans will return the answer of question also.
​
In count(String num) method I am simply counting the same consecutive number and then printing the character after it, but the comparison will stop after n-1 and n comparison at nth charachter.
That's why I am appending the last character in the string later.
​
If it was a consecutive number like 111. Then count=3, and ch(n)=1.
If it was like 112. then count=1, c(n)=2.
​
That is why int i is initialized outside for loop. I could have also used s.length()-1.
​