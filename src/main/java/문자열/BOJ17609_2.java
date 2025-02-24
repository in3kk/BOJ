package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * ArrayList<List<String>> -> ArrayList<String> 형태로 변경
 * 루프마다 새롭게 리스트를 생성하는 방식에서 StringBuilder를 이용해 delete, reverse 수행
 */
public class BOJ17609_2 {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        ArrayList<String> data = new ArrayList<>();

        String line;
        for (int x = 0; x < size; x++) {
            line = br.readLine();
            data.add(line);
        }

        int [] answer = new int[size];
        for (int x = 0; x < size; x++) {
            line = data.get(x);
            boolean one_check = true;//유사회문 체크
            boolean zero_check = true;//회문 체크
            for (int pointer1 = 0, pointer2 = line.length() - 1; pointer1 < line.length() && pointer2 >= 0; pointer1++, pointer2--) {
//                System.out.println("x = "+ x+" pointer1 = "+ pointer1+" pointer2 = "+pointer2+" size = "+line.size());
                if (Objects.equals(line.charAt(pointer1), line.charAt(pointer2))) {
                    continue;
                } else {
                    zero_check = false;
                    //그냥 List<String> temp = line 을 하면 리스트를 복사하는 게 아니라 같은 리스트를 참조하게 되기 때문에 어느 한 곳에 작업을 하면 temp 와 line 모두 바뀐다.
                    StringBuilder temp = new StringBuilder(line).deleteCharAt(pointer1);
                    String temp2 = temp.toString();
                    if (temp2.contentEquals(temp.reverse())) {
//                        System.out.println("line : "+line);
//                        System.out.println("line reverse : "+line_reverse);
                        break;
                    }else{
                        temp = new StringBuilder(line).deleteCharAt(pointer2);
                        temp2 = temp.toString();
                        if (temp2.contentEquals(temp.reverse())) {
//                            System.out.println("temp : "+temp);
//                            System.out.println("line reverse : "+line_reverse);
                            break;
                        }else{
                            one_check = false;
                            break;
                        }
                    }
                }

            }
            if (zero_check) {
                answer[x] = 0;
            } else if (one_check) {
                answer[x] = 1;
            } else {
                answer[x] = 2;
            }
        }

        for (int i : answer) {
            System.out.println(i);
        }
    }
}
