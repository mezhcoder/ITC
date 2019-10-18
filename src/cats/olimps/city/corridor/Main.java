package cats.olimps.city.corridor;

import java.io.*;

//Task: https://imcs.dvfu.ru/cats/static/problem_text-cpid-2045762.html?sid=lqsOFJDyFbLk4p6JmJwbnKqnTtzu4o

public class Main {
    public static void main(String[] args) throws IOException {
        final DataInputStream dataInputStream = new DataInputStream(new FileInputStream("input.txt"));

        String[] data = dataInputStream.readLine().split(" ");

        int L = Integer.parseInt(data[0]);
        int R = Integer.parseInt(data[1]);
        int A = Integer.parseInt(data[2]);
        int X = Integer.parseInt(data[3]);
        int Y = Integer.parseInt(data[4]);

        int time = run(L,R,A,X,Y);

        final FileWriter fileWriter = new FileWriter("output.txt");
        fileWriter.write(String.valueOf(time));
        fileWriter.close();
    }

    public static int run(int L, int R, int A, int X, int Y) {
        int time = 0;

        if (A <= L && A <= R) return A;
        //L
        time += L;
        time += wait(time, X, Y);

        if (A <= R) return time += (A-L);

        time += R-L;
        time += wait(time, X, Y);
        time += A-R;

        return time;
    }

    public static int wait(int time, int X, int Y) {

        int endIndex = (X+Y)-1;
        int lastFreeIndex = X-1;

        int index = time % (X+Y);

        if (index <= lastFreeIndex) return 0;

        return (endIndex-index)+1;
    }
}
