package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2805 {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] first_line = br.readLine().split(" ");
        int N = Integer.parseInt(first_line[0]);
        int M = Integer.parseInt(first_line[1]);
        String [] second_list = br.readLine().split(" ");
        int[] data = new int[N];
        for (int x = 0; x < N; x++) {
            data[x] = Integer.parseInt(second_list[x]);
        }
        Arrays.sort(data);
        long total;
        int min = 0;
        int max = data[N-1];
        int pivot = 0;

        while (min < max) {
            total = 0;
            pivot = (max + min) / 2;
            for (int x = 0; x < N; x++) {
                total = data[x] > pivot ? total + data[x] - pivot : total;
            }
            if (total >= M) {
                min = pivot+1;
            } else{
                max = pivot;
            }
        }
        System.out.println(min-1);
    }
}
