package oop.ex_7.problemTwo;

import java.util.Map;

public class TrivialSort extends BaseSort{

    @Override
    public Map<String, Integer> sort(Map<String, Integer> unsortedMap) {
        return unsortedMap;
    }
}
