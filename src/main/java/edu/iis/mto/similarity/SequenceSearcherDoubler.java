package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class SequenceSearcherDoubler implements SequenceSearcher {

    private boolean[] mockedValues;
    private int counter = 0;

    public SequenceSearcherDoubler(boolean[] mockedValues) {
        this.mockedValues = mockedValues;
    }

    @Override
    public SearchResult search(int key, int[] seq) {
        SearchResult.Builder builder = SearchResult.builder();

        builder.withFound(this.mockedValues[counter++]);

        return builder.build();
    }
}
