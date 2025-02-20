package 누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ2015 {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] line = br.readLine().split(" ");
        int size = Integer.parseInt(line[0]);
        int target =Integer.parseInt(line[1]);
        long ans = 0;
        line = br.readLine().split(" ");
        int[] sum = new int[size + 1];
        int[] arr = new int[size + 1];
        for (int x = 1; x <= size; x++) {
            arr[x] = Integer.parseInt(line[x-1]);
            sum[x] = sum[x-1]+arr[x];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for (int x = 1; x <= size; x++) {
            ans += map.getOrDefault(sum[x]-target,0);
            map.put(sum[x],map.getOrDefault(sum[x],0)+1);
        }

        System.out.println(ans);
    }
}
