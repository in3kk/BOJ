package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ21275_2 {
    public static void main(String[] arg) throws IOException {
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
