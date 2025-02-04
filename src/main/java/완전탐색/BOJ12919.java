package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ12919 {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        String [] array_t = t.split("");
        List<String> list_t = new ArrayList<>();
        for (int x = 0; x < t.length(); x++) {
            list_t.add(array_t[x]);
        }
        for (int x = s.length(); x < t.length(); x++) {
            String lastIndex = list_t.get(list_t.size()-1);
            String beginIndex = list_t.get(0);
            if (beginIndex.equals("B")) {
                if (lastIndex.equals("B")) {
                    Collections.reverse(list_t);
                    list_t.remove(list_t.size()-1);
                } else if (lastIndex.equals("A")) {
                    list_t.remove(list_t.size()-1);
                }
            } else if (beginIndex.equals("A")) {
                if (lastIndex.equals("A")) {
                    list_t.remove(list_t.size()-1);
                } else if (lastIndex.equals("B")) {
                    list_t.remove(list_t.size()-1);
                }
            }
            for (String s1 : list_t) {
                System.out.print(s1);
            }
            System.out.println();
        }
        String tmp = String.join("",list_t);
        if (tmp.equals(s)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        System.out.println(tmp);
    }
}
