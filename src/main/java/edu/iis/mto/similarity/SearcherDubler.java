package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SearcherDubler implements SequenceSearcher {

    private Map<Integer, SearchResult> map;
    private int numberOfCalls;

    public int getNumberOfCalls() {
        return numberOfCalls;
    }

    SearcherDubler()
    {
        numberOfCalls = 0;
    }

    public SearchResult search(int key, int[] seq) {

        SearchResult.Builder builder = SearchResult.builder();
        List<Integer> list = Arrays.stream(seq).boxed().collect(Collectors.toList());

        numberOfCalls++;

        builder.withFound(list.contains(key));
        builder.withPosition(list.indexOf(key));

        return builder.build();
    }
}
