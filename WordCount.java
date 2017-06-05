import java.io.*;
import java.util.*;

public class WordCount {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java WordCount <input path>");
            System.exit(-1);
        }

        Set<String> words = new HashSet<>();
        words.addAll(Arrays.asList("hackathon", "Dec", "Chicago", "Java"));
        try {
            InputStream in = new FileInputStream(args[0]);
            Map<String, Integer> wordCount = wordCount(in, words);
            for (String word : wordCount.keySet()) {
                System.out.format("%s  %d\n", word, wordCount.get(word));
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, Integer> wordCount(InputStream in, Set<String> words) {
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, 0);
        }

        Scanner input = new Scanner(in);
        while (input.hasNextLine()) {
            String line = input.nextLine();

            for (String word : words) {
                if (line.toLowerCase().contains(word.toLowerCase())) {
                    wordCount.put(word, wordCount.get(word) + 1);
                }
            }
        }
        return wordCount;
    }
}
