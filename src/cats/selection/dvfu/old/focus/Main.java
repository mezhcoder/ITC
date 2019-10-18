package cats.selection.dvfu.old.focus;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

//Task: https://imcs.dvfu.ru/cats/static/problem_text-cpid-2336801.html?sid=0zsYpaauDAevG2KrZ5VLCLNBPEHgs3

public class Main {
    public static void main(String[] args) throws IOException {
        final DataInputStream dataInputStream = new DataInputStream(new FileInputStream("input.txt"));
        int result = run(dataInputStream.readLine().split(" "));
        final FileWriter fileWriter = new FileWriter("output.txt");
        fileWriter.write(String.valueOf(result));
        fileWriter.close();
    }

    public static int run(String[] input) {
        int n = Integer.parseInt(input[0]);
        final int s = Integer.parseInt(input[1]);

        int r = 0;
        while (n > 1) {
            n = (int) Math.ceil((double) n/s);
            r++;
        }
        return r;
    }
}
