In the while I have used count(String s). where s is the answer of n=2. Thats why while is starting from x == 3 till n.
​
Inside while I am storing answer in s only to give input s.
But storing in ans to return as answer of question.
​
In count(String num) method I am simply counting the same consecutive number and then printing the character after it, but the comparison will stop after n-1 and n comparison at nth charachter.
That's why I am appending the last character in the string later.
​
If it was a consecutive number like 111. Then count=3, and ch(n)=1.
If it was like 112. then count=1, c(n)=2.
​
That is why int i is initialized outside for loop. I could have also used s.length()-1.
​