package edu.iis.mto.similarity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

public class SimilarityFinderTest {

    private SimilarityFinder similarityFinder;
    private SequenceSearcherDouble sequenceSearcherDouble;

    @Before
    public void initializeBeforeTest() {
        sequenceSearcherDouble = new SequenceSearcherDouble();
        similarityFinder = new SimilarityFinder(sequenceSearcherDouble);
    }

    @Test
    public void testJackardSimilarityOfEqualSequences() {
        int[] firstSequence = {6, 8, 9};
        int[] secondSequence = {6, 8, 9};
        double expectedResult = 1.0;

        Assert.assertThat(similarityFinder.calculateJackardSimilarity(firstSequence, secondSequence), is(expectedResult));
    }

    @Test
    public void testJackardSimilarityOfEmptySequences() {
        int[] firstSequence = {};
        int[] secondSequence = {};
        double expectedResult = 1.0;

        Assert.assertThat(similarityFinder.calculateJackardSimilarity(firstSequence, secondSequence), is(expectedResult));
    }

    @Test
    public void testJackardSimilarityOfSequencesWithoutEqualElements() {
        int[] firstSequence = {6, 8, 9};
        int[] secondSequence = {106, 108, 109};
        double expectedResult = 0.0;

        Assert.assertThat(similarityFinder.calculateJackardSimilarity(firstSequence, secondSequence), is(expectedResult));
    }

    @Test
    public void testJackardSimilarityOfSequencesWithSomeEqualElements() {
        int[] firstSequence = {6, 8, 9, 10};
        int[] secondSequence = {6, 8, 109};
        double expectedResult = 0.4;

        Assert.assertThat(similarityFinder.calculateJackardSimilarity(firstSequence, secondSequence), is(expectedResult));
    }

    @Test
    public void testJackardSimilarityOfSequencesWhereOneIsEmpty() {
        int[] firstSequence = {6, 8, 9};
        int[] secondSequence = {};
        double expectedResult = 0.0;

        Assert.assertThat(similarityFinder.calculateJackardSimilarity(firstSequence, secondSequence), is(expectedResult));
    }

    @Test(expected = NullPointerException.class)
    public void testJackardSimilarityOfNullSequences() {
        int[] firstSequence = null;
        int[] secondSequence = null;

        similarityFinder.calculateJackardSimilarity(firstSequence, secondSequence);
    }

    @Test
    public void testSearchMethodInvocationsCounterWhereFirstSequenceHasOneElement() {
        int[] firstSequence = {6};
        int[] secondSequence = {6, 8, 9};
        int expectedNumber = 1;

        similarityFinder.calculateJackardSimilarity(firstSequence, secondSequence);
        Assert.assertThat(sequenceSearcherDouble.getInvocationsCounterOfSearchMethod(), is(expectedNumber));
    }

    @Test
    public void testSearchMethodInvocationsCounterWhereFirstSequenceHasThreeElements() {
        int[] firstSequence = {6, 8, 9};
        int[] secondSequence = {6, 8, 9};
        int expectedNumber = 3;

        similarityFinder.calculateJackardSimilarity(firstSequence, secondSequence);
        Assert.assertThat(sequenceSearcherDouble.getInvocationsCounterOfSearchMethod(), is(expectedNumber));
    }

    @Test
    public void testSearchMethodInvocationsCounterWhereFirstSequenceHasNoElements() {
        int[] firstSequence = {};
        int[] secondSequence = {6, 8, 9};
        int expectedNumber = 0;

        similarityFinder.calculateJackardSimilarity(firstSequence, secondSequence);
        Assert.assertThat(sequenceSearcherDouble.getInvocationsCounterOfSearchMethod(), is(expectedNumber));
    }

}
