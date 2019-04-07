package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

import java.util.Arrays;

public class SequenceSearcherMock implements SequenceSearcher {

    private int callsCounter = 0;

    @Override
    public SearchResult search(int key, int[] seq) {
        callsCounter++;

        if(key>0 && key<=5 && Arrays.equals(seq, new int[]{1, 2, 3, 4, 5})) {
            return SearchResult.builder().withFound(true).build();
        }

        return SearchResult.builder().withFound(false).build();
    }

    public int getCallsCounter() {
        return callsCounter;
    }

    public void setCallsCounter(int callsCounter) {
        this.callsCounter = callsCounter;
    }
}
