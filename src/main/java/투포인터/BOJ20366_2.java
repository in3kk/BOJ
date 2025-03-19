package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ20366_2 {
    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int [] input = new int[size];
        String [] data = br.readLine().split(" ");
        for (int x = 0; x < size; x++) {
            input[x] = Integer.parseInt(data[x]);
        }
        Arrays.sort(input);
//        Collections.reverse(input);
        int min = Integer.MAX_VALUE;


        for (int x = 0; x < size; x++) {
            for (int y = x+1; y < size; y++) {
                int sum1 = input[x] + input[y];
                int pointerA = 0;
                int pointerB = size-1;
                while (pointerA < pointerB) {
                    if (pointerA == x || pointerA == y) {
                        pointerA++;
                        continue;
                    }
                    if (pointerB == x || pointerB == y) {
                        pointerB--;
                        continue;
                    }
                    int sum2 = input[pointerA]+input[pointerB];
                    if (min > Math.abs(sum1 - sum2)) {
                        min = Math.abs(sum1 - sum2);
                    }
                    if (sum1 < sum2) {
                        pointerB--;
                    } else if (sum1 > sum2) {
                        pointerA++;
                    } else {
                        min = 0;
                        break;
                    }
                }
            }
        }
        System.out.println(min);
    }
}
