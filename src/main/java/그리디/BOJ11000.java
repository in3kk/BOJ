package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
class Lecture{
    int begin;
    int end;

    public Lecture(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }
}
public class BOJ11000 {
    public static void main(String arg []) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputCount = Integer.parseInt(br.readLine());

        Lecture [] lectureList = new Lecture[inputCount];
        for (int x = 0; x < inputCount; x++) {
            String[] inputData = br.readLine().split(" ");
            lectureList[x] = new Lecture(Integer.parseInt(inputData[0]), Integer.parseInt(inputData[1]));
        }
        Arrays.sort(lectureList, (l1, l2) -> l1.begin == l2.begin ? l1.end - l2.end : l1.begin - l2.begin);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(lectureList[0].end);
        for (int x = 1; x < inputCount; x++) {
            if (pq.peek() <= lectureList[x].begin) {
                pq.poll();
            }
            pq.offer(lectureList[x].end);
        }
        System.out.println(pq.size());
    }
}
