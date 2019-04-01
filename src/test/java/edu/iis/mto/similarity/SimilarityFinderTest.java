package edu.iis.mto.similarity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

public class SimilarityFinderTest {

    private SimilarityFinder similarityFinder;

    @Before
    public void initializeBeforeTest() {
        SequenceSearcherDouble sequenceSearcherDouble = new SequenceSearcherDouble();
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

}
