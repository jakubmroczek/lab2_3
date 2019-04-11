import edu.iis.mto.search.SearchResult;
import edu.iis.mto.similarity.SequenceSearcherForTest;
import edu.iis.mto.similarity.SimilarityFinder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.HashMap;
import java.util.Map;

public class SimilarityFinderTest {

    @Test
    public void SameSequencesJackardSimilarityTest() {

        Map<Integer, SearchResult> map = new HashMap<>();
        map.put(1, SearchResult.builder().withFound(true).build());
        map.put(2, SearchResult.builder().withFound(true).build());
        map.put(3, SearchResult.builder().withFound(true).build());
        map.put(4, SearchResult.builder().withFound(true).build());
        map.put(5, SearchResult.builder().withFound(true).build());
        map.put(6, SearchResult.builder().withFound(true).build());
        map.put(7, SearchResult.builder().withFound(true).build());

        SequenceSearcherForTest sequenceSercher = new SequenceSearcherForTest(map);

        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSercher);

        int[] seq1 = {1, 2, 3, 4, 5,6,7};
        int[] seq2 = {1, 2, 3, 4, 5,6,7};

        Assertions.assertEquals(1, similarityFinder.calculateJackardSimilarity(seq1, seq2));
    }

    @Test
    public void sequencesZeroLenJackardSimilarityTest() {

        SequenceSearcherForTest sequenceSearcherForTest = new SequenceSearcherForTest();

        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcherForTest);

        int[] seq1 = {};
        int[] seq2 = {};

        Assertions.assertEquals(1, similarityFinder.calculateJackardSimilarity(seq1, seq2));

    }

    @Test
    public void differentSequencesJackardSimilarityTest() {

        Map<Integer, SearchResult> map = new HashMap<>();
        map.put(0, SearchResult.builder().withFound(true).build());
        map.put(1, SearchResult.builder().withFound(false).build());
        map.put(2, SearchResult.builder().withFound(true).build());
        map.put(3, SearchResult.builder().withFound(false).build());
        map.put(4, SearchResult.builder().withFound(true).build());
        map.put(5, SearchResult.builder().withFound(false).build());
        map.put(6, SearchResult.builder().withFound(true).build());


        SequenceSearcherForTest sequenceSearcherForTest = new SequenceSearcherForTest(map);

        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcherForTest);

        int[] seq1 = {0, 1, 2, 3, 4, 5, 6};
        int[] seq2 = {0, 2, 4, 6, 8, 10, 12};

        Assertions.assertEquals(0.4, similarityFinder.calculateJackardSimilarity(seq1, seq2));

    }

    @Test
    public void differentSizesAndSequencesJackardSimilarityTest() {

        Map<Integer, SearchResult> map = new HashMap<>();
        map.put(7, SearchResult.builder().withFound(true).build());
        map.put(8, SearchResult.builder().withFound(false).build());
        map.put(9, SearchResult.builder().withFound(true).build());
        map.put(11, SearchResult.builder().withFound(true).build());
        map.put(13, SearchResult.builder().withFound(false).build());

        SequenceSearcherForTest sequenceSearcherForTest = new SequenceSearcherForTest(map);

        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcherForTest);

        int[] seq1 = {7, 8, 9, 11, 13};
        int[] seq2 = {7, 9, 11, 12, 13, 15};

        Assertions.assertEquals(0.375, similarityFinder.calculateJackardSimilarity(seq1, seq2));

    }

    @Test
    public void EmptySequencesIntersectTest() {

        SequenceSearcherForTest sequenceSearcherForTest = new SequenceSearcherForTest();

        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcherForTest);

        int[] seq1 = {};
        int[] seq2 = {};

        similarityFinder.calculateJackardSimilarity(seq1, seq2);

        Assertions.assertEquals(0, sequenceSearcherForTest.getCounter());

    }

    @Test
    public void sequencesWithNumbersInsideIntersectTest() {

        Map<Integer, SearchResult> map = new HashMap<>();
        map.put(0, SearchResult.builder().withFound(true).build());
        map.put(1, SearchResult.builder().withFound(true).build());
        map.put(3, SearchResult.builder().withFound(true).build());
        map.put(6, SearchResult.builder().withFound(false).build());
        map.put(7, SearchResult.builder().withFound(true).build());

        SequenceSearcherForTest sequenceSearcherForTest = new SequenceSearcherForTest(map);

        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcherForTest);

        int[] seq1 = {0, 1, 3, 6, 7};
        int[] seq2 = {0, 1, 3, 4, 5, 7};

        similarityFinder.calculateJackardSimilarity(seq1, seq2);

        Assertions.assertEquals(4, sequenceSearcherForTest.getCounter());

    }

}
