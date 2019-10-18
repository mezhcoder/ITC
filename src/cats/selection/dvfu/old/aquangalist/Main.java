package cats.selection.dvfu.old.aquangalist;

import java.io.DataInputStream;
import java.io.IOException;

//Task: https://imcs.dvfu.ru/cats/static/problem_text-cpid-1934564.html?sid=0zsYpaauDAevG2KrZ5VLCLNBPEHgs3

public class Main {
    public static void main(String[] args) throws IOException {
        final DataInputStream dataInputStream = new DataInputStream(System.in);

        String[] john = dataInputStream.readLine().split(" ");
        String[] enemy = dataInputStream.readLine().split(" ");

        int xj = Integer.parseInt(john[0]);
        int yj = Integer.parseInt(john[1]);
        double hj = Integer.parseInt(john[2]);

        int xs = Integer.parseInt(enemy[0]);
        int ys = Integer.parseInt(enemy[1]);
        int hs = Integer.parseInt(enemy[2]);
        int hu = Integer.parseInt(enemy[3]);



        double speedMan = (double) 1/hu;

        while (hj > 0) {
            if (xj == xs) {

                if (yj == ys) {

                    if (hj == hs || hs <= hj) {
                        System.out.print("NO");
                        return;
                    }

                    hs -= 1;

                } else if (yj < ys) {
                    ys -= 1;
                } else {
                    ys += 1;
                }


            } else if (xj < xs) {
                xs -= 1;
            } else {
                xs += 1;
            }
            hj -= speedMan;
        }

        if (hj == hs) {
            System.out.print("NO");
        } else {
            System.out.print("YES");
        }

    }

}