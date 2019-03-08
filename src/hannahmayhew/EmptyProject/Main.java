package hannahmayhew.EmptyProject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {

        String file = FileReader.getDataFromFile("/Users/hannah.mayhew/documents/work/training/Emails-Extraction/sample.txt");

        List<String> splitWords = splitStringFile(file);

        System.out.println(searchForSoftwireEmail(splitWords));
    }

    public static int searchForSoftwireEmail (List<String> splitWords) {

        int noOfEmails = 0;

        Pattern pattern = Pattern.compile("@softwire\\.com$");

        for (int words = 0; words < splitWords.size() ; words++) {
            Matcher matcher = pattern.matcher(splitWords.get(words));
            if (matcher.find()) {
                noOfEmails++;
            }
        }
        return noOfEmails;
    }

    public static List<String> splitStringFile(String file) {
        List<String> splitWords = new ArrayList<>();
        String[] split = file.split("\\s+");

        for (int word = 0; word < split.length; word++) {
            splitWords.add(split[word]);
        }

        return splitWords;
    }


}
