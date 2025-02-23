package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/17609
 * 문제
 * 회문(回文) 또는 팰린드롬(palindrome)은 앞 뒤 방향으로 볼 때 같은 순서의 문자로 구성된 문자열을 말한다. 예를 들어 ‘abba’ ‘kayak’, ‘reviver’, ‘madam’은 모두 회문이다. 만일 그 자체는 회문이 아니지만 한 문자를 삭제하여 회문으로 만들 수 있는 문자열이라면 우리는 이런 문자열을 “유사회문”(pseudo palindrome)이라고 부른다. 예를 들어 ‘summuus’는 5번째나 혹은 6번째 문자 ‘u’를 제거하여 ‘summus’인 회문이 되므로 유사회문이다.
 *
 * 여러분은 제시된 문자열을 분석하여 그것이 그 자체로 회문인지, 또는 한 문자를 삭제하면 회문이 되는 “유사회문”인지, 아니면 회문이나 유사회문도 아닌 일반 문자열인지를 판단해야 한다. 만일 문자열 그 자체로 회문이면 0, 유사회문이면 1, 그 외는 2를 출력해야 한다.
 *
 * 입력
 * 입력의 첫 줄에는 주어지는 문자열의 개수를 나타내는 정수 T(1 ≤ T ≤ 30)가 주어진다. 다음 줄부터 T개의 줄에 걸쳐 한 줄에 하나의 문자열이 입력으로 주어진다. 주어지는 문자열의 길이는 3 이상 100,000 이하이고, 영문 알파벳 소문자로만 이루어져 있다.
 *
 * 출력
 * 각 문자열이 회문인지, 유사 회문인지, 둘 모두 해당되지 않는지를 판단하여 회문이면 0, 유사 회문이면 1, 둘 모두 아니면 2를 순서대로 한 줄에 하나씩 출력한다.
 */
public class BOJ17609 {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        ArrayList<List<String>> data = new ArrayList<>();

        List<String> line;
        for (int x = 0; x < size; x++) {
            line = new ArrayList<>(Arrays.asList(br.readLine().split("")));
            data.add(line);
        }

        int [] answer = new int[size];
        for (int x = 0; x < size; x++) {
            line = data.get(x);
            boolean one_check = true;//유사회문 체크
            boolean zero_check = true;//회문 체크
            for (int pointer1 = 0, pointer2 = line.size() - 1; pointer1 < line.size() && pointer2 >= 0; pointer1++, pointer2--) {
//                System.out.println("x = "+ x+" pointer1 = "+ pointer1+" pointer2 = "+pointer2+" size = "+line.size());
                if (Objects.equals(line.get(pointer1), line.get(pointer2))) {
                    continue;
                } else {
                    zero_check = false;
                    //그냥 List<String> temp = line 을 하면 리스트를 복사하는 게 아니라 같은 리스트를 참조하게 되기 때문에 어느 한 곳에 작업을 하면 temp 와 line 모두 바뀐다.
                    List<String> temp = new ArrayList<>(line);
                    line.remove(pointer1);
                    List<String> line_reverse = new ArrayList<>(line);
                    Collections.reverse(line_reverse);
                    if (line.equals(line_reverse)) {
//                        System.out.println("line : "+line);
//                        System.out.println("line reverse : "+line_reverse);
                        break;
                    }else{
                        temp.remove(pointer2);
                        line_reverse = new ArrayList<>(temp);
                        Collections.reverse(line_reverse);
                        if (temp.equals(line_reverse)) {
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
