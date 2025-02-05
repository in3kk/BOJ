package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1913 {
    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int[][] arr = new int[size][size];
        int[][] direction = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        int current_direction = 0;
        int posX = 0;
        int posY = 0;
        int currentX = 0;
        int currentY = 0;
        currentX = size / 2;
        currentY = size / 2;
        if (target == 1) {
            posX = currentX;
            posY = currentY;
        }
        arr[currentX][currentY] = 1;
        currentX -= 1;
        for (int x = 2; x <= size * size; x++) {
            arr[currentX][currentY] = x;
            if (target == x) {
                posX = currentX;
                posY = currentY;
            }
            current_direction = (current_direction+1)%4;
            if (arr[currentX + direction[current_direction][0]][currentY + direction[current_direction][1]] != 0) {
                current_direction = (current_direction+3)%4;
            }
            currentX += direction[current_direction][0];
            currentY += direction[current_direction][1];

        }
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                System.out.print(arr[x][y]+" ");
            }
            System.out.println();
        }
        System.out.println((posX+1)+" "+(posY+1));
/**
 *
 * 짝수 > size/2, size/2-1
 * 홀수 > size/2, size/2 > 나머지 버림
 *
 *
 *
 * 10 11 12 13
 * 9  2  3  14   4
 * 8  1  4  15   2, 1
 * 7  6  5  16
 *
 * 26 27 28 29 30 31
 * 25 10 11 12 13 32
 * 24 9  2  3  14 33   6
 * 23 8  1  4  15 34   3, 2
 * 22 7  6  5  16 35
 * 21 20 19 18 17 36
 */

    }
}
