package cats.olimps.city.dominoes;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

//Task: https://imcs.dvfu.ru/cats/static/problem_text-cpid-2047514.html?sid=lqsOFJDyFbLk4p6JmJwbnKqnTtzu4o

public class Main {
    public static void main(String[] args) throws IOException {
        final DataInputStream dataInputStream = new DataInputStream(new FileInputStream("input.txt"));

        int n = Integer.parseInt(dataInputStream.readLine());

        final FileWriter fileWriter = new FileWriter("output.txt");
        fileWriter.write(String.valueOf(run(dataInputStream, n)));
        fileWriter.close();

    }

    public static int run(DataInputStream dataInputStream, int n) throws IOException {

        int curFall = 0;
        int maxFall = 0;

        int r = 0;

        for (int i = 0; i < n; i++) {

            final String[] data = dataInputStream.readLine().split(" ");
            int x = Integer.parseInt(data[0]);
            int h = Integer.parseInt(data[1]);

            if (x > r) {
                curFall = 0;
            }

            r = Math.max(r, x+h);
            maxFall = Math.max(++curFall, maxFall);
        }

        return maxFall;
    }
}
