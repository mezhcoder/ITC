package cats.selection.dvfu.old.lifts;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

//Task: https://imcs.dvfu.ru/cats/static/problem_text-cpid-2336634.html?sid=0zsYpaauDAevG2KrZ5VLCLNBPEHgs3

public class Main {

    public static void main(String[] args) throws IOException {
        final DataInputStream dataInputStream = new DataInputStream(new FileInputStream("input.txt"));
        int result = checkRes(dataInputStream.readLine().split(" "));
        final FileWriter fileWriter = new FileWriter("output.txt");
        fileWriter.write(String.valueOf(result));
        fileWriter.close();
    }

    private static int checkRes(String[] args) {
        int res = getMinMoveTime(
                Integer.parseInt(args[0]),
                Integer.parseInt(args[1]),
                Integer.parseInt(args[2]),
                Integer.parseInt(args[3]),
                Integer.parseInt(args[4]));
        return res;
    }

    private static int getMinMoveTime(int n, int l, int e, int v, int t) {
        int path_len = l;
        int stairs_time = path_len * t;
        int elevators_time = getElevatorsMoveTime(n, l, e, v);
        return Math.min(stairs_time, elevators_time);
    }

    private static int getElevatorsMoveTime(int n, int l, int e, int v) {
        int path_len = l;
        int time_to_move = 1;
        int capacity = e * v;
        int rise_count = (int) Math.ceil((double) n/capacity);
        int down_count = rise_count - 1;
        int total_moves = rise_count + down_count;
        int total_time = total_moves * path_len * time_to_move;
        return total_time;
    }
}
