package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ22946_2 {
    static int [][] data;
    static BOJ22946.tree[] temp_tree;
    static class tree{
        List<Integer> children;
        int parents;

        public tree() {
            children = new ArrayList<>();
            parents = -1;
        }

        public void setChildren(List<Integer> children) {
            this.children = children;
        }

        public void setParents(int parents) {
            this.parents = parents;
        }
    }
    public static int solution(int x, int y){
        double distance = Math.sqrt(Math.pow(data[x][0]-data[y][0],2)+Math.pow(data[x][1]-data[y][1],2));
        if (distance < data[x-1][2]) {
            return x-1;
        } else {
            if(temp_tree[x].parents >= 0){
                return solution(x, temp_tree[x].parents);
            }else {
                return -1;
            }
        }
    }
    public static int findLCA(int x, int y){
        List<Integer> list = new ArrayList<>();
        if (x < y) {
            int tmp = y;
            y = x;
            x = tmp;
        }
        int result = 0;
        while(true){
            if (temp_tree[x].parents == -1) {
                break;
            }
            x = temp_tree[x].parents;
            list.add(x);
        }
        int count2 = 0;
        int index = -1;
        while (true){
            if(temp_tree[y].parents == -1){
                break;
            } else if (list.contains(temp_tree[y].parents)) {
                index = list.indexOf(temp_tree[y].parents);
                break;
            }
            y = temp_tree[y].parents;
            count2++;
        }
        if (count2 == 0) {
            if (index == -1) {
                result = list.size();
            } else {
                result = list.size() - 1 - index;
            }
        } else if (count2 > 0) {
            if (index == -1) {
                result = list.size() + count2;
            } else if (index > -1) {
                result = list.size() + count2 - 1 - index;
            }
        }
        return result;
    }
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        data = new int[size][3];
        String [] input;
        for (int x = 0; x < size; x++) {
            input = br.readLine().split(" ");
            data[x][0] = Integer.parseInt(input[0]);
            data[x][1] = Integer.parseInt(input[1]);
            data[x][2] = Integer.parseInt(input[2]);
        }
        Arrays.sort(data, (a, b)->Integer.compare(b[2],a[2]));

        temp_tree = new BOJ22946.tree[size];
        for (int x = 0; x < size; x++) {
            temp_tree[x] = new BOJ22946.tree();
        }
        for (int x = 1; x < size; x++) {
            int result = solution(x,x-1);
            temp_tree[x].setParents(result);
            if (result > -1) {
                temp_tree[result].children.add(x);
            }
        }
        int max = Integer.MIN_VALUE;
        for (int x = 0; x < size - 1; x++) {
            for (int y = x + 1; y < size; y++) {
                int result = findLCA(x, y);
                if (max < result) {
                    max = result;
                }
            }
        }
        System.out.println(max);
    }
}
