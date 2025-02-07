package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ12919_2 {
    static String S;
    static String T;
    static int answer = 0;
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        T = br.readLine();

        dfs(T);
        System.out.println(answer);
    }

    public static void dfs(String t) {
        if (S.length() == t.length()) {
            if (S.equals(t)) {
                answer = 1;
            }
            return;
        }
        if (t.endsWith("A")) {
            dfs(t.substring(0,t.length()-1));
        }
        if(t.startsWith("B")){
            dfs(new StringBuilder(t.substring(1)).reverse().toString());
        }
    }
}
