package edu.iis.mto.similarity;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class SimilarityFinderTest {

    int[] firstSequence = {1, 2, 3};
    int secondSequence[] = {1, 2, 3};
    double expectedResult = 1.0;

    @Test
    public void caseThatSequenceHaveSameLengthAndAreSame() {

        SimilarityFinder finder = new SimilarityFinder(new SequenceSearcherStubImpl(new boolean[] {true, true, true}));
        double similarityResult = finder.calculateJackardSimilarity(firstSequence, secondSequence);

        Assert.assertThat(similarityResult, is(expectedResult));
    }

    @Test
    public void caseThatSequenceHaveSameLengthAndNotTheSame() {

        SimilarityFinder finder = new SimilarityFinder(new SequenceSearcherStubImpl(new boolean[] {false, false, false}));
        secondSequence = new int[] {4, 5, 6};
        expectedResult = 0.0;

        double similarityResult = finder.calculateJackardSimilarity(firstSequence, secondSequence);

        Assert.assertThat(similarityResult, is(expectedResult));
    }

    @Test(expected = NullPointerException.class)
    public void caseThatSequencesAreNull() {

        SimilarityFinder finder = new SimilarityFinder(new SequenceSearcherStubImpl(null));
        finder.calculateJackardSimilarity(null, null);

    }

    @Test()
    public void caseThatChecksMethodCalls_WorkProperly() {

        SimilarityFinder finder = new SimilarityFinder(new SequenceSearcherStubImpl(new boolean[] {true, true, true}));
        secondSequence = new int[] {1, 2, 3};
        expectedResult = 1.0;

        double similarityResult1 = finder.calculateJackardSimilarity(firstSequence, secondSequence);
        double similarityResult2 = finder.calculateJackardSimilarity(firstSequence, secondSequence);

        Assert.assertThat(similarityResult1, is(expectedResult));
        Assert.assertThat(similarityResult2, is(expectedResult));
    }

}
