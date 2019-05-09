package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

import java.util.Iterator;

public class SequenceSearcherDubler implements SequenceSearcher {

    private Iterator mockedResultsIterator;

    public SequenceSearcherDubler(Iterable<Boolean> mockedResults) {
        mockedResultsIterator = mockedResults.iterator();
    }

    @Override
    public SearchResult search(int key, int[] seq) {
        SearchResult.Builder builder = SearchResult.builder();

        if (mockedResultsIterator.hasNext()) {
            boolean found = Boolean.TRUE.equals(mockedResultsIterator.next());
            builder.withFound(found);
        }

        return builder.build();
    }
}
