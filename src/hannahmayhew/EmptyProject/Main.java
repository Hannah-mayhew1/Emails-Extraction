package hannahmayhew.EmptyProject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {

        String file = FileReader.getDataFromFile("/Users/hannah.mayhew/documents/work/training/Emails-Extraction/sample.txt");

        List<String> splitWords = splitStringFile(file);

        System.out.println(getEmailAddresses(splitWords));
    }

    public static List<String> splitStringFile(String file) {
        List<String> splitWords = new ArrayList<>();
        String[] split = file.split("\\s+");

        for (int word = 0; word < split.length; word++) {
            splitWords.add(split[word]);
        }

        return splitWords;
    }

    private static Map<String, Integer> getEmailAddresses (List<String> splitWords) {

        Pattern pattern = Pattern.compile(".+@(.+\\..+)");

        Map<String, Integer> listOfDomains = new HashMap<>();

        for (int address = 0; address < splitWords.size(); address++) {

            Matcher matcher = pattern.matcher(splitWords.get(address));

            if (matcher.find()) {
                String domain = matcher.group(1);
                if (listOfDomains.containsKey(domain)) {
                    listOfDomains.put(domain, listOfDomains.get(domain) + 1);
                }
                else {
                    listOfDomains.put(domain, 1);
                }
            }
        }

        return listOfDomains;
    }

}
