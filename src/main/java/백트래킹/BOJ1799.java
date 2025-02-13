package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1799 {
    //    static int[][] field;
//    int[] xdirection = {-1, 1, -1, 1};
//    int[] ydirection = {-1, 1, 1, -1};
//    public static void main(String[] arg) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int size = Integer.parseInt(br.readLine());
//
//        int[][] field = new int[size][size];
//        for (int x = 0; x < size; x++) {
//            String[] line = br.readLine().split(" ");
//            for (int y = 0; y < size; y++) {
//                field[x][y] = Integer.parseInt(line[y]);
//            }
//        }
//    }
//
//    public static void dfs(int[][] field,int size) {
//        //2 = 비숍이 놓인 위치,
//        int cnt = 0;
//        for (int x = 0; x < size; x++) {
//            for (int y = 0; y < size; y++) {
//                if (field[x][y] == 1) {
//                    field[x][y] = 2;
//                    cnt++;
//                }
//                if (field[y][x] == 1) {
//                    field[y][x] =2;
//                    cnt++;
//                }
//                for (int z = 1; z < size; z++) {
//
//                }
//            }
//        }
//    }
    static int N;

    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new boolean[N][N];
        int[] diagDown = new int[2 * N - 1];
        int[] diagUp = new int[2 * N - 1];
        ArrayList<Position> posBlack = new ArrayList<>();
        ArrayList<Position> posWhite = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) == 1;
                if (map[i][j]) {
                    if ((i + j) % 2 == 0)
                        posBlack.add(new Position(i, j));
                    else
                        posWhite.add(new Position(i, j));
                }
            }
        }
        int ans = 0;
        if (!posBlack.isEmpty())
            ans += dfs(posBlack, diagUp, diagDown, 0, 0);
        if (!posWhite.isEmpty())
            ans += dfs(posWhite, diagUp, diagDown, 0, 0);

        System.out.println(ans);
    }

    static int dfs(final ArrayList<Position> positions, final int[] diagUp, final int[] diagDown, int idx, int cnt) {
        if (!(idx < positions.size())) return cnt;
        int ret = 0;

        Position cur = positions.get(idx);
        int diagUpIdx = cur.y - cur.x + N - 1;
        int diagDownIdx = cur.y + cur.x;

        if (diagUp[diagUpIdx] == 0 && diagDown[diagDownIdx] == 0) {
            diagUp[diagUpIdx] += 1;
            diagDown[diagDownIdx] += 1;
            ret = Math.max(dfs(positions, diagUp, diagDown, idx + 1, cnt + 1), ret);
            diagUp[diagUpIdx] -= 1;
            diagDown[diagDownIdx] -= 1;
        }

        ret = Math.max(dfs(positions, diagUp, diagDown, idx + 1, cnt), ret);
        return ret;
    }

    static class Position {
        int y;
        int x;
        Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
