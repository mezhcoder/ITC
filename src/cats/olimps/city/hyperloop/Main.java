package cats.olimps.city.hyperloop;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Task is solved by 50%
//Task: https://imcs.dvfu.ru/cats/static/problem_text-cpid-2047845.html?sid=lqsOFJDyFbLk4p6JmJwbnKqnTtzu4o

public class Main {
    public static void main(String[] args) throws IOException {
        final DataInputStream dataInputStream = new DataInputStream(new FileInputStream("input.txt"));

        final String[] firstInput = dataInputStream.readLine().split(" ");

        int n = Integer.parseInt(firstInput[0]);
        int k = Integer.parseInt(firstInput[1]);


        int result = 0;
        if (n > 0 || k > 0) {
            int[] numbers = new int[n];
            boughtTickets(k, dataInputStream, numbers);
            result = sum(numbers, 0, leftPositions(numbers));
        }

        FileWriter fileWriter = new FileWriter("output.txt");
        fileWriter.write(String.valueOf(result % 1000000007));
        fileWriter.flush();
        fileWriter.close();
    }

    //0,-1,0,-1

    private static int sum(int[] numbers, int result, List<Integer> leftPositions) {


        int[] cloneNumbers = numbers.clone();
        List<Integer> tempPositions = new ArrayList<>(leftPositions);

        int a = 0;
        for (int i = 0; i < tempPositions.size(); i++) {
            Integer position = tempPositions.get(i);
            if (isValid(cloneNumbers, position)) {
                cloneNumbers[position] = 1;
                ++a;
                leftPositions.remove(position);
            }
        }

        if (a==0) return result;
        if (a>0) {
            ++result;
            return sum(numbers, result, leftPositions);
        }

        return result;
    }

    private static List<Integer> leftPositions(int[] numbers) {
        final List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) positions.add(i);
        }
        return positions;
    }

    private static boolean isValid(int[] numbers, int position) {

        //-1,-1,x
        if (getNumber(numbers, position-1) == -1 || getNumber(numbers, position-1) == 1) {
            if (getNumber(numbers, position-2) == -1 || getNumber(numbers, position-2) == 1) {
                return false;
            }
        }

        //x,-1,-1
        if (getNumber(numbers, position+1) == -1 || getNumber(numbers, position+1) == 1) {
            if (getNumber(numbers, position+2) == -1 || getNumber(numbers, position+2) == 1) {
                return false;
            }
        }

        if (getNumber(numbers, position-1) == -1 || getNumber(numbers, position-1) == 1) {
            if (getNumber(numbers, position+1) == -1 || getNumber(numbers, position+1) == 1) {
                return false;
            }
        }

        return true;
    }

    private static int getNumber(int[] numbers, int n) {
        int max = numbers.length - 1;

        if (n < 0) return 0;
        if (n > max) return 0;
        return numbers[n];
    }


    private static void boughtTickets(int k, DataInputStream dataInputStream, int[] numbers) throws IOException {
        for (int i = 0; i < k; i++) {
            int n = Integer.parseInt(dataInputStream.readLine());
            numbers[n-1] = -1;
        }

    }

}
