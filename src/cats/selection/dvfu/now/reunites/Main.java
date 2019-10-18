package cats.selection.dvfu.now.reunites;

import java.io.DataInputStream;
import java.io.IOException;

//Task: https://imcs.dvfu.ru/cats/static/problem_text-cpid-2493512.html?sid=c1jlddzDQjwYXpAWQnZd8dqnY2ytKw

public class Main {

    public static void main(String[] args) throws IOException {
        final String input = new DataInputStream(System.in).readLine();

        int a = Integer.parseInt(input);

        int k = 1;
        int i = 0;

        double x = 2;

        do {

            x = (double) (a - 1) / k;
            if (x == (int) x) {
                if (isRep(a, (int) x)) {
                    i++;
                    if (i == 2) break;
                }
            } else {
                k = foundK(a-1, (int) x);
            }

            k += 1;
        } while (x > 1);

        if (i >= 2)
            System.out.print("YES");
        else
            System.out.print("NO");

    }

    public static int foundK(int a, int x) {
        return (a-1)/x;
    }

    public static boolean isRep(int a, int x) {

        while (a > 0) {
            if (a % x != 1) return false;
            a = a / x;
        }
        return true;
    }
}