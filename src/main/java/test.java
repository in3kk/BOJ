import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] arg) throws IOException {
//        List<int[]> testList = new ArrayList<>();
//        testList.add(new int[100]);
//        for (int i : testList.get(0)) {
//            System.out.println(i);
//        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split("");
        String[] data = new String[30];
        for (String datum : data) {
            System.out.print(datum);
        }
        System.out.println();
        System.arraycopy(line, 0, data, 0, line.length);
        for (String datum : data) {
            System.out.print(datum);
        }
    }
}
