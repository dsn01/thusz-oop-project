package oop.ex_7.problemTwo;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class LengthSort extends BaseSort{
    @Override
    public Map<String, Integer> sort(Map<String, Integer> unsortedMap) {
        Map<String, Integer> sortedMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() < s2.length() ? 1 : -1;
            }
        });
        sortedMap.putAll(unsortedMap);
        return sortedMap;
    }
}
