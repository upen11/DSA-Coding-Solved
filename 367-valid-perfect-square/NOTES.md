getting TLE, I think because mid * mid may be exeeding int range.
Tried intializing end = 10000. But got wrong answer.
2147395600
O/P - false
Expected- true
​
SOLVED:
we can take mid as long.
and then in if, else type cast to (int).
​