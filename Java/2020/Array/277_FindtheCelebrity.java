//O(n), O(1)

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        if (n < 2) return -1;
        int possible = 0;
        for (int i = 1; i < n; i++) {
            if (knows(possible, i)) {  // this condition can also be !knows(i, possible), it just a possible condition
                possible = i;
            }
        }

        // verify possible
        for (int i = 0; i < n; i++) {
            if (possible != i && (knows(possible, i) || !knows(i, possible))) {
                return -1;
            }
        }

        return possible;
    }
}
