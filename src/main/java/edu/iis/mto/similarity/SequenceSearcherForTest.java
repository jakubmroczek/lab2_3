package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

import java.util.Map;

public class SequenceSearcherForTest implements SequenceSearcher {

    private Map<Integer, SearchResult> map;
    private int counter;

    public int getCounter(){
        return counter;
    }

    public SequenceSearcherForTest(){
        this.map = null;
        counter = 0;
    }

    public SequenceSearcherForTest(Map<Integer, SearchResult> map) {
        this.map = map;
        counter = 0;
    }

    @Override
    public SearchResult search(int key, int[] seq) {

        if(map.get(key).isFound()){
            counter++;
        }

        return map.get(key);
    }
}
