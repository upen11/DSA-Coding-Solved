eg 1, 1, 1, 1, 1, 3, 3
​
freq 1 2 3 4 5
pairs 0 1 3 6 10
​
pairs 1 => prev pairs + prev freq => 0 + 1 = 1
pairs 3  => prev pairs + prev freq => 1 + 2 = 3
pairs 6 => prev pairs + prev freq => 3 + 3 = 6
pairs 10 => prev pairs + prev freq => 6 + 4 = 10
pairs 11 => prev pairs + prev freq => 10 + 1 = 11
​
we can see that there is a pattern, it dependes on prev freq and prev pairs