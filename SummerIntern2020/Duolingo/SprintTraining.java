
public class Main {
    // n is the number of coaches
    public static int SprintTraining(int[] sprint, int n) {
        int[] count = new int[n];
        for (int i = 0; i < sprint.length - 1; i++) {
            int start = Math.min(sprint[i], sprint[i + 1]);
            int end = Math.max(sprint[i], sprint[i + 1]);
            for (int j = start; j <= end; j++) {
                count[j - 1]++;
            }
            print(count);
        }

        int resCount = -1;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] > resCount) {
                resCount = count[i];
                res = i + 1;
            }
        }
        print(count);
        System.out.println("\r "+ res);
        return res;
    }

    public static void print(int[] count) {
        for (int i = 0; i < count.length; i++) {
            System.out.print(count[i]);
        }
        System.out.println("\r");
    }
    public static void main(String[] args) {
        int[] sprint = new int[]{2, 4, 1, 3, 5};
        int n = 5;
        SprintTraining(sprint, n);
    }
}
