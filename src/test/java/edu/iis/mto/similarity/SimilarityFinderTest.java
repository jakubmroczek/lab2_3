package edu.iis.mto.similarity;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimilarityFinderTest {

    private SequenceSearcherMock sequenceSearcherMock = new SequenceSearcherMock();

    @Test
    public void calculateJackardSimilarity_sameSets_shouldReturnOne() {

        int[] s1 = {1, 2, 3, 4, 5};
        int[] s2 = {1, 2, 5, 3, 4};

        SimilarityFinder similarityFinder = new SimilarityFinder(new SequenceSearcherMock());
        double similarity = similarityFinder.calculateJackardSimilarity(s1, s2);
        assertThat(similarity, is(1.0));
    }

    @Test
    public void calculateJackardSimilarity_setsWithEmptyIntersection_shouldReturnZero() {

        int[] s1 = {1, 2, 3};
        int[] s2 = {4, 5, 6};

        SimilarityFinder similarityFinder = new SimilarityFinder(new SequenceSearcherMock());
        double similarity = similarityFinder.calculateJackardSimilarity(s1, s2);
        assertThat(similarity, is(0.0));
    }

    @Test
    public void calculateJackardSimilarity_setsWithNonEmptyIntersection_shouldReturnValueBetween0And1() {

        int[] s1 = {1, 2, 3};
        int[] s2 = {1, 2, 6};

        SimilarityFinder similarityFinder = new SimilarityFinder(new SequenceSearcherMock());
        double similarity = similarityFinder.calculateJackardSimilarity(s1, s2);
        assertThat(similarity, is(0.5));
    }

}