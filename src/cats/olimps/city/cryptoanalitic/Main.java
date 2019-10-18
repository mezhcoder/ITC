package cats.olimps.city.cryptoanalitic;

import java.io.*;

//Task: https://imcs.dvfu.ru/cats/static/problem_text-cpid-2037657.html?sid=lqsOFJDyFbLk4p6JmJwbnKqnTtzu4o

public class Main {
    public static void main(String[] args) throws IOException {
        final DataInputStream dataInputStream = new DataInputStream(new FileInputStream(new File("input.txt")));
        final String line = dataInputStream.readLine();

        char[][] data = data();

        char[] array = line.toCharArray();
        for (int c = array.length-1; c > -1; c-- ) {
            if (c == array.length-1) {
                array[c] = replaceC(data, array[0], array[c]);
                continue;
            }
            array[c] = replaceC(data, array[c+1], array[c]);
        }

        FileWriter fileWriter = new FileWriter(new File("output.txt"));

        for (char c : array) {
            fileWriter.write(c);
        }

        fileWriter.flush();
    }

    public static char replaceC(char[][] data, char cI, char mI) {
        for (int i = 0; i<26; i++) {
            char c = data[i][0];
            if (c == cI) {
                for (int j = 0; j<26; j++) {
                    char m = data[i][j];
                    if (m == mI) {
                        return data[0][j];
                    }
                }
            }
        }
        return ',';
    }

    public static char[][] data() {
        char[][] data = new char[26][26];
        //65 - 65 = 0;
        //90 - 65 = 25;
        int temp = 0;
        for (int i = 0; i<26; i++) {
            for (int j = 0; j<26; j++) {
                data[i][j] = (char) (((j+temp)%26)+65);
            }
            temp++;
        }
        return data;
    }
}