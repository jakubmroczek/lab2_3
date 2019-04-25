package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

import java.util.Map;

public class SequenceSearcherDoubler implements SequenceSearcher {

    private Map<Integer, SearchResult> valueMap;
    private int counter;

    public int getCounter(){
        return counter;
    }

    public SequenceSearcherDoubler(){
        this.valueMap = null;
        counter = 0;
    }

    public SequenceSearcherDoubler(Map<Integer, SearchResult> valueMap) {
        this.valueMap = valueMap;
        counter = 0;
    }

    @Override
    public SearchResult search(int key, int[] seq) {

        if(valueMap.get(key).isFound()){
            counter++;
        }

        return valueMap.get(key);
    }
}
