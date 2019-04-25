package edu.iis.mto.similarity;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import edu.iis.mto.search.SearchResult;


import static org.junit.Assert.*;

public class SimilarityFinderTest {

    private Map<Integer, SearchResult> map;
    private SearcherDubler searcherDubler;
    private SimilarityFinder similarityFinder;

    @Before
    public void setup() {
        map = new HashMap<>();
        searcherDubler = new SearcherDubler(map);
        similarityFinder = new SimilarityFinder(searcherDubler);
    }

    @Test public void calculateJackardSimilarityShouldReturnZeroComaThreeAsResult() {

        int[] seq1 = {1,2,3,6,8};
        int[] seq2 = {1,2,4,5,6,7,9,10};

        map.put(1, SearchResult.builder().withFound(true).build());
        map.put(2, SearchResult.builder().withFound(true).build());
        map.put(3, SearchResult.builder().withFound(false).build());
        map.put(6, SearchResult.builder().withFound(true).build());
        map.put(8, SearchResult.builder().withFound(false).build());

        double expectedResult = 0.3;

        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), Matchers.is(expectedResult));
    }

    @Test public void calculateJackardSimilarityForTwoDifferentSequencesShouldReturnZeroAsResult() {

        int[] seq1 = {1,2,3,4,5};
        int[] seq2 = {6,7,8};

        map.put(1, SearchResult.builder().withFound(false).build());
        map.put(2, SearchResult.builder().withFound(false).build());
        map.put(3, SearchResult.builder().withFound(false).build());
        map.put(4, SearchResult.builder().withFound(false).build());
        map.put(5, SearchResult.builder().withFound(false).build());

        double expectedResult = 0;

        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), Matchers.is(expectedResult));
    }

    @Test
    public void searchMethodShouldBeCalledFiveTimes() {

        int[] seq1 = {1,2,3,6,8};
        int[] seq2 = {1,2,4,5,6,7,9,10};

        map.put(1, SearchResult.builder().withFound(true).build());
        map.put(2, SearchResult.builder().withFound(true).build());
        map.put(3, SearchResult.builder().withFound(false).build());
        map.put(6, SearchResult.builder().withFound(true).build());
        map.put(8, SearchResult.builder().withFound(false).build());

        int expectedNumberOfCallsOfSearchMethod = 5;

        similarityFinder.calculateJackardSimilarity(seq1, seq2);

        assertThat(searcherDubler.getNumberOfCalls(), Matchers.is(expectedNumberOfCallsOfSearchMethod));
    }

    @Test (expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIfArgumentIsNull() {
        int[] seq1 = {1,2,3,4,5};

        similarityFinder.calculateJackardSimilarity(seq1, null);
    }

    @Test public void calculateJackardSimilarityForTwoTheSameSequencesShouldReturnOneAsResult() {

        int[] seq1 = {1,2,3,4,5};
        int[] seq2 = {1,2,3,4,5};

        map.put(1, SearchResult.builder().withFound(true).build());
        map.put(2, SearchResult.builder().withFound(true).build());
        map.put(3, SearchResult.builder().withFound(true).build());
        map.put(4, SearchResult.builder().withFound(true).build());
        map.put(5, SearchResult.builder().withFound(true).build());

        double expectedResult = 1;

        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), Matchers.is(expectedResult));
    }

    @Test public void calculateJackardSimilarityShouldReturnZeroAsResultIfSecondSequenceIsEmpty() {

        int[] seq1 = {1,2,3,4,5};
        int[] seq2 = {};

        map.put(1, SearchResult.builder().withFound(false).build());
        map.put(2, SearchResult.builder().withFound(false).build());
        map.put(3, SearchResult.builder().withFound(false).build());
        map.put(4, SearchResult.builder().withFound(false).build());
        map.put(5, SearchResult.builder().withFound(false).build());

        double expectedResult = 0;

        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), Matchers.is(expectedResult));
    }

    @Test public void calculateJackardSimilarityShouldReturnOneAsResultIfSequencesAreEmpty() {

        int[] seq1 = {};
        int[] seq2 = {};

        double expectedResult = 1;

        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), Matchers.is(expectedResult));
    }
}
