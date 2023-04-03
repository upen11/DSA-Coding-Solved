class Solution {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int len = people.length;

        int boats = 0;
        int p1 = 0;
        int p2 = len - 1;
        while (p1 <= p2) {
            if (people[p1] + people[p2] <= limit) {
                p1++;
            }
            p2--;
            boats++;
         
        }

        return boats;
    }
}
