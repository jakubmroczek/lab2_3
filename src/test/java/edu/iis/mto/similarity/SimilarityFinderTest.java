package edu.iis.mto.similarity;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimilarityFinderTest {

    private SimilarityFinder similarityFinder = new SimilarityFinder(new SequenceSearcherMock());

    @Test
    public void calculateJackardSimilarity_sameSets_shouldReturnOne() {

        int[] s1 = {1, 2, 3, 4, 5};
        int[] s2 = {1, 2, 5, 3, 4};

        double similarity = similarityFinder.calculateJackardSimilarity(s1, s2);
        assertThat(similarity, is(1.0));
    }

    @Test
    public void calculateJackardSimilarity_setsWithEmptyIntersection_shouldReturnZero() {

        int[] s1 = {1, 2, 3};
        int[] s2 = {4, 5, 6};

        double similarity = similarityFinder.calculateJackardSimilarity(s1, s2);
        assertThat(similarity, is(0.0));
    }

    @Test
    public void calculateJackardSimilarity_setsWithNonEmptyIntersection_shouldReturnValueBetween0And1() {

        int[] s1 = {1, 2, 3};
        int[] s2 = {1, 2, 6};

        double similarity = similarityFinder.calculateJackardSimilarity(s1, s2);
        assertThat(similarity, is(0.5));
    }

    @Test
    public void calculateJackardSimilarity_shouldCallSearchMethodAsManyTimesAsLongFistSequenceIs() {

        int[] s1 = {1, 2, 3, 4};
        int[] s2 = {1, 2, 6};

        SequenceSearcherMock sequenceSearcher = new SequenceSearcherMock();
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcher);
        similarityFinder.calculateJackardSimilarity(s1, s2);
        assertThat(sequenceSearcher.getCallsCounter(), is(s1.length));
    }

    @Test(expected = NullPointerException.class)
    public void calculateJackardSimilarity_sequenceIsNull_shouldThrowException() {

        int[] s1 = null;
        int[] s2 = null;

        similarityFinder.calculateJackardSimilarity(s1, s2);
    }

    @Test
    public void calculateJackardSimilarity_bothSequencesAreEmpty_shouldReturn1() {
        int[] s1 = {};
        int[] s2 = {};

        double similarity = similarityFinder.calculateJackardSimilarity(s1, s2);
        assertThat(similarity, is(1.0));
    }

    @Test
    public void calculateJackardSimilarity_oneSequenceIsEmpty_shouldReturn0() {

        int[] s1 = {1, 2, 6};
        int[] s2 = {};

        double similarity = similarityFinder.calculateJackardSimilarity(s1, s2);
        assertThat(similarity, is(0.0));
    }

}