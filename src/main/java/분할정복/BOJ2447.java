package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2447 {
    static String [] answer;
    static String [] pattern = new String[3];

    static String space = " ";
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        pattern[0] = "***";
        pattern[1] = "* *";
        pattern[2] = "***";
        answer = new String[size];
        solution(size);
        for (String s : answer) {
            System.out.println(s);
        }

    }
    public static void solution(int size) {
        if (size > 3) {
            solution(size/3);
            int y = 0;
            for (int x = size / 3; x < size; x++) {
                answer[x] = answer[y];
                y = (y+1)%(size/3);
            }
            for (int x = 0; x < size; x++) {
                if (x / (size / 3) == 1) {
                    answer[x] = answer[x]+space.repeat(answer[x].length())+answer[x];
                } else {
                    answer[x] = answer[x].repeat(3);
                }
            }
            return;
        } else {
            answer[0] = pattern[0];
            answer[1] = pattern[1];
            answer[2] = pattern[2];

            return;
        }
    }
}