package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class SequenceSearcherMock implements SequenceSearcher {

    private int callsCounter = 0;

    @Override
    public SearchResult search(int key, int[] seq) {
        callsCounter++;

        for(int i = 0; i < seq.length; i++){
            if(key == seq[i]){
                return SearchResult.builder().withFound(true).withPosition(i).build();
            }
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
