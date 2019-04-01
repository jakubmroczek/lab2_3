package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class SequenceSearcherDouble implements SequenceSearcher {

    private int invocationsCounterOfSearchMethod = 0;

    @Override
    public SearchResult search(int key, int[] seq) {
        invocationsCounterOfSearchMethod++;
        SearchResult.Builder builder = SearchResult.builder();

        for (int index = 0; index < seq.length; index++) {
            if (key == seq[index]) {
                builder.withFound(true);
                builder.withPosition(index);
                return builder.build();
            }
        }

        return builder.withFound(false).withPosition(-1).build();
    }

    public int getInvocationsCounterOfSearchMethod() {
        return invocationsCounterOfSearchMethod;
    }
}
