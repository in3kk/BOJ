package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.acmicpc.net/problem/21275
 * 폰 호석만은 진법 변환의 달인이다. 어떤 진법의 수가 주어져도 모든 다른 진법으로의 변환이 가능한 폰 호석만은 새로운 문제를 내기로 했다. 폰 호석만이 내는 문제는 다음과 같이 진행된다.
 *
 * 먼저 폰 호석만은 수 3개 X, A, B를 결정한다(0 ≤ X < 263, 2 ≤ A ≤ 36, 2 ≤ B ≤ 36, A ≠ B). 이 때 X는 10진법이다. 그 다음에 X를 A진법으로 표현한 수와 B진법으로 표현한 수를 종이에 써 놓는다.
 *
 * 그 다음에 종이에 써져 있는 두 개의 수를 여러분에게 보여주게 된다. 주어진 두 개의 수를 통해 원래 숫자인 X, A, B를 계산해주자. 만약 조건을 만족하는 (X, A, B)로 가능한 조합이 여러 개라면 "Multiple"을 출력하고, 가능한 조합이 없다면 "Impossible"를 출력한다.
 *
 * 입력
 * 첫번째 줄에 X를 A진법으로 표현한 값과 X를 B진법으로 표현한 값이 공백으로 구분되어 주어진다. 각 자리수는 0 이상 z 이하이다. a부터 z 는 10부터 35 를 의미한다.
 *
 * 단, 0을 제외한 각 수는 0 으로 시작하지 않으며, 길이는 최대 70 이다.
 *
 * 출력
 * 만약 문제의 조건에 맞는 X, A, B가 유일하게 존재한다면, X를 십진법으로 표현한 수와 A와 B를 공백으로 나누어 출력하라. 만약 만족하는 경우가 2가지 이상이라면 "Multiple"을, 없다면 "Impossible"을 출력하라.
 */
public class BOJ21275 {
    public static void main(String arg []) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        String [] data = {"0", "0" , "1" , "2" , "3" , "4" , "5" , "6" , "7" , "8" , "9" , "a" , "b" , "c" , "d" , "e" , "f" , "g" ,
                "h" , "i" , "j" , "k" , "l" , "m" , "n" , "o" , "p" , "q" , "r" , "s" , "t" , "u" , "v" , "w" , "x" , "y" , "z"};
        String result = "";
        String [] num1 = input[0].split("");
        String [] num2 = input[1].split("");
        List<String> num1List = new ArrayList<>();
        List<String> num2List = new ArrayList<>();
        num1List.addAll(Arrays.asList(num1));
        num2List.addAll(Arrays.asList(num2));
        int num1Min = 2;
        int num2Min = 2;
        for (int x = 36; x >= 2; x--) {
            if (num1Min == 2 && num1List.lastIndexOf(data[x]) > 0) {
                num1Min = x;
            }
            if (num2Min == 2 && num2List.lastIndexOf(data[x]) > 0) {
                num2Min = x;
            }
            if (num1Min != 0 && num2Min != 0) {
                break;
            }
        }

        for (int x = num1Min; x <= 36; x++) {
            for (int y = num2Min; y <= 36; y++) {
                try {
                    int decNum1 = Integer.parseInt(input[0], x);
                    int decNum2 = Integer.parseInt(input[1], y);
                    if (decNum1 == decNum2 && x != y) {
                        if (result.equals("")) {
                            result = decNum1 + " " + x + " " + y;
                        } else {
                            result = "Multiple";
                            break;
                        }
                    }
                } catch (NumberFormatException e) {

                }
            }
        }
        if (result.equals("")) {
            result = "Impossible";
        }

        System.out.println(result);
    }
}
