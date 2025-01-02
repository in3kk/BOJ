package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/11725
 * 문제
 * 루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 노드의 개수 N (2 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N-1개의 줄에 트리 상에서 연결된 두 정점이 주어진다.
 *
 * 출력
 * 첫째 줄부터 N-1개의 줄에 각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력한다.
 */
public class BOJ11725 {
    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        ArrayList<Integer> [] node_list = new ArrayList[size+1];

        for (int x = 0; x <= size; x++) {
            node_list[x] = new ArrayList();
        }

        for (int x = 1; x < size; x++) {
            String [] data = br.readLine().split(" ");
            int a = Integer.parseInt(data[0]);
            int b = Integer.parseInt(data[1]);
            node_list[a].add(b);
            node_list[b].add(a);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        boolean [] visitCheck = new boolean[size+1];
        int [] parent = new int[size+1];
        visitCheck[1] = true;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int nextNode : node_list[current]) {
                if (!visitCheck[nextNode]) {
                    visitCheck[nextNode] = true;
                    queue.add(nextNode);
                    parent[nextNode] = current;
                }
            }

        }

        for (int x = 2; x <= size; x++) {
            System.out.println(parent[x]);
        }
    }
}
