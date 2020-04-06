import java.util.Scanner;

public class SumSubsequence {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        while (in.hasNext()) {
            int N = in.nextInt();
            int L = in.nextInt();
            while ( L <= 100) {
                String res = "";
                if ( L % 2 == 1) {
                    if (N % L == 0 && N / L >= (L - 1) / 2) {
                        for (int i = (N / L - L / 2); i < (N / L + L / 2 + 1); i++) {
                            res += i + " ";
                        }
                        System.out.println(res.substring(0, res.length() - 1));
                        break;
                    }
                } else {
                    if (N % L == L / 2 && N / L >= L / 2 - 1) {
                        for (int i = (N / L - L / 2 + 1); i < (N / L + L / 2 + 1); i++) {
                            res += i + " ";
                        }
                        System.out.println(res.substring(0, res.length() - 1));
                        break;
                    }
                }
                L++;
            }
            if (L > 100) {
                System.out.println("No");
            }
        }
    }
}
