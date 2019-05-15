package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

import java.util.Iterator;
import java.util.List;

public class SequenceSearchMock implements SequenceSearcher {

    private List<Boolean> results;
    private Iterator<Boolean> iterator;
    private int calls = 0;

    @Override
    public SearchResult search(int key, int[] seq) {
        calls++;
        return SearchResult.builder().withFound(iterator.next()).build();
    }

    public void setResults(List<Boolean> results) {
        this.results = results;
        this.iterator = results.iterator();
    }

    public int getCalls() {
        return calls;
    }
}
