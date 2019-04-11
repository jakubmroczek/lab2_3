package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class SequenceSearcherImpl implements SequenceSearcher {

    private boolean[] seqReturn = null;
    private int counter = 0;

    public SequenceSearcherImpl(boolean[] seqReturn) {
        this.seqReturn = seqReturn;
    }

    @Override public SearchResult search(int key, int[] seq) {
        return SearchResult.builder().withFound(seqReturn[counter++]).build();
    }
}
