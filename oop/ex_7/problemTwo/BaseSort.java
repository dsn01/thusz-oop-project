package oop.ex_7.problemTwo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public abstract class BaseSort {
    Map<String, Integer> wordCount = new TreeMap<String, Integer>();

    public final void run() throws Exception {
        read();
        Map<String, Integer> sortedMap = sort(wordCount);
        output(sortedMap);
    }

    public void read() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("D:/idea/oop-project/src/oop/ex_7/problemTwo/text.txt"));
        String readLine = null;
        while ((readLine = bufferedReader.readLine()) != null) {
            readLine = readLine.replaceAll("\r|\n", "");
            String[] words = readLine.split(" ");
            for (String word: words) {
                if (word.length() != 0) {
                    if (wordCount.containsKey(word)) {
                        wordCount.put(word, wordCount.get(word) + 1);
                    }
                    else {
                        wordCount.put(word, 1);
                    }
                }
            }
        }
    }

    public abstract Map<String, Integer> sort(Map<String, Integer> unsortedMap);

    public void output(Map<String, Integer> sortedMap) {
        for (Entry<String, Integer> entry: sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
