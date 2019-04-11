package edu.iis.mto.similarity;

import edu.iis.mto.search.SequenceSearcher;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimilarityFinderTest {

    @Test
    public void shouldReturnOne() {

        int[] seq1 = {1, 2, 3, 4};
        int[] seq2 = {1, 2, 3, 4};
        boolean[] seqReturn = {true, true, true, true};

        SequenceSearcher sequenceSearcher = new SequenceSearcherImpl(seqReturn);
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcher);

        double calculatedValue = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        double expected = 1.0;
        assertThat(calculatedValue, is(expected));
    }
}
