so I am thinking how to find the missing numbers. Maybe create a new array of missing numbers. Then it will not use the concept of the Binary search.
​
One other thing, if the number should start from 1 then we can see some patterns
​
the missing numbers can be found by subtracting arr[i] with i+1
​
0   1  2  3  4
1   2  3  4   5        i+1
[2, 3, 4 ,7, 11]
[1, 1, 1, 3, 6]  number of missing nums at a particular index
​
k = 5
​
find the biggest of smallest number or equal num to k
​
1  2  3  4 5  6   7
[1, 5, 6, 8, 9, 10,.......]
​