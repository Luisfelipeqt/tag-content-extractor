import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        
        var scan = new Scanner(System.in);
        
        int quantityTest = Integer.parseInt(scan.nextLine());

        var regex = Pattern.compile("<(.+)>([^<]+)</\\1>");

        Stream.generate(scan::nextLine)
              .limit(quantityTest)
              .forEach(line -> processLine(regex, line));

        scan.close();
    }

    private static void processLine(Pattern regex, String line) {
        Matcher comparator = regex.matcher(line);

        boolean found = false;

        while (comparator.find()) {
            System.out.println(comparator.group(2));
            found = true;
        }

        if (!found) {
            System.out.println("None");
        }
    }
}
