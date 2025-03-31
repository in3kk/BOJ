import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class logging {
    public static void main(String[] arg) throws Exception{
        String inputFile = "C:\\Users\\shy47\\Desktop\\logging.txt";
        String outputFile = "C:\\Users\\shy47\\Desktop\\output.txt";

        process(inputFile,outputFile);

    }

    public static void process(String inputFile, String outputFile) throws Exception{

        BufferedReader reader = Files.newBufferedReader(Paths.get(inputFile));
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFile));

        String line;
        int token = 0;
        Pattern [] pattern1 = new Pattern[2];
        pattern1[0] = Pattern.compile("\\[권한이없습니다]");
        pattern1[1] = Pattern.compile("\\[na:na]");
        int cnt  = 0;
        while ((line = reader.readLine()) != null) {

            if (pattern1[token].matcher(line).matches() ) {
                token = (token+1)%2;
                cnt++;
            } else if (token != 1) {
                writer.write(line);
                writer.newLine();
            }
        }
        System.out.println("파일 처리 완료 : "+cnt);
    }
}
