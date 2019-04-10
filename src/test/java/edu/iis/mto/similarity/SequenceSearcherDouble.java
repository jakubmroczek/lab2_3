package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

import java.util.Map;

public class SequenceSearcherDouble implements SequenceSearcher {

    private int invocationsCounterOfSearchMethod = 0;
    private Map<Integer, SearchResult> map;

    SequenceSearcherDouble(Map<Integer, SearchResult> map) {
        this.map = map;
    }

    @Override
    public SearchResult search(int key, int[] seq) {
        invocationsCounterOfSearchMethod++;
        return map.get(key);
    }

    public int getInvocationsCounterOfSearchMethod() {
        return invocationsCounterOfSearchMethod;
    }
}
