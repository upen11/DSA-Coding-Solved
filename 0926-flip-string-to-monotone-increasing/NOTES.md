"0101100011"
​
we want starting elements to be 0's and ending to be 1's so till we receive 1 we will not do anything. When we will have 1 we will increase one. After this if we find a 0 then we will go in else and flip++ it.
So we will get how many flips we should do.
​
One case where number of 0's will be more eg: 00011000, we wiill also check if (one < flip) if yes then we will fill flip with one value as we need to flip 1's to make the entire string 00.