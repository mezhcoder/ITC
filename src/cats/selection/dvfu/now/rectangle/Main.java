package cats.selection.dvfu.now.rectangle;

import java.io.DataInputStream;
import java.io.IOException;

//Task: https://imcs.dvfu.ru/cats/main.pl?f=problem_text;cid=2490392;cpid=2493537;sid=c1jlddzDQjwYXpAWQnZd8dqnY2ytKw

public class Main {
    public static void main(String[] args) throws IOException {
        final String input = new DataInputStream(System.in).readLine();
        final String[] data = input.split(" ");

        double w1 = Integer.parseInt(data[0]);
        double h1 = Integer.parseInt(data[1]);

        double w2 = Integer.parseInt(data[2]);
        double h2 = Integer.parseInt(data[3]);

        if (w2 >= w1/2 && h2 >= h1 || w2 >= w1 && h2 >= h1/2) {
            System.out.print("YES");
        } else if (w2 >= h1/2 && h2>= w1 || w2>= h1 && h2>=w1/2) {
            System.out.print("YES");
        } else  {
            System.out.print("NO");
        }
    }
}