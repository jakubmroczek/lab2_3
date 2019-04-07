import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;
import edu.iis.mto.similarity.SequenceSearcherDoubler;
import edu.iis.mto.similarity.SimilarityFinder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class SimilarityFinderTest {

    @Test
    public void calculateJackardSimilarityWithSameSequencesTest(){

        Map<Integer, SearchResult> valueMap = new HashMap<>();
        valueMap.put(1, SearchResult.builder().withFound(true).build());
        valueMap.put(2, SearchResult.builder().withFound(true).build());
        valueMap.put(3, SearchResult.builder().withFound(true).build());
        valueMap.put(4, SearchResult.builder().withFound(true).build());

        SequenceSearcherDoubler sequenceSercher = new SequenceSearcherDoubler(valueMap);

        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSercher);

        int[] seq1 = {1,2,3,4};
        int[] seq2 = {1,2,3,4};

        Assertions.assertEquals(1,similarityFinder.calculateJackardSimilarity(seq1,seq2));
    }

    @Test
    public void calculateJackardSimilarityWithSequencesLenZeroTest(){

        SequenceSearcherDoubler sequenceSearcherDoubler = new SequenceSearcherDoubler();

        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcherDoubler);

        int[] seq1 = {};
        int[] seq2 = {};

        Assertions.assertEquals(1,similarityFinder.calculateJackardSimilarity(seq1,seq2));

    }


    @Test
    public void calculateJackardSimilarityWithDifferentSizesAndSequences(){

        Map<Integer, SearchResult> valueMap = new HashMap<>();
        valueMap.put(0, SearchResult.builder().withFound(true).build());
        valueMap.put(1, SearchResult.builder().withFound(false).build());
        valueMap.put(2, SearchResult.builder().withFound(true).build());
        valueMap.put(5, SearchResult.builder().withFound(true).build());
        valueMap.put(6, SearchResult.builder().withFound(false).build());

        SequenceSearcherDoubler sequenceSearcherDoubler = new SequenceSearcherDoubler(valueMap);

        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcherDoubler);

        int[] seq1 = {0,1,2,5,6};
        int[] seq2 = {0,2,3,4,5,7};

        Assertions.assertEquals(0.375,similarityFinder.calculateJackardSimilarity(seq1,seq2));

    }



}
