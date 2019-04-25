package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

import java.util.*;
import java.util.stream.Collectors;

public class SearcherDubler implements SequenceSearcher {

    private Map<Integer, SearchResult> mapResult;
    private int numberOfCalls = 0;

    public int getNumberOfCalls() {
        return numberOfCalls;
    }

    SearcherDubler()
    {
        this.mapResult = null;
    }

    SearcherDubler(Map<Integer,SearchResult> mapResult)
    {
        this.mapResult = mapResult;
    }

    public SearchResult search(int key, int[] seq) {

        numberOfCalls++;

        return mapResult.get(key);
    }
}
