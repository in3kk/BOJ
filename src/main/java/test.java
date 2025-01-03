import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String arg[]) {
        List<int[]> testList = new ArrayList<>();
        testList.add(new int[100]);
        for (int i : testList.get(0)) {
            System.out.println(i);
        }
    }
}
