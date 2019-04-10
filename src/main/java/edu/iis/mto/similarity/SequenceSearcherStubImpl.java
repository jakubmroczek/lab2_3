package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class SequenceSearcherStubImpl implements SequenceSearcher {


    private boolean tab [];
    private int counter;

    public SequenceSearcherStubImpl(boolean[] tab) {
        this.tab = tab;
        this.counter = 0;
    }

    @Override
    public SearchResult search(int key, int[] seq) {
        if(tab.length-1 == counter){
            counter=0;
        }
        return SearchResult.builder().withFound(tab[counter++]).build();
    }
}
