package edu.iis.mto.similarity;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimilarityFinderTest {

    @Test public void calculateJackardSimilarityShouldReturnZeroComaThreeAsResult() {

        int[] seq1 = {1,2,3,6,8};
        int[] seq2 = {1,2,4,5,6,7,9,10};

        SearcherDubler searcher = new SearcherDubler();
        SimilarityFinder similarityFinder = new SimilarityFinder(searcher);

        double expectedResult = 0.3;

        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), Matchers.is(expectedResult));
    }

    @Test public void calculateJackardSimilarityForTwoDifferentSequencesShouldReturnZeroAsResult() {

        int[] seq1 = {1,2,3,4,5};
        int[] seq2 = {6,7,8};

        SearcherDubler searcher = new SearcherDubler();
        SimilarityFinder similarityFinder = new SimilarityFinder(searcher);

        double expectedResult = 0;

        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), Matchers.is(expectedResult));
    }

    @Test
    public void searchMethodShouldBeCalledFiveTimes() {

        int[] seq1 = {1,2,3,6,8};
        int[] seq2 = {1,2,4,5,6,7,9,10};

        SearcherDubler searcher = new SearcherDubler();
        SimilarityFinder similarityFinder = new SimilarityFinder(searcher);

        int expectedNumberOfCallsOfSearchMethod = 5;

        similarityFinder.calculateJackardSimilarity(seq1, seq2);

        assertThat(searcher.getNumberOfCalls(), Matchers.is(expectedNumberOfCallsOfSearchMethod));
    }

    @Test (expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIfArgumentIsNull() {
        int[] seq1 = {1,2,3,4,5};

        SearcherDubler searcher = new SearcherDubler();
        SimilarityFinder similarityFinder = new SimilarityFinder(searcher);

        similarityFinder.calculateJackardSimilarity(seq1, null);
    }

    @Test public void calculateJackardSimilarityForTwoTheSameSequencesShouldReturnOneAsResult() {

        int[] seq1 = {1,2,3,4,5};
        int[] seq2 = {1,2,3,4,5};

        SearcherDubler searcher = new SearcherDubler();
        SimilarityFinder similarityFinder = new SimilarityFinder(searcher);

        double expectedResult = 1;

        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), Matchers.is(expectedResult));
    }

    @Test public void calculateJackardSimilarityShouldReturnZeroAsResultIfSecondSequenceIsEmpty() {

        int[] seq1 = {1,2,3,4,5};
        int[] seq2 = {};

        SearcherDubler searcher = new SearcherDubler();
        SimilarityFinder similarityFinder = new SimilarityFinder(searcher);

        double expectedResult = 0;

        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), Matchers.is(expectedResult));
    }

    @Test public void calculateJackardSimilarityShouldReturnOneAsResultIfSequencesAreEmpty() {

        int[] seq1 = {};
        int[] seq2 = {};

        SearcherDubler searcher = new SearcherDubler();
        SimilarityFinder similarityFinder = new SimilarityFinder(searcher);

        double expectedResult = 1;

        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), Matchers.is(expectedResult));
    }
}
