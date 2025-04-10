package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ5212_2 {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int R = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);

        char [][] data = new char[R][C];
        int minX = R;
        int maxX  = -1;
        int minY = C;
        int maxY = -1;
        for (int x = 0; x < R; x++) {
            char [] line = br.readLine().toCharArray();
            for (int y = 0; y < C; y++) {
                data[x][y] = line[y];

                if (line[y] == 'X') {
                    if (x < minX) {
                        minX = x;
                    }
                    if (x > maxX) {
                        maxX = x;
                    }
                    if (y < minY) {
                        minY = y;
                    }
                    if (y > maxY) {
                        maxY = y;
                    }
                }
            }
        }
        int minX2 = R;
        int maxX2  = -1;
        int minY2 = C;
        int maxY2 = -1;
        char [][] data2 = new char[R][C];
        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                int count = 0;
                if (data[x][y] == 'X') {
                    //x-1
                    if (x <= 0) {
                        count++;
                    }else if(data[x-1][y] == '.'){
                        count++;
                    }
                    //x+1
                    if (x >= R - 1) {
                        count++;
                    }else if(data[x+1][y] == '.'){
                        count++;
                    }
                    //y-1
                    if (y <= 0) {
                        count++;
                    } else if (data[x][y-1] == '.'){
                        count++;
                    }
                    //y+1
                    if (y >= C - 1) {
                        count++;
                    } else if (data[x][y+1] == '.'){
                        count++;
                    }

                    if (count >= 3) {
                        data2[x][y] = '.';
                    } else {
                        data2[x][y] = 'X';
                        if (x < minX2) {
                            minX2 = x;
                        }
                        if (x > maxX2) {
                            maxX2 = x;
                        }
                        if (y < minY2) {
                            minY2 = y;
                        }
                        if (y > maxY2) {
                            maxY2 = y;
                        }
                    }
                }else {
                    data2[x][y] = '.';
                }
            }
        }

        for (int x = minX2; x <= maxX2; x++) {
            for (int y = minY2; y <= maxY2; y++) {
                System.out.print(data2[x][y]);
            }
            System.out.println();
        }

    }
}
