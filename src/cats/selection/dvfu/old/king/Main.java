package cats.selection.dvfu.old.king;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Task: https://imcs.dvfu.ru/cats/static/problem_text-cpid-1210805.html?sid=c1jlddzDQjwYXpAWQnZd8dqnY2ytKw

public class Main {
    public static void main(String[] args) throws IOException {
        final Scanner scanner = new Scanner(System.in);
        final List<String> input = new ArrayList<>();

        for (int i = 0; i<7; i++) input.add(scanner.nextLine());

        System.out.print(run(input));
    }

    public static int run(List<String> array) {
        int min = min(array);
        int max = max(array);
        return max-min;
    }

    public static int min(List<String> array) {
        int min = sum(array.get(0));
        for (String s : array) {
            int sumCurElement = sum(s);
            if (min > sumCurElement) {
                min = sumCurElement;
            }
        }
        return min;
    }

    public static int max(List<String> array) {
        int max = 0;
        for (String s : array) {
            int sumCurElement = sum(s);
            if (sumCurElement > max) {
                max = sumCurElement;
            }
        }
        return max;
    }

    public static int sum(String number) {
        String[] temp = number.split(" ");

        int sum = 0;
        for (String s : temp) {
            sum += Integer.parseInt(s);
        }

        return sum;
    }
}