package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://www.acmicpc.net/problem/20366
 * 언니 엘자와 동생 안나에게는 N개의 눈덩이가 있다. 각 눈덩이 i (1 ≤ i ≤ N)의 지름은 Hi 이다. 하나의 눈사람은 두 개의 눈덩이로 구성되며, 눈덩이 하나를 아래에 두고 그 눈덩이보다 크지 않은 다른 눈덩이를 쌓아올리는 방식으로 만들 수 있다. 이때, 눈사람의 키는 두 눈덩이 지름의 합과 같다.
 *
 * 엘자와 안나는 눈덩이 N개 중 서로 다른 4개를 골라서 눈사람을 각각 1개씩, 총 2개를 만들려고 한다. 두 자매는 두 눈사람의 키의 차이가 작을수록 두 눈사람의 사이가 좋을 것이라고 믿는다. 우리는 엘자와 안나가 가장 사이좋은 두 눈사람을 만들기 위해서 도와주려고 한다.
 *
 *
 *
 * 주어진 N개의 눈덩이를 이용하여 만들 수 있는 두 눈사람의 키 차이 중 최솟값을 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 N (4 ≤ N ≤ 600)이 주어진다.
 *
 * 둘째 줄에는 각 눈덩이 i (1 ≤ i ≤ N)의 지름을 의미하는 정수 Hi (1 ≤ Hi ≤ 109)가 공백으로 구분되어 주어진다.
 *
 * 출력
 * 만들 수 있는 두 눈사람의 키 차이 중 최솟값을 나타내는 정수를 출력하라.
 */
public class BOJ20366 {
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




//        for (int pointerA = 0; pointerA < size - 4; pointerA++) {
//            for (int pointerA2 = pointerA + 1; pointerA2 < size; pointerA2++) {
//                for (int pointerB = pointerA + 1; pointerB < size - 2; pointerB++) {
//                    if (pointerB != pointerA2) {
//                        for (int pointerB2 = pointerB + 1; pointerB2 < size; pointerB2++) {
//                            if (pointerB2 != pointerA2) {
//                                int tmp = (input.get(pointerA)+input.get(pointerA2)) - (input.get(pointerB)+input.get(pointerB2));
//                                tmp = Math.abs(tmp);
////                                System.out.println("pointerA : "+pointerA+" pointerA2 : "+pointerA2+" pointerB : "+pointerB+" pointerB2 : "+pointerB2+" tmp : "+tmp);
//                                if (min > tmp) {
//                                    min = tmp;
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
        System.out.println(min);
    }
}
