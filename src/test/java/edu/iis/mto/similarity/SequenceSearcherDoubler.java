package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

import java.util.ArrayList;
import java.util.List;

public class SequenceSearcherDoubler implements SequenceSearcher {

    private static int numOfCalls = 0;
    private static List<Boolean> isFound = new ArrayList<>();

    @Override
    public SearchResult search(int key, int[] seq) {

        numOfCalls++;

        SearchResult.Builder builder = SearchResult.builder();
        builder.withFound(isFound.get(isFound.size()-1));
        builder.withFound(isFound.remove(isFound.size()-1));


        return builder.build();
    }

    public static List<Boolean> getIsFound() {
        return isFound;
    }


    public static void setNumOfCalls(int numOfCalls) {
        SequenceSearcherDoubler.numOfCalls = numOfCalls;
    }

    public static int getNumOfCalls() {
        return numOfCalls;
    }
}
