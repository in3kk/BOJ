package 다이나믹_프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 실패
 *
 * https://www.acmicpc.net/problem/11049
 * 문제
 * 크기가 N×M인 행렬 A와 M×K인 B를 곱할 때 필요한 곱셈 연산의 수는 총 N×M×K번이다. 행렬 N개를 곱하는데 필요한 곱셈 연산의 수는 행렬을 곱하는 순서에 따라 달라지게 된다.
 *
 * 예를 들어, A의 크기가 5×3이고, B의 크기가 3×2, C의 크기가 2×6인 경우에 행렬의 곱 ABC를 구하는 경우를 생각해보자.
 *
 * AB를 먼저 곱하고 C를 곱하는 경우 (AB)C에 필요한 곱셈 연산의 수는 5×3×2 + 5×2×6 = 30 + 60 = 90번이다.
 * BC를 먼저 곱하고 A를 곱하는 경우 A(BC)에 필요한 곱셈 연산의 수는 3×2×6 + 5×3×6 = 36 + 90 = 126번이다.
 * 같은 곱셈이지만, 곱셈을 하는 순서에 따라서 곱셈 연산의 수가 달라진다.
 *
 * 행렬 N개의 크기가 주어졌을 때, 모든 행렬을 곱하는데 필요한 곱셈 연산 횟수의 최솟값을 구하는 프로그램을 작성하시오. 입력으로 주어진 행렬의 순서를 바꾸면 안 된다.
 *
 * 입력
 * 첫째 줄에 행렬의 개수 N(1 ≤ N ≤ 500)이 주어진다.
 *
 * 둘째 줄부터 N개 줄에는 행렬의 크기 r과 c가 주어진다. (1 ≤ r, c ≤ 500)
 *
 * 항상 순서대로 곱셈을 할 수 있는 크기만 입력으로 주어진다.
 *
 * 출력
 * 첫째 줄에 입력으로 주어진 행렬을 곱하는데 필요한 곱셈 연산의 최솟값을 출력한다. 정답은 231-1 보다 작거나 같은 자연수이다. 또한, 최악의 순서로 연산해도 연산 횟수가 231-1보다 작거나 같다.
 */
public class BOJ11049 {
    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int data_size = Integer.parseInt(br.readLine());
        int [][] input = new int[data_size][2];
        int [][] sum = new int[data_size][data_size];
        for (int x = 0; x < data_size; x++) {
            String tmp = br.readLine();
            input[x][0] = Integer.parseInt(tmp.split(" ")[0]);
            input[x][1] = Integer.parseInt(tmp.split(" ")[1]);
        }
        for (int x = 2; x <= data_size; x++) {
            for (int y = 0; y <= data_size - x; y++) {
                int j = x+y-1;
                sum[y][j] = Integer.MAX_VALUE;
                for (int z = y; z < j; z++) {
                    int cost = sum[y][z] + sum[z+1][j] + input[y][0] * input[z+1][0] * input[j][1];
                    if (cost < sum[y][j]) {
                        sum[y][j] = cost;
                    }
                }
            }
        }
        System.out.println(sum[0][data_size-1]);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int data_size = Integer.parseInt(br.readLine());
//        List<Integer> input = new ArrayList<>();
//        List<Integer> input2 = new ArrayList<>();
//        for (int x = 0; x < data_size; x++) {
//            String tmp = br.readLine();
//            input.add(Integer.parseInt(tmp.split(" ")[0]));
//            input2.add(Integer.parseInt(tmp.split(" ")[1]));
//        }
//        int result = 0;
//        int min = 0;
//        int a = 0;
//        int b = 0;
//        int c = 0;
//        List<Integer> minIndex;
//        List<Integer> minA;
//        List<Integer> minB;
//        List<Integer> minC;
//        while (input.size() > 1) {
//            min = -1;
//            minIndex = new ArrayList<>();
//            minA = new ArrayList<>();
//            minB = new ArrayList<>();
//            minC = new ArrayList<>();
//            a = 0;
//            b = 0;
//            c = 0;
//            for (int x = 0; x <= input.size()-2; x++) {
//                a = input.get(x);
//                b = input2.get(x);
//                c = input2.get(x+1);
//                if (min == -1) {
//                    min = a * b * c;
//                    minIndex.add(x);
//                    minA.add(a);
//                    minB.add(b);
//                    minC.add(c);
//                } else if(a*b*c <= min) {
//                    if (!(minIndex.lastIndexOf(x) > -1)) {
//                        min = a * b * c;
//                        minIndex.add(x);
//                        minA.add(a);
//                        minB.add(b);
//                        minC.add(c);
//                    }
//                }
//            }
//            for (int x = minIndex.size()-1; x >= 0; x--) {
//                result += min;
//                int index = minIndex.get(x);
//                input.remove(index);
//                input.remove(index);
//                input2.remove(index);
//                input2.remove(index);
//                input.add(index,minA.get(x));
//                input2.add(index,minC.get(x));
//            }
//        }
//        System.out.println(result);
    }
}
